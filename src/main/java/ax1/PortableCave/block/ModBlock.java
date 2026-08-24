package ax1.PortableCave.block;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.block.custom.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PortableCave.MODID);

    public static final DeferredBlock<Block> BLOCK_EXTRACTOR = BLOCKS.registerBlock("block_extractor",
            properties -> new BlockExtractor(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ORE_EXTRACTOR = BLOCKS.registerBlock("ore_extractor",
            properties -> new OreExtractor(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> BLOCK_GENERATOR = BLOCKS.registerBlock("block_generator",
            properties -> new BlockGenerator(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ORE_GENERATOR = BLOCKS.registerBlock("ore_generator",
            (properties) -> new OreGenerator(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CREATIVE_BATTERIE = BLOCKS.registerBlock("creative_batterie",
            properties -> new CreativeBatterie(BlockBehaviour.Properties.of()));

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}