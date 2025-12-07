package com.jvallejoromero.chatwalkforge;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = ChatWalkForge.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {

    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue ENABLE_CHAT_WALK = BUILDER
            .comment("Allow walking while the chat screen is open")
            .define("enableChatWalk", true);
    private static final ForgeConfigSpec.BooleanValue ENABLE_CHAT_WALK_AUTOJUMP = BUILDER
            .comment("Jump over blocks automatically if you are walking while chatting")
            .define("enableChatWalkAutoJump", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean enableChatWalk;
    public static boolean enableChatWalkAutoJump;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        enableChatWalk = ENABLE_CHAT_WALK.get();
        enableChatWalkAutoJump = ENABLE_CHAT_WALK_AUTOJUMP.get();
    }

    public static void setEnableChatWalk(boolean value) {
        ENABLE_CHAT_WALK.set(value);
        enableChatWalk = value;
    }
    public static void setEnableChatWalkAutoJump(boolean value) {
        ENABLE_CHAT_WALK_AUTOJUMP.set(value);
        enableChatWalkAutoJump = value;
    }

}
