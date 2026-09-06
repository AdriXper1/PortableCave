package ax1.PortableCave.datagen;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.block.ModBlock;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, PortableCave.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.BLOCK_EXTRACTOR.get())
                .add(ModBlock.ORE_EXTRACTOR.get())
                .add(ModBlock.BLOCK_GENERATOR.get())
                .add(ModBlock.ORE_GENERATOR.get())
                .add(ModBlock.POWER_GENERATOR.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlock.BLOCK_EXTRACTOR.get())
                .add(ModBlock.ORE_EXTRACTOR.get())
                .add(ModBlock.BLOCK_GENERATOR.get())
                .add(ModBlock.ORE_GENERATOR.get())
                .add(ModBlock.POWER_GENERATOR.get());
    }
}
