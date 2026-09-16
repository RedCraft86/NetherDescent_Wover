package com.redcraft86.netherdescent_wover.mixin;

import net.minecraft.server.level.ServerPlayer;

import net.potionstudios.netherdescent.event.ServerEventsHandler;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ServerEventsHandler.class, priority = 1001)
public class MixinServerEventsHandler {
    @Inject(method = "onPlayerJoin", at = @At("HEAD"), cancellable = true)
    private static void nd_wover$onPlayerJoin(ServerPlayer serverPlayer, CallbackInfo ci) {
        // Omit the API warning since if this mod exist, Wover also does and this mod makes it generate the biomes.
        ci.cancel();
    }
}
