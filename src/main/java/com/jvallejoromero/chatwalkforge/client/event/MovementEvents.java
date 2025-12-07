package com.jvallejoromero.chatwalkforge.client.event;

import com.jvallejoromero.chatwalkforge.ChatWalkForge;
import com.jvallejoromero.chatwalkforge.state.WalkState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.MovementInputUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = ChatWalkForge.MOD_ID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class MovementEvents {

    @SubscribeEvent
    public static void onMovementInput(MovementInputUpdateEvent event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        if (!WalkState.isWalkingWhileChatting()) return;

        boolean chatOpen = mc.screen instanceof ChatScreen;
        if (chatOpen) {
            event.getInput().forwardImpulse = 1.0F;

            if (mc.player.isInWater() && !mc.player.isUnderWater()) {
                event.getInput().jumping = true;
            }

            boolean shouldAutoJump = mc.player.horizontalCollision && isJumpableBlock(mc.player) && !mc.options.autoJump().get();
            if (shouldAutoJump) {
                event.getInput().jumping = true;
            }
        } else {
            WalkState.setWalkingWhileChatting(false);
        }
    }

    private static boolean isJumpableBlock(Player player) {
        Level level = player.level();

        Vec3 dir = player.getLookAngle().normalize().scale(0.5);
        BlockPos front = BlockPos.containing(player.getX() + dir.x, player.getY(), player.getZ() + dir.z);

        BlockState state = level.getBlockState(front);
        VoxelShape shape = state.getCollisionShape(level, front);

        if (shape.isEmpty()) {
            return false;
        }

        double height = shape.max(Direction.Axis.Y);

        if (height < 0.99 || height > 1.01) {
            return false;
        }

        BlockPos above = front.above();
        if (!level.getBlockState(above).getCollisionShape(level, above).isEmpty()) {
            return false;
        }

        return true;
    }

}
