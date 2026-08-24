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
    private static int nbBiomes = 0;
    private static int nbBlocks = 0;
    private Biome biome;
    private ArrayList<Block> blockList;
    private ArrayList<Block> oreList;

    public BiomeGrabber (Biome biome) {
        nbBiomes++;
        blockList  = new ArrayList<>();
        oreList    = new ArrayList<>();
        this.biome = biome;

        this.findBlocks();
    }

    private void findBlocks() {
        for (HolderSet<PlacedFeature> featuresSets : this.biome.getGenerationSettings().features()){
            for (Holder<PlacedFeature> featureHolder : featuresSets) {
                if (featureHolder.value().feature().value().config() instanceof OreConfiguration oreConfig) {
                    oreConfig.targetStates.forEach(target -> {
                        if (target.state.is(Tags.Blocks.ORES)){
                            oreList.add(target.state.getBlock());
                        }
                        else {
                            blockList.add(target.state.getBlock());
                        }
                    });
                    nbBlocks++;
                }
            }
        }
    }

    public Block getABlock () {
        if (!blockList.isEmpty()){
            return blockList.get((int) (Math.random() * blockList.size()));
        }
        return Blocks.COBBLESTONE;
    }

    public Block getAnOre () {
        if (!oreList.isEmpty()){
            return oreList.get((int) (Math.random() * oreList.size()));
        }
        return Blocks.COAL_ORE;
    }

    public static int getNbBiomes() {return nbBiomes;}
    public static int getNbBlocks() {return nbBlocks;}
    public Biome getBiome() {return this.biome;}
}
