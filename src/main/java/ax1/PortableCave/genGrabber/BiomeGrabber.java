package ax1.PortableCave.genGrabber;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;

import java.util.ArrayList;

//surely I can optimise this garbage...
//mhe, it only runs at game start
public class BiomeGrabber {
    private int lv1Size;
    private int lv2Size;
    private int lv3Size;
    private int lv4Size;
    private final Biome biome;
    private final ArrayList<FeatureGrabber> blockConfiguration;
    private final ArrayList<FeatureGrabber> oreConfigurations;

    public BiomeGrabber (Biome biome) {
        lv1Size = 0;
        lv2Size = 0;
        lv3Size = 0;
        lv4Size = 0;
        blockConfiguration = new ArrayList<>();
        oreConfigurations  = new ArrayList<>();
        this.biome = biome;

        this.findFeatures();
    }

    //GRASSY-ASS ROMANO!!!
    private void findFeatures() {
        int tempSize;
        for (HolderSet<PlacedFeature> featuresSets : biome.getGenerationSettings().features()){
            for (Holder<PlacedFeature> featureHolder : featuresSets) {
                tempSize = getBlocks(featureHolder, 1);
                lv2Size += tempSize;
                lv3Size += tempSize;
                lv4Size += tempSize;
            }
        }
        for (HolderSet<PlacedFeature> featuresSets : biome.getGenerationSettings().features()){
            for (Holder<PlacedFeature> featureHolder : featuresSets) {
                tempSize = getBlocks(featureHolder, 2);
                lv2Size += tempSize;
                lv3Size += tempSize;
                lv4Size += tempSize;
            }
        }
        for (HolderSet<PlacedFeature> featuresSets : biome.getGenerationSettings().features()){
            for (Holder<PlacedFeature> featureHolder : featuresSets) {
                tempSize = getBlocks(featureHolder, 3);
                lv3Size += tempSize;
                lv4Size += tempSize;
            }
        }
        for (HolderSet<PlacedFeature> featuresSets : biome.getGenerationSettings().features()){
            for (Holder<PlacedFeature> featureHolder : featuresSets) {
                tempSize = getBlocks(featureHolder, 4);
                lv4Size += tempSize;
            }
        }
    }

    private int getBlocks (Holder<PlacedFeature> featureHolder, int pickaxPower) {
        int tmp = 0;
        if (featureHolder.value().feature().value().config() instanceof OreConfiguration oreConfig) {
            FeatureGrabber tempFeatureGrabber = new FeatureGrabber(oreConfig, featureHolder.value().placement());
            if (oreConfig.targetStates.getFirst().state.is(Tags.Blocks.ORES) && getPickaxePower(tempFeatureGrabber) == pickaxPower) {
                oreConfigurations.add(tempFeatureGrabber);
                tmp += tempFeatureGrabber.size;
            }
            else if (getPickaxePower(tempFeatureGrabber) == pickaxPower) {
                blockConfiguration.add(tempFeatureGrabber);
                lv1Size += tempFeatureGrabber.size;
            }
        }
        return tmp;
    }

    private int getPickaxePower (FeatureGrabber featureGrabber) {
        if (featureGrabber.getBlock().defaultBlockState().is(BlockTags.NEEDS_STONE_TOOL)) {
            return 2;
        }
        if (featureGrabber.getBlock().defaultBlockState().is(BlockTags.NEEDS_IRON_TOOL)) {
            return 3;
        }
        if (featureGrabber.getBlock().defaultBlockState().is(BlockTags.NEEDS_DIAMOND_TOOL)) {
            return 4;
        }
        //NEEDS_WOODEN_TOOL
        return 1;
    }

    public Block getABlock () {
        if (!blockConfiguration.isEmpty()){
            int cpt = 0;
            int rand = (int) (Math.random() * lv1Size);
            for (FeatureGrabber featureGrabber : blockConfiguration){
                cpt += featureGrabber.size;
                if (cpt >= rand){
                    return featureGrabber.getBlock();
                }
            }
        }
        return Blocks.COBBLESTONE;
    }

    public Block getAnOre (int pickaxePower) {
        if (!oreConfigurations.isEmpty()){
            int cpt = 0;
            int rand;

            //default is 2
            switch (pickaxePower) {
                case 3 -> rand = (int) (Math.random() * lv3Size);
                case 4 -> rand = (int) (Math.random() * lv4Size);
                default -> rand = (int) (Math.random() * lv2Size);
            }
            System.out.println("\nmin: " + lv2Size + "\nmax: " + lv4Size + "\ngot: " + rand);
            for (FeatureGrabber featureGrabber : oreConfigurations){
                cpt += featureGrabber.size;
                if (cpt >= rand){
                    System.out.println("\nfound " + featureGrabber.getBlock());
                    return featureGrabber.getBlock();
                }
            }
        }
        System.out.println("\nnoting fond: default coal");
        return Blocks.COAL_ORE;
    }

    public Biome getBiome() {return this.biome;}
}
