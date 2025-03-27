package com.redlimerl.sleepbackground.mixin;

import com.redlimerl.sleepbackground.SleepBackground;
import net.minecraft.client.gl.GlResourceManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GlResourceManager.class)
public abstract class MixinGLResourceManager {
    @Inject(method = "clearColorAndDepthTextures", at = @At("HEAD"), cancellable = true)
    private void onDraw(CallbackInfo ci) {
        if (SleepBackground.LATEST_LOCK_FRAME) {
            ci.cancel();
        }
    }


    @Inject(method = "setPipelineAndApplyState", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/opengl/GlStateManager;_enableCull()V", remap = false), cancellable = true)
    private void onCull(CallbackInfo ci) {
        if (SleepBackground.LATEST_LOCK_FRAME) ci.cancel();
    }
}
