package com.jvallejoromero.chatwalkforge.client;

import com.jvallejoromero.chatwalkforge.Config;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import org.jetbrains.annotations.NotNull;

public class ChatWalkConfigScreen extends Screen {

    private final Screen parent;

    public ChatWalkConfigScreen(Screen parent) {
        super(Component.literal("ChatWalk Forge Config"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        int centerX = this.width / 2;
        int y = this.height / 3;

        addRenderableWidget(
                Button.builder(getChatWalkToggleLabel(), button -> {
                            boolean newValue = !Config.enableChatWalk;
                            Config.setEnableChatWalk(newValue);
                            button.setMessage(getChatWalkToggleLabel());
                        })
                        .bounds(centerX - 100, y, 200, 20)
                        .build()
        );

        addRenderableWidget(
                Button.builder(getToggleAutoJumpLabel(), button -> {
                            boolean newValue = !Config.enableChatWalkAutoJump;
                            Config.setEnableChatWalkAutoJump(newValue);
                            button.setMessage(getToggleAutoJumpLabel());
                        })
                        .bounds(centerX - 100, y + 24, 200, 20)
                        .build()
        );

        addRenderableWidget(
                Button.builder(Component.translatable("gui.done"), button -> {
                            if (this.minecraft != null) {
                                this.minecraft.setScreen(parent);
                            }
                        })
                        .bounds(centerX - 100, y + 48, 200, 20)
                        .build()
        );
    }

    @Override
    public void render(@NotNull GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        guiGraphics.drawCenteredString(this.font, this.title, this.width / 2, this.height / 6, 0xFFFFFF);
    }

    @Override
    public void onClose() {
        if (this.minecraft != null) {
            this.minecraft.setScreen(parent);
        }
        super.onClose();
    }

    private Component getChatWalkToggleLabel() {
        Component state = Config.enableChatWalk
                ? Component.literal("ON").withStyle(ChatFormatting.GREEN)
                : Component.literal("OFF").withStyle(ChatFormatting.RED);

        return Component.literal("Enable Chat Walk: ").append(state);
    }

    private Component getToggleAutoJumpLabel() {
        Component state = Config.enableChatWalkAutoJump
                ? Component.literal("ON").withStyle(ChatFormatting.GREEN)
                : Component.literal("OFF").withStyle(ChatFormatting.RED);

        return Component.literal("Enable Auto Jump: ").append(state);
    }

}
