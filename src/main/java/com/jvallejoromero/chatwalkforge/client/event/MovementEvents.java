package com.jvallejoromero.chatwalkforge.client.event;

import com.jvallejoromero.chatwalkforge.ChatWalkForge;
import com.jvallejoromero.chatwalkforge.state.WalkState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
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
        } else {
            WalkState.setWalkingWhileChatting(false);
        }
    }
}
