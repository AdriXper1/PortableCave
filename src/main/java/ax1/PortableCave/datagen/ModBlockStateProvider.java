package ax1.PortableCave.datagen;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.block.ModBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PortableCave.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        directionalMachineWithItem(ModBlock.BLOCK_EXTRACTOR);
        directionalMachineWithItem(ModBlock.ORE_EXTRACTOR);
        directionalMachineWithItem(ModBlock.BLOCK_GENERATOR);
        directionalMachineWithItem(ModBlock.ORE_GENERATOR);
        blockWithItem(ModBlock.POWER_GENERATOR);
        blockWithItem(ModBlock.CREATIVE_BATTERY);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void directionalMachineWithItem(DeferredBlock<?> deferredBlock) {
        ModelFile model = models().orientable(deferredBlock.getRegisteredName(),
                ResourceLocation.fromNamespaceAndPath(PortableCave.MODID, "block/machine_side"),
                ResourceLocation.fromNamespaceAndPath(PortableCave.MODID, "block/machine_front"),
                ResourceLocation.fromNamespaceAndPath(PortableCave.MODID, "block/" + BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath() + "_top"));

        directionalBlock(deferredBlock.get(), model);
        simpleBlockItem(deferredBlock.get(), model);
    }

    @Override
    public void directionalBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset) {
        getVariantBuilder(block)
                .forAllStates(state -> {
                    Direction dir = state.getValue(BlockStateProperties.FACING);
                    return ConfiguredModel.builder()
                            .modelFile(modelFunc.apply(state))
                            .rotationX(dir == Direction.DOWN ? 90 : dir.getAxis().isVertical() ? 270 : 0)
                            .rotationY(dir.getAxis().isVertical() ? 0 : (((int) dir.toYRot()) + angleOffset) % 360)
                            .build();
                });
    }
}