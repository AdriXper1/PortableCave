package ax1.PortableCave.datagen;

import ax1.PortableCave.PortableCave;
import ax1.PortableCave.item.ModItem;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PortableCave.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItem.IRON_DRILL.get());
        basicItem(ModItem.DIAMOND_DRILL.get());
        basicItem(ModItem.NETHERITE_DRILL.get());
        basicItem(ModItem.ULTIMATE_DRILL.get());
        basicItem(ModItem.CAVE_SOURCE.get());
        basicItem(ModItem.ORE_SOURCE.get());
    }
}