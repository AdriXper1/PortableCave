package ax1.PortableCave.genGrabber;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import java.util.List;

public class FeatureGrabber {
    private OreConfiguration oreConfiguration;
    public int size;

    public FeatureGrabber (OreConfiguration oreConfiguration, List<PlacementModifier> listPlacementModifiers){
        this.oreConfiguration = oreConfiguration;

        for (PlacementModifier placementModifier : listPlacementModifiers) {
            if (placementModifier instanceof CountPlacement countPlacement) {
                size += oreConfiguration.size * countPlacement.count.getMaxValue();
            } else if (placementModifier instanceof RarityFilter rarityFilter) {
                size += oreConfiguration.size / rarityFilter.chance;
            }
        }
    }

    public Block getBlock () {
        return oreConfiguration.targetStates.getFirst().state.getBlock();
    }

    public int getSize () {
        return this.size;
    }
}