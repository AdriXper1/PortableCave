package ax1.PortableCave.block.blockEntity.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class CreativeBatteryBlockEntity extends BlockEntity{
    //I love 999999999
    public EnergyStorage energyStorage = new EnergyStorage(999999999, 999999999, 999999999, 999999999) {
        @Override
        public int extractEnergy(int toExtract, boolean simulate) {
            return toExtract;
        }
    };

    public CreativeBatteryBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.CREATIVE_BATTERY_BE.get(), pos, state);
    }

    public IEnergyStorage getEnergyStorage(Direction direction) {
        return this.energyStorage;
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        for (Direction direction : Direction.values()) {
            BlockEntity targetBlockEntity = level.getBlockEntity(pos.relative(direction));
            if (targetBlockEntity == null) continue;

            IEnergyStorage energyStorage = targetBlockEntity.getLevel().getCapability(Capabilities.EnergyStorage.BLOCK, targetBlockEntity.getBlockPos(), direction.getOpposite());
            if (energyStorage == null) continue;

            energyStorage.receiveEnergy(999999999, false);
        }
    }
}