package ax1.PortableCave.block.blockEntity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class PowerGeneratorBlockEntity extends BasicMachineBlockEntity{

    public PowerGeneratorBlockEntity(BlockEntityType blockEntityType, BlockPos pos, BlockState state) {
        super(blockEntityType, pos, state);
    }
}
