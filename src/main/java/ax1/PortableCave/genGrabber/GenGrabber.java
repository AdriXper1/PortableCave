package ax1.PortableCave.genGrabber;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

import java.util.ArrayList;

public class GenGrabber {
    private static ArrayList<BiomeGrabber> biomeGrabberList;

    public static void onServerStarting(ServerStartingEvent event) {
        biomeGrabberList = new ArrayList<>();
        for (Biome biome :event.getServer()
                .registryAccess()
                .registryOrThrow(Registries.BIOME)){
            biomeGrabberList.add(new BiomeGrabber(biome));
        }
    }

    public static Block getABlockFromBiome (Biome biome) {
        for (BiomeGrabber biomeGrabber : biomeGrabberList){
            if (biomeGrabber.getBiome() == biome){
                return biomeGrabber.getABlock();
            }
        }
        return Blocks.DIRT;
    }

    public static Block getAnOreFromBiome (Biome biome, int pickaxePower) {
        for (BiomeGrabber biomeGrabber : biomeGrabberList){
            if (biomeGrabber.getBiome() == biome){
                return biomeGrabber.getAnOre(pickaxePower);
            }
        }
        return Blocks.DIRT;
    }

    public static Block getABlock () {
        if (biomeGrabberList.isEmpty()){
            return Blocks.DIRT;
        }
        return biomeGrabberList.get((int) (Math.random() * biomeGrabberList.size())).getABlock();
    }

    public static Block getAnOre () {
        if (biomeGrabberList.isEmpty()){
            return Blocks.DIRT;
        }
        return biomeGrabberList.get((int) (Math.random() * biomeGrabberList.size())).getAnOre(4);
    }
}