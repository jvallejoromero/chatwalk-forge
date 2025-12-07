package com.jvallejoromero.chatwalkforge;

import com.jvallejoromero.chatwalkforge.client.ChatWalkConfigScreen;
import com.mojang.logging.LogUtils;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ChatWalkForge.MOD_ID)
public class ChatWalkForge
{
    public static final String MOD_ID = "chatwalkforge";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ChatWalkForge(FMLJavaModLoadingContext context)
    {
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register config
        context.registerConfig(ModConfig.Type.CLIENT, Config.SPEC);

        // Register config GUI
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory((mc, parent) -> new ChatWalkConfigScreen(parent)));
    }
}
