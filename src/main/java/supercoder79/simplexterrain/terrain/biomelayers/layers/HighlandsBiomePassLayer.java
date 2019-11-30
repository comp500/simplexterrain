package supercoder79.simplexterrain.terrain.biomelayers.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.layer.type.SouthEastSamplingLayer;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

public enum HighlandsBiomePassLayer implements SouthEastSamplingLayer {
    INSTANCE;

    @Override
    public int sample(LayerRandomnessSource layerRandomnessSource, int se) {
        if (se == Registry.BIOME.getRawId(Biomes.TAIGA)) {
            if (layerRandomnessSource.nextInt(6) == 0) return Registry.BIOME.getRawId(Biomes.MOUNTAIN_EDGE);
            if (layerRandomnessSource.nextInt(6) == 0) return Registry.BIOME.getRawId(Biomes.WOODED_MOUNTAINS);
        }
        return se;
    }
}