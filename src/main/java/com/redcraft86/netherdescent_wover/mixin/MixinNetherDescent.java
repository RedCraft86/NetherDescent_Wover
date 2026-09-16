package com.redcraft86.netherdescent_wover.mixin;

import com.redcraft86.netherdescent_wover.NDWoverCompat;
import net.potionstudios.netherdescent.NetherDescent;
import net.potionstudios.netherdescent.neoforge.NeoForgePlatformHandler;
import net.potionstudios.netherdescent.neoforge.NetherDescentNeoForge;
import net.potionstudios.netherdescent.world.level.levelgen.biome.BiolithRegister;
import net.potionstudios.netherdescent.world.level.levelgen.biome.TerraBlenderRegister;

import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = NetherDescentNeoForge.class, priority = 1001)
public class MixinNetherDescent {
    @Inject(method = "onInitialize", at = @At("HEAD"), cancellable = true)
    private void nd_wover$onInitialize(FMLCommonSetupEvent event, CallbackInfo ci) {
        event.enqueueWork(() -> {
            NetherDescent.commonSetup();
            if (ModList.get().isLoaded("biolith")) {
                BiolithRegister.register();
            } else if (ModList.get().isLoaded("terrablender")) {
                TerraBlenderRegister.register();
            }

            // Omit the API warning since if this mod exist, Wover also does and this mod makes it generate the biomes.

            NeoForgePlatformHandler.registerPottedPlants();
        });

        ci.cancel();
    }
}
