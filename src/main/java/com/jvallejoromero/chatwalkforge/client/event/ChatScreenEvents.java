package com.jvallejoromero.chatwalkforge.client.event;

import com.jvallejoromero.chatwalkforge.ChatWalkForge;
import com.jvallejoromero.chatwalkforge.state.WalkState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = ChatWalkForge.MOD_ID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class ChatScreenEvents {

    @SubscribeEvent
    public static void onScreenOpen(ScreenEvent.Opening event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        System.out.println("forward impulse: " + mc.player.zza);

        if (event.getNewScreen() instanceof ChatScreen && mc.options.keyUp.isDown()) {
            WalkState.setWalkingWhileChatting(true);
        }
    }
}
