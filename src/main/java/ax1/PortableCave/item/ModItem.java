package ax1.PortableCave.item;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.block.ModBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PortableCave.MODID);

    public static final DeferredItem<Item> STONE_DRILL = ITEMS.registerSimpleItem("stone_drill");
    public static final DeferredItem<Item> IRON_DRILL = ITEMS.registerSimpleItem("iron_drill");
    public static final DeferredItem<Item> DIAMOND_DRILL = ITEMS.registerSimpleItem("diamond_drill");
    public static final DeferredItem<Item> NETHERITE_DRILL = ITEMS.registerSimpleItem("netherite_drill");
    public static final DeferredItem<Item> ULTIMATE_DRILL = ITEMS.registerSimpleItem("ultimate_drill");
    public static final DeferredItem<Item> CAVE_SOURCE = ITEMS.registerSimpleItem("cave_source");
    public static final DeferredItem<Item> ORE_SOURCE = ITEMS.registerSimpleItem("ore_source");

    public static final DeferredItem<BlockItem> STONE_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("stone_extractor", ModBlock.STONE_EXTRACTOR);
    public static final DeferredItem<BlockItem> IRON_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("iron_extractor", ModBlock.IRON_EXTRACTOR);
    public static final DeferredItem<BlockItem> DIAMOND_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("diamond_extractor", ModBlock.DIAMOND_EXTRACTOR);
    public static final DeferredItem<BlockItem> NETHERITE_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("netherite_extractor", ModBlock.NETHERITE_EXTRACTOR);
    public static final DeferredItem<BlockItem> ULTIMATE_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("ultimate_extractor", ModBlock.ULTIMATE_EXTRACTOR);
    public static final DeferredItem<BlockItem> BLOCK_GENERATOR_ITEM = ITEMS.registerSimpleBlockItem("block_generator", ModBlock.BLOCK_GENERATOR);
    public static final DeferredItem<BlockItem> ORE_GENERATOR_ITEM = ITEMS.registerSimpleBlockItem("ore_generator", ModBlock.ORE_GENERATOR);
    public static final DeferredItem<BlockItem> POWER_GENERATOR_ITEM = ITEMS.registerSimpleBlockItem("power_generator", ModBlock.POWER_GENERATOR);
    public static final DeferredItem<BlockItem> CREATIVE_BATTERY = ITEMS.registerSimpleBlockItem("creative_battery", ModBlock.CREATIVE_BATTERY);

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
