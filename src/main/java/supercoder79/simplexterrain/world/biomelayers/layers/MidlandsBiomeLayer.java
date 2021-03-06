package supercoder79.simplexterrain.world.biomelayers.layers;

import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;
import supercoder79.simplexterrain.world.biome.BiomePicker;
import supercoder79.simplexterrain.world.biome.SimplexBiomesImpl;

public class MidlandsBiomeLayer implements BiomePassLayer {
    private final Registry<Biome> biomes;

    public MidlandsBiomeLayer(Registry<Biome> biomes) {
        this.biomes = biomes;
    }

    @Override
    public int sample(LayerRandomnessSource rand, int value) {
        BiomePicker picker = SimplexBiomesImpl.getMidlandsBiomePicker(SimplexClimateLayer.REVERSE_ID_MAP[value]);

        return picker == null ? 1 : biomes.getRawId(biomes.get(picker.pickBiome(rand)));
    }
}
