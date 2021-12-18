package oresAboveDiamonds.world;

import java.util.List;

import com.google.common.collect.ImmutableList;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import oresAboveDiamonds.OresAboveDiamonds;
import oresAboveDiamonds.config.OADConfig;
import oresAboveDiamonds.init.ModBlocks;

@EventBusSubscriber
public class OreGeneration {	
    
	public static ConfiguredFeature<?, ?> AMETHYST;
	public static ConfiguredFeature<?, ?> BLACK_OPAL;
	public static ConfiguredFeature<?, ?> AMETHYST_LARGE;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_LARGE;
	public static ConfiguredFeature<?, ?> AMETHYST_BURIED;
	public static ConfiguredFeature<?, ?> BLACK_OPAL_BURIED;
	public static ConfiguredFeature<?, ?> NETHER_AMETHYST;
	public static ConfiguredFeature<?, ?> NETHER_BLACK_OPAL;
	public static ConfiguredFeature<?, ?> END_AMETHYST;
	public static ConfiguredFeature<?, ?> END_BLACK_OPAL;
	
	public static PlacedFeature AMETHYST_PLACED;
	public static PlacedFeature BLACK_OPAL_PLACED;
	public static PlacedFeature AMETHYST_BURIED_PLACED;
	public static PlacedFeature BLACK_OPAL_BURIED_PLACED;
	public static PlacedFeature AMETHYST_LARGE_PLACED;
	public static PlacedFeature BLACK_OPAL_LARGE_PLACED;
	public static PlacedFeature NETHER_AMETHYST_PLACED;
	public static PlacedFeature NETHER_BLACK_OPAL_PLACED;
	public static PlacedFeature END_AMETHYST_PLACED;
	public static PlacedFeature END_BLACK_OPAL_PLACED;
	/*
	public static PlacedFeature AMETHYST_PLACED_FRACTION;
	public static PlacedFeature BLACK_OPAL_PLACED_FRACTION;
	public static PlacedFeature AMETHYST_BURIED_PLACED_FRACTION;
	public static PlacedFeature BLACK_OPAL_BURIED_PLACED_FRACTION;
	*/
	
    public static ImmutableList<OreConfiguration.TargetBlockState> AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_AMETHYST_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> NETHER_BLACK_OPAL_TARGET_BLOCKS;
    public static ImmutableList<OreConfiguration.TargetBlockState> END_BLACK_OPAL_TARGET_BLOCKS;    
    
    public static ConfiguredFeature<?, ?> buildConfigured(ImmutableList<OreConfiguration.TargetBlockState> targets, double veinSize, float discardChance) {
    	return Feature.ORE.configured(new OreConfiguration(targets, (int) Math.round(veinSize), discardChance));
    }
    
	public static PlacedFeature buildFeature(ConfiguredFeature<?, ?> configured, int veinCount, double timesRarer, HeightRangePlacement placement) {
		// Minecraft does it this way for some reason
		if (veinCount < 1 || (int) Math.round(veinCount / timesRarer) <= 0) {
			int chunksPerRarity = veinCount < 1 ? (int) timesRarer * 9 : (int) Math.max(1, Math.round(timesRarer / veinCount));
			return configured.placed(rareOrePlacement(chunksPerRarity, placement));
		} else {
			return configured.placed(commonOrePlacement((int) Math.round(veinCount / timesRarer), placement));
		}
	}
	
	public static HeightRangePlacement buildPlacement(int maxHeight) {
		return HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-64 - maxHeight), VerticalAnchor.aboveBottom(64 + maxHeight));
	}
	public static HeightRangePlacement buildPlacement(int minHeight, int maxHeight) {
		return HeightRangePlacement.uniform(VerticalAnchor.absolute(minHeight), VerticalAnchor.absolute(maxHeight));
	}

	/*
	public static PlacedFeature buildOreRemainder(ConfiguredFeature<?, ?> configured, int veinType, int maxHeight, double timesRarer) {
		double leftOver = ((double) veinType / (double) timesRarer) - (int) (veinType / timesRarer);
		if (leftOver <= 0.02) {
			return configured.placed(commonOrePlacement(0, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(maxHeight))));
		} else {
			int reciprocal = (int) Math.round(1.0 / leftOver);
	        return configured.placed(rareOrePlacement(reciprocal, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(maxHeight))));
		}

	}
	*/
	
	public static void registerFeatures() {
		
		AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.AMETHYST_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_AMETHYST_ORE.get().defaultBlockState()));
		NETHER_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_AMETHYST_ORE.get().defaultBlockState()));
		END_AMETHYST_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_AMETHYST_ORE.get().defaultBlockState()));
		
		BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState()),
				OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES, ModBlocks.DEEPSLATE_BLACK_OPAL_ORE.get().defaultBlockState()));	
		NETHER_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(OreFeatures.NETHER_ORE_REPLACEABLES, ModBlocks.NETHER_BLACK_OPAL_ORE.get().defaultBlockState()));
		END_BLACK_OPAL_TARGET_BLOCKS = ImmutableList.of(OreConfiguration.target(new BlockMatchTest(Blocks.END_STONE), ModBlocks.END_BLACK_OPAL_ORE.get().defaultBlockState()));
		
		AMETHYST = buildConfigured(AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);
	    BLACK_OPAL = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() / 2.0), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 0.715F);
	    
		AMETHYST_LARGE = buildConfigured(AMETHYST_TARGET_BLOCKS, (OADConfig.amethyst_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());
	    BLACK_OPAL_LARGE = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, (OADConfig.black_opal_vein_size.get() * 1.5), OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue());
	    
		AMETHYST_BURIED = buildConfigured(AMETHYST_TARGET_BLOCKS, OADConfig.amethyst_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));
	    BLACK_OPAL_BURIED = buildConfigured(BLACK_OPAL_TARGET_BLOCKS, OADConfig.black_opal_vein_size.get(), Math.min(1.0F, OADConfig.overworld_discard_chance_on_air_exposure.get().floatValue() * 1.43F));
	    
	    int netherAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.nether_vein_multiplier.get());
	    int netherBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.nether_vein_multiplier.get());
	    
	    NETHER_AMETHYST = buildConfigured(NETHER_AMETHYST_TARGET_BLOCKS, netherAmethystVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());
	    NETHER_BLACK_OPAL = buildConfigured(NETHER_BLACK_OPAL_TARGET_BLOCKS, netherBlackOpalVeinSize, OADConfig.nether_discard_chance_on_air_exposure.get().floatValue());
	    
	    int endAmethystVeinSize = (int) Math.round(OADConfig.amethyst_vein_size.get() * OADConfig.end_vein_multiplier.get());
	    int endBlackOpalVeinSize = (int) Math.round(OADConfig.black_opal_vein_size.get() * OADConfig.end_vein_multiplier.get());
	    
	    END_AMETHYST = buildConfigured(END_AMETHYST_TARGET_BLOCKS, endAmethystVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue());
	    END_BLACK_OPAL = buildConfigured(END_BLACK_OPAL_TARGET_BLOCKS, endBlackOpalVeinSize, OADConfig.end_discard_chance_on_air_exposure.get().floatValue()); 		
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst"), AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal"), BLACK_OPAL);
		
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_large"), AMETHYST_LARGE);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_large"), BLACK_OPAL_LARGE);
		
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried"), AMETHYST_BURIED);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried"), BLACK_OPAL_BURIED);
				
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_amethyst"), NETHER_AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_black_opal"), NETHER_BLACK_OPAL);
			
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_amethyst"), END_AMETHYST);
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_black_opal"), END_BLACK_OPAL);
		
		AMETHYST_PLACED = buildFeature(AMETHYST, 7, OADConfig.amethyst_times_rarer.get(), buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get()));
	    BLACK_OPAL_PLACED = buildFeature(BLACK_OPAL, 7, OADConfig.black_opal_times_rarer.get(), buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get()));
	    
	    AMETHYST_LARGE_PLACED = buildFeature(AMETHYST_LARGE, 0, OADConfig.amethyst_times_rarer.get(), buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get()));
	    BLACK_OPAL_LARGE_PLACED = buildFeature(BLACK_OPAL_LARGE, 0, OADConfig.black_opal_times_rarer.get(), buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get()));
	    
	    AMETHYST_BURIED_PLACED = buildFeature(AMETHYST_BURIED, 4, OADConfig.amethyst_times_rarer.get(), buildPlacement(OADConfig.amethyst_max_spawn_height_overworld.get()));
	    BLACK_OPAL_BURIED_PLACED = buildFeature(BLACK_OPAL_BURIED, 4, OADConfig.amethyst_times_rarer.get(), buildPlacement(OADConfig.black_opal_max_spawn_height_overworld.get()));
	    /*
	    AMETHYST_PLACED_FRACTION = buildOreRemainder(AMETHYST, 7, OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_PLACED_FRACTION = buildOreRemainder(BLACK_OPAL, 7, OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
	    
	    AMETHYST_BURIED_PLACED_FRACTION = buildOreRemainder(AMETHYST_BURIED, 4, OADConfig.amethyst_max_spawn_height_overworld.get(), OADConfig.amethyst_times_rarer.get());
	    BLACK_OPAL_BURIED_PLACED_FRACTION = buildOreRemainder(BLACK_OPAL_BURIED, 4, OADConfig.black_opal_max_spawn_height_overworld.get(), OADConfig.black_opal_times_rarer.get());
	    */
	    
		double netherAmethystTimesRarer = OADConfig.amethyst_times_rarer.get() / OADConfig.nether_chance_multiplier.get();
		double netherBlackOpalTimesRarer = OADConfig.black_opal_times_rarer.get() / OADConfig.nether_chance_multiplier.get();
	    
	    NETHER_AMETHYST_PLACED = buildFeature(NETHER_AMETHYST, 9, netherAmethystTimesRarer, buildPlacement(0, OADConfig.amethyst_max_spawn_height_nether.get()));
	    NETHER_BLACK_OPAL_PLACED = buildFeature(NETHER_BLACK_OPAL, 9, netherBlackOpalTimesRarer, buildPlacement(0, OADConfig.black_opal_max_spawn_height_nether.get()));
	        
		double endAmethystTimesRarer = OADConfig.amethyst_times_rarer.get() / OADConfig.nether_chance_multiplier.get();
		double endBlackOpalTimesRarer = OADConfig.black_opal_times_rarer.get() / OADConfig.nether_chance_multiplier.get();
	    
	    END_AMETHYST_PLACED = buildFeature(END_AMETHYST, 3, endAmethystTimesRarer, buildPlacement(0, OADConfig.amethyst_max_spawn_height_end.get()));
	    END_BLACK_OPAL_PLACED = buildFeature(END_BLACK_OPAL, 3, endBlackOpalTimesRarer, buildPlacement(0, OADConfig.black_opal_max_spawn_height_end.get()));
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst"), AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal"), BLACK_OPAL_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_large"), AMETHYST_LARGE_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_large"), BLACK_OPAL_LARGE_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried"), AMETHYST_BURIED_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried"), BLACK_OPAL_BURIED_PLACED);
	    
	    /*
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_fraction"), AMETHYST_PLACED_FRACTION);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_fraction"), BLACK_OPAL_PLACED_FRACTION);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_amethyst_buried_fraction"), AMETHYST_BURIED_PLACED_FRACTION);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_black_opal_buried_fraction"), BLACK_OPAL_BURIED_PLACED_FRACTION);
	    */
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_amethyst"), NETHER_AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_nether_black_opal"), NETHER_BLACK_OPAL_PLACED);
	    
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_amethyst"), END_AMETHYST_PLACED);
	    Registry.register(BuiltinRegistries.PLACED_FEATURE, new ResourceLocation(OresAboveDiamonds.MODID, "ore_end_black_opal"), END_BLACK_OPAL_PLACED);
		
	}
	
	   private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
		      return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
		   }

		   private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
		      return orePlacement(CountPlacement.of(p_195344_), p_195345_);
		   }

		   private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
		      return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
		   }
}
