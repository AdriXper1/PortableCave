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

    public static final Supplier<BlockEntityType<BlockExtractorBlockEntityBasic>> BLOCK_EXTRACTOR_BE =
            BLOCK_ENTITIES.register("block_extractor_be", () -> BlockEntityType.Builder.of(
                    BlockExtractorBlockEntityBasic::new, ModBlock.BLOCK_EXTRACTOR.get()).build(null));

    public static final Supplier<BlockEntityType<OreExtractorBlockEntityBasic>> ORE_EXTRACTOR_BE =
            BLOCK_ENTITIES.register("ore_extractor_be", () -> BlockEntityType.Builder.of(
                    OreExtractorBlockEntityBasic::new, ModBlock.ORE_EXTRACTOR.get()).build(null));

    public static final Supplier<BlockEntityType<BlockGeneratorBlockEntityBasic>> BLOCK_GENERATOR_BE =
            BLOCK_ENTITIES.register("block_generator_be", () -> BlockEntityType.Builder.of(
                    BlockGeneratorBlockEntityBasic::new, ModBlock.BLOCK_GENERATOR.get()).build(null));

    public static final Supplier<BlockEntityType<OreGeneratorBlockEntityBasic>> ORE_GENERATOR_BE =
            BLOCK_ENTITIES.register("ore_generator_be", () -> BlockEntityType.Builder.of(
                    OreGeneratorBlockEntityBasic::new, ModBlock.ORE_GENERATOR.get()).build(null));

    public static final Supplier<BlockEntityType<CreativeBatterieBlockEntity>> CREATIVE_BATTERIE_BE =
            BLOCK_ENTITIES.register("creative_batterie_be", () -> BlockEntityType.Builder.of(
                    CreativeBatterieBlockEntity::new, ModBlock.CREATIVE_BATTERIE.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}