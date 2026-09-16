package com.redcraft86.netherdescent_wover;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import org.betterx.wover.biome.api.data.BiomeCodecRegistry;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(NDWoverCompat.MOD_ID)
public class NDWoverCompat {
    public static final String MOD_ID = "netherdescent_wover";
    public static final Logger LOGGER = LogUtils.getLogger();
    private static final ResourceLocation BIOME_CODEC = ResourceLocation.parse("netherdescent:biome");

    public NDWoverCompat() {
        if (!BiomeCodecRegistry.BIOME_CODECS.containsKey(BIOME_CODEC)) {
            BiomeCodecRegistry.register(BIOME_CODEC, NDBiomeData.KEY_CODEC);
        } else {
            LOGGER.warn("""
                    Wover biome codec '{}' is already registered.
                    Did Nether Descent add compatibility themselves or is another mod doing it?
                    You probably don't need the Nether Descent Wover Compat mod if that is the case.
            """, BIOME_CODEC);
        }
    }
}
