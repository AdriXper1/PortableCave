package ax1.PortableCave.block.blockEntity;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.block.ModBlock;
import ax1.PortableCave.block.blockEntity.custom.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PortableCave.MODID);

    public static final Supplier<BlockEntityType<OreExtractorBlockEntity>> EXTRACTOR_BE =
            BLOCK_ENTITIES.register("extractor_be", () -> BlockEntityType.Builder.of(
                    OreExtractorBlockEntity::new,
                    ModBlock.STONE_EXTRACTOR.get(),
                    ModBlock.IRON_EXTRACTOR.get(),
                    ModBlock.DIAMOND_EXTRACTOR.get(),
                    ModBlock.NETHERITE_EXTRACTOR.get(),
                    ModBlock.ULTIMATE_EXTRACTOR.get()).build(null));

    public static final Supplier<BlockEntityType<BlockGeneratorBlockEntity>> BLOCK_GENERATOR_BE =
            BLOCK_ENTITIES.register("block_generator_be", () -> BlockEntityType.Builder.of(
                    BlockGeneratorBlockEntity::new, ModBlock.BLOCK_GENERATOR.get()).build(null));

    public static final Supplier<BlockEntityType<OreGeneratorBlockEntity>> ORE_GENERATOR_BE =
            BLOCK_ENTITIES.register("ore_generator_be", () -> BlockEntityType.Builder.of(
                    OreGeneratorBlockEntity::new, ModBlock.ORE_GENERATOR.get()).build(null));

    public static final Supplier<BlockEntityType<PowerGeneratorBlockEntity>> POWER_GENERATOR_BE =
            BLOCK_ENTITIES.register("power_generator_be", () -> BlockEntityType.Builder.of(
                    PowerGeneratorBlockEntity::new, ModBlock.POWER_GENERATOR.get()).build(null));

    public static final Supplier<BlockEntityType<CreativeBatteryBlockEntity>> CREATIVE_BATTERY_BE =
            BLOCK_ENTITIES.register("creative_battery_be", () -> BlockEntityType.Builder.of(
                    CreativeBatteryBlockEntity::new, ModBlock.CREATIVE_BATTERY.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}