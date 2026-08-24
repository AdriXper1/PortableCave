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
        return Blocks.COBBLESTONE;
    }

    public static Block getAnOreFromBiome (Biome biome) {
        for (BiomeGrabber biomeGrabber : biomeGrabberList){
            if (biomeGrabber.getBiome() == biome){
                return biomeGrabber.getAnOre();
            }
        }
        return Blocks.COAL_BLOCK;
    }

    public static Block getABlock () {
        return biomeGrabberList.get((int) (Math.random() * biomeGrabberList.size())).getABlock();
    }

    public static Block getAnOre () {
        return biomeGrabberList.get((int) (Math.random() * biomeGrabberList.size())).getAnOre();
    }
}