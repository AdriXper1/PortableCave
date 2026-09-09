package ax1.PortableCave.energie;

import net.minecraft.util.Mth;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class SmartEnergyStorage extends EnergyStorage{
    public SmartEnergyStorage(int capacity) {
        super(capacity, capacity, capacity, 0);
    }

    public SmartEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer, maxTransfer, 0);
    }

    public SmartEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract, 0);
    }

    public SmartEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }

    /**
     * Increase the energie of this {@link SmartEnergyStorage} skipping {@link #maxReceive}.
     * Used when making generator that can't take energie.
     */
    public int produceEnergie (int toProduce, boolean simulate) {
        if (toProduce <= 0) {
            return 0;
        }

        int energyReceived = Mth.clamp(this.capacity - this.energy, 0, toProduce);
        if (!simulate)
            this.energy += energyReceived;
        return energyReceived;
    }

    /**
     * Automatically extract power from this {@link SmartEnergyStorage}
     * and give it to the {@link IEnergyStorage}. No lose of energie.
     */
    public int giveEnergie (int toSend, IEnergyStorage energyStorage, boolean simulate) {
        return energyStorage.receiveEnergy(this.extractEnergy(energyStorage.receiveEnergy(toSend, true), simulate), simulate);
    }
}
