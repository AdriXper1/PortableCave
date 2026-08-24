package ax1.PortableCave.block.blockEntity.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import ax1.PortableCave.genGrabber.GenGrabber;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class OreGeneratorBlockEntity extends MachineBlockEntity {
    public OreGeneratorBlockEntity(BlockPos pos, BlockState state) {super(ModBlockEntity.ORE_GENERATOR_BE.get(), pos, state);}

    public void tick(Level level, BlockPos pos, BlockState state, DirectionProperty direction) {
        if (level.isEmptyBlock(pos.relative(state.getValue(direction))) && energyStorage.getEnergyStored() > 10)
        {
            level.setBlockAndUpdate(pos.relative(state.getValue(direction)), GenGrabber.getAnOre().defaultBlockState());
            energyStorage.extractEnergy(10, false);

        }
    }
}