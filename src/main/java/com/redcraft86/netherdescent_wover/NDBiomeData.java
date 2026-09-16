package com.redcraft86.netherdescent_wover;

import com.mojang.serialization.MapCodec;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.biome.Biome;

import net.potionstudios.netherdescent.config.configs.WorldGenerationConfig;
import org.betterx.wover.biome.api.data.BiomeGenerationDataContainer;
import org.betterx.wover.generator.api.biomesource.WoverBiomeData;

import org.jetbrains.annotations.NotNull;
import javax.annotation.Nullable;

public final class NDBiomeData extends WoverBiomeData {
    public static final MapCodec<NDBiomeData> CODEC = codec(NDBiomeData::new);
    public static final KeyDispatchDataCodec<NDBiomeData> KEY_CODEC = KeyDispatchDataCodec.of(CODEC);

    public NDBiomeData(
            float fogDensity,
            @NotNull ResourceKey<Biome> biome,
            @NotNull BiomeGenerationDataContainer generationData,
            float terrainHeight,
            float genChance,
            int edgeSize,
            boolean vertical,
            @Nullable ResourceKey<Biome> edge,
            @Nullable ResourceKey<Biome> parent
    ) {
        super(
                fogDensity,
                biome,
                generationData,
                terrainHeight,
                genChance,
                edgeSize,
                vertical,
                edge,
                parent
        );
    }

    @Override
    public KeyDispatchDataCodec<? extends WoverBiomeData> codec()
    {
        return KEY_CODEC;
    }

    @Override
    public boolean isEnabled()
    {
        return WorldGenerationConfig.get().isEnabled(biomeKey);
    }

    @Override
    public boolean isPickable()
    {
        return isEnabled() && super.isPickable();
    }
}
