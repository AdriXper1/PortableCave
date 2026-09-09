package ax1.PortableCave.datagen;

import ax1.PortableCave.block.ModBlock;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlock.BLOCK_EXTRACTOR.get());
        dropSelf(ModBlock.ORE_EXTRACTOR_LV1.get());
        dropSelf(ModBlock.ORE_EXTRACTOR_LV2.get());
        dropSelf(ModBlock.ORE_EXTRACTOR_LV3.get());
        dropSelf(ModBlock.ORE_EXTRACTOR_LV4.get());
        dropSelf(ModBlock.BLOCK_GENERATOR.get());
        dropSelf(ModBlock.ORE_GENERATOR.get());
        dropSelf(ModBlock.POWER_GENERATOR.get());
        add(ModBlock.CREATIVE_BATTERY.get(), noDrop());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlock.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
