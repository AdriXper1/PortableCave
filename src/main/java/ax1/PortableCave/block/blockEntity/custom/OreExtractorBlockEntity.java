package ax1.PortableCave.block.blockEntity.custom;

import ax1.PortableCave.block.blockEntity.ModBlockEntity;
import ax1.PortableCave.block.custom.OreExtractor;
import ax1.PortableCave.genGrabber.GenGrabber;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;

public class OreExtractorBlockEntity extends BlockEntity {
    private final EnergyStorage energyStorage;
    private final int pickaxPower;

    public OreExtractorBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.EXTRACTOR_BE.get(), pos, state);
        this.pickaxPower = getDrillLevel();
        this.energyStorage = new EnergyStorage(1000 * (int)Math.pow(10, pickaxPower), 10 * (int)Math.pow(10, pickaxPower));
    }

    public int getDrillLevel() {
        if (getBlockState().getBlock() instanceof OreExtractor oreExtractor) {
            return oreExtractor.pickaxePower;
        }

        return 0;
    }

    public IEnergyStorage getEnergyStorage(Direction direction) {
        return this.energyStorage;
    }

    public void tick(Level level, BlockPos pos, BlockState state, DirectionProperty direction) {
        if (level.isEmptyBlock(pos.relative(state.getValue(direction))) && energyStorage.getEnergyStored() > 10)
        {
            level.setBlockAndUpdate(pos.relative(state.getValue(direction)), GenGrabber.getAnOreFromBiome(level.getBiome(pos).value(), pickaxPower).defaultBlockState());
            energyStorage.extractEnergy(10 * (int)Math.pow(10, pickaxPower), false);
        }
    }
}