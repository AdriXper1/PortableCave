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

    public static final DeferredItem<Item> CAVE_SOURCE = ITEMS.registerSimpleItem("cave_source");
    public static final DeferredItem<Item> ORE_SOURCE = ITEMS.registerSimpleItem("ore_source");

    public static final DeferredItem<BlockItem> BLOCK_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("block_extractor", ModBlock.BLOCK_EXTRACTOR);
    public static final DeferredItem<BlockItem> ORE_EXTRACTOR_ITEM = ITEMS.registerSimpleBlockItem("ore_extractor", ModBlock.ORE_EXTRACTOR);
    public static final DeferredItem<BlockItem> BLOCK_GENERATOR_ITEM = ITEMS.registerSimpleBlockItem("block_generator", ModBlock.BLOCK_GENERATOR);
    public static final DeferredItem<BlockItem> ORE_GENERATOR_ITEM = ITEMS.registerSimpleBlockItem("ore_generator", ModBlock.ORE_GENERATOR);
    public static final DeferredItem<BlockItem> CREATIVE_BATTERIE = ITEMS.registerSimpleBlockItem("creative_batterie", ModBlock.CREATIVE_BATTERIE);

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus);}
}
