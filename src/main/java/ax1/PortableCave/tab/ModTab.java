package ax1.PortableCave.tab;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.item.ModItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTab {
    public static final DeferredRegister<CreativeModeTab> MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PortableCave.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN_TAB = MOD_TABS.register("portable_cave_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativeTab.portable_cave"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> ModItem.BLOCK_GENERATOR_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(ModItem.IRON_DRILL.get());
                output.accept(ModItem.DIAMOND_DRILL.get());
                output.accept(ModItem.NETHERITE_DRILL.get());
                output.accept(ModItem.ULTIMATE_DRILL.get());
                output.accept(ModItem.CAVE_SOURCE.get());
                output.accept(ModItem.ORE_SOURCE.get());
                output.accept(ModItem.BLOCK_EXTRACTOR_ITEM.get());
                output.accept(ModItem.ORE_EXTRACTOR_LV1_ITEM.get());
                output.accept(ModItem.ORE_EXTRACTOR_LV2_ITEM.get());
                output.accept(ModItem.ORE_EXTRACTOR_LV3_ITEM.get());
                output.accept(ModItem.ORE_EXTRACTOR_LV4_ITEM.get());
                output.accept(ModItem.BLOCK_GENERATOR_ITEM.get());
                output.accept(ModItem.ORE_GENERATOR_ITEM.get());
                output.accept(ModItem.POWER_GENERATOR_ITEM.get());
                output.accept(ModItem.CREATIVE_BATTERY.get());
            }).build());

    public static void register(IEventBus eventBus) {MOD_TABS.register(eventBus);}
}
