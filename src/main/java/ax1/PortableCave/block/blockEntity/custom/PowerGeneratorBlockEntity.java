package ax1.PortableCave.block.blockEntity.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class PowerGeneratorBlockEntity extends BlockEntity{
    public EnergyStorage energyStorage = new EnergyStorage(10000, 100){
        @Override
        public int receiveEnergy(int toReceive, boolean simulate) {
            return 0;
        }
    };
    private final NonNullList<ItemStack> stacks = NonNullList.withSize(1, ItemStack.EMPTY);
    private final ItemStackHandler stackHandler = new ItemStackHandler(this.stacks) {
        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return getBurnTime(stack) != 0;
        }
    };

    public PowerGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.POWER_GENERATOR_BE.get(), pos, state);
    }

    public IEnergyStorage getEnergyStorage(Direction direction) {
        return this.energyStorage;
    }

    public IItemHandler getItemHandler (Direction side) {
        return this.stackHandler;
    }

    private int getBurnTime(ItemStack stack) {
        return stack.getItem().getBurnTime(stack, null);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        if (0 < energyStorage.receiveEnergy(getBurnTime(stacks.getFirst()), false)) {
            stacks.getFirst().consume(1, null);
        }

        for (Direction direction : Direction.values()) {
            BlockEntity targetBlockEntity = level.getBlockEntity(pos.relative(direction));
            if (targetBlockEntity == null) continue;

            IEnergyStorage energyStorage = targetBlockEntity.getLevel().getCapability(Capabilities.EnergyStorage.BLOCK, targetBlockEntity.getBlockPos(), direction.getOpposite());
            if (energyStorage == null) continue;

            energyStorage.receiveEnergy(this.energyStorage.extractEnergy(this.energyStorage.getEnergyStored(), false), false);
        }
    }
}
