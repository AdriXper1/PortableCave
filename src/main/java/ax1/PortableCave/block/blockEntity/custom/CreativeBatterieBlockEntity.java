package ax1.PortableCave.block.blockEntity.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.IItemHandler;

import java.util.Map;

public class CreativeBatterieBlockEntity extends BlockEntity{

    public CreativeBatterieBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.CREATIVE_BATTERIE_BE.get(), pos, state);
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