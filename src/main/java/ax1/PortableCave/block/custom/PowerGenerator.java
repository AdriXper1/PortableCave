package ax1.PortableCave.block.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import ax1.PortableCave.block.blockEntity.custom.PowerGeneratorBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class PowerGenerator extends BaseEntityBlock {
    public static final MapCodec<PowerGenerator> CODEC = simpleCodec(PowerGenerator::new);

    public PowerGenerator(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new PowerGeneratorBlockEntity(blockPos, blockState);
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    public MenuProvider getMenuProvider(BlockState state, Level level, BlockPos pos) {
        BlockEntity blockentity = level.getBlockEntity(pos);
        return blockentity instanceof MenuProvider ? (MenuProvider)blockentity : null;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }

        return createTickerHelper(blockEntityType, ModBlockEntity.POWER_GENERATOR_BE.get(),
                (level1, blockPos, blockState, blockEntity)
                        -> blockEntity.tick(level1, blockPos, blockState));
    }
}
