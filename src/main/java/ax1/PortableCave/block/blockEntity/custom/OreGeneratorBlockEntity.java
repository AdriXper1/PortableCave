package ax1.PortableCave.block.blockEntity.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import ax1.PortableCave.genGrabber.GenGrabber;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class OreGeneratorBlockEntity extends BlockEntity {
    public EnergyStorage energyStorage = new EnergyStorage(10000, 100);

    public OreGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.ORE_GENERATOR_BE.get(), pos, state);
    }

    public IEnergyStorage getEnergyStorage(Direction direction) {
        return this.energyStorage;
    }

    public void tick(Level level, BlockPos pos, BlockState state, DirectionProperty direction) {
        if (level.isEmptyBlock(pos.relative(state.getValue(direction))) && energyStorage.getEnergyStored() > 10)
        {
            level.setBlockAndUpdate(pos.relative(state.getValue(direction)), GenGrabber.getAnOre().defaultBlockState());
            energyStorage.extractEnergy(10, false);
        }
    }
}