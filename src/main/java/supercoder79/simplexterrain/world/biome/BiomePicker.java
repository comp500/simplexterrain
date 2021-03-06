package supercoder79.simplexterrain.world.biome;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.util.LayerRandomnessSource;

/**
 * Picks a biome. Pretty self explanatory.
 * 
 * @author Valoeghese
 */
public class BiomePicker {
	private final List<Entry> biomeEntries = Lists.newArrayList();
	private double weightTotal;

	public Identifier pickBiome(LayerRandomnessSource rand) {
		double randVal = target(rand);
		int i = -1;

		while (randVal >= 0) {
			++i;
			randVal -= biomeEntries.get(i).weight;
		}

		return biomeEntries.get(i).biomeId;
	}

	public void addBiome(Identifier biome, double weight) {
		this.biomeEntries.add(new Entry(biome, weight));
		weightTotal += weight;
	}

	private double target(LayerRandomnessSource random) {
		return (double) random.nextInt(Integer.MAX_VALUE) * weightTotal / Integer.MAX_VALUE;
	}

	public static class Entry {
		private final Identifier biomeId;
		private final double weight;
		public Entry(Identifier biome, double weight) {
			this.biomeId = biome;
			this.weight = weight;
		}

	}
}
