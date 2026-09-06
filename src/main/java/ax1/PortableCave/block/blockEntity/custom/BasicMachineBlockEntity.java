package ax1.PortableCave.block.blockEntity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class BasicMachineBlockEntity extends BlockEntity {

    public BasicMachineBlockEntity(BlockEntityType blockEntityType, BlockPos pos, BlockState state) {
        super(blockEntityType, pos, state);
    }

    public final EnergyStorage energyStorage = new EnergyStorage(10000, 100);

    public IEnergyStorage getEnergyStorage(Direction direction) {
        return this.energyStorage;
    }
}