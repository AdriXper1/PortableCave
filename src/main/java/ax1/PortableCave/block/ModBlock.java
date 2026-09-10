package ax1.PortableCave.block;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.block.custom.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlock {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(PortableCave.MODID);

    public static final DeferredBlock<Block> STONE_EXTRACTOR = BLOCKS.registerBlock("stone_extractor",
            properties -> new OreExtractor(properties.strength(4f).requiresCorrectToolForDrops(), 0));
    public static final DeferredBlock<Block> IRON_EXTRACTOR = BLOCKS.registerBlock("iron_extractor",
            properties -> new OreExtractor(properties.strength(4f).requiresCorrectToolForDrops(), 2));
    public static final DeferredBlock<Block> DIAMOND_EXTRACTOR = BLOCKS.registerBlock("diamond_extractor",
            properties -> new OreExtractor(properties.strength(4f).requiresCorrectToolForDrops(), 3));
    public static final DeferredBlock<Block> NETHERITE_EXTRACTOR = BLOCKS.registerBlock("netherite_extractor",
            properties -> new OreExtractor(properties.strength(4f).requiresCorrectToolForDrops(), 4));
    public static final DeferredBlock<Block> ULTIMATE_EXTRACTOR = BLOCKS.registerBlock("ultimate_extractor",
            properties -> new OreExtractor(properties.strength(4f).requiresCorrectToolForDrops(), 4));

    public static final DeferredBlock<Block> BLOCK_GENERATOR = BLOCKS.registerBlock("block_generator",
            properties -> new BlockGenerator(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> ORE_GENERATOR = BLOCKS.registerBlock("ore_generator",
            (properties) -> new OreGenerator(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> POWER_GENERATOR = BLOCKS.registerBlock("power_generator",
            properties -> new PowerGenerator(properties.strength(4f).requiresCorrectToolForDrops()));

    public static final DeferredBlock<Block> CREATIVE_BATTERY = BLOCKS.registerBlock("creative_battery",
            properties -> new CreativeBattery(properties.strength(-1f)));

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);}
}