package ax1.PortableCave.genGrabber;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;

import java.util.ArrayList;

public class BiomeGrabber {
    private int blockMaxSize;
    private int oreMaxSize;
    private Biome biome;
    private ArrayList<FeatureGrabber> blockConfiguration;
    private ArrayList<FeatureGrabber> oreConfigurations;

    public BiomeGrabber (Biome biome) {
        blockMaxSize = 0;
        oreMaxSize = 0;
        blockConfiguration = new ArrayList<>();
        oreConfigurations  = new ArrayList<>();
        this.biome = biome;

        this.findBlocks();
    }

    private void findBlocks() {
        for (HolderSet<PlacedFeature> featuresSets : biome.getGenerationSettings().features()){
            for (Holder<PlacedFeature> featureHolder : featuresSets) {
                if (featureHolder.value().feature().value().config() instanceof OreConfiguration oreConfig) {
                    if (oreConfig.targetStates.getFirst().state.is(Tags.Blocks.ORES)){
                        oreConfigurations.add(new FeatureGrabber(oreConfig, featureHolder.value().placement()));
                        oreMaxSize += oreConfigurations.getLast().size;
                    }
                    else {
                        blockConfiguration.add(new FeatureGrabber(oreConfig, featureHolder.value().placement()));
                        blockMaxSize += blockConfiguration.getLast().size;
                    }
                }
            }
        }
    }

    public Block getABlock () {
        if (!blockConfiguration.isEmpty()){
            int cpt = 0;
            int rand = (int) (Math.random() * blockMaxSize);
            for (FeatureGrabber featureGrabber : blockConfiguration){
                cpt += featureGrabber.size;
                if (cpt >= rand){
                    return featureGrabber.getBlock();
                }
            }
        }
        return Blocks.COBBLESTONE;
    }

    public Block getAnOre () {
        if (!oreConfigurations.isEmpty()){
            int cpt = 0;
            int rand = (int) (Math.random() * oreMaxSize);
            for (FeatureGrabber featureGrabber : oreConfigurations){
                cpt += featureGrabber.size;
                if (cpt >= rand){
                    return featureGrabber.getBlock();
                }
            }
        }
        return Blocks.COAL_ORE;
    }

    public Biome getBiome() {return this.biome;}
}
