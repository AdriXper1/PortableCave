package ax1.PortableCave.datagen;

import ax1.PortableCave.block.ModBlock;
import ax1.PortableCave.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.CAVE_SOURCE.get(), 1)
                .requires(Blocks.STONE)
                .requires(Blocks.DEEPSLATE)
                .requires(Blocks.GRANITE)
                .requires(Blocks.DIORITE)
                .requires(Blocks.ANDESITE)
                .requires(Blocks.CALCITE)
                .requires(Blocks.TUFF)
                .requires(Blocks.DRIPSTONE_BLOCK)
                .requires(Blocks.OBSIDIAN)
                .unlockedBy("has_stone", has(Blocks.STONE))
                .unlockedBy("has_deepslate", has(Blocks.DEEPSLATE))
                .unlockedBy("has_granite", has(Blocks.GRANITE))
                .unlockedBy("has_diorite", has(Blocks.DIORITE))
                .unlockedBy("has_andesite", has(Blocks.ANDESITE))
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .unlockedBy("has_obsidian", has(Blocks.OBSIDIAN))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.ORE_SOURCE.get(), 1)
                .requires(ItemTags.COAL_ORES)
                .requires(ItemTags.IRON_ORES)
                .requires(ItemTags.COPPER_ORES)
                .requires(ItemTags.GOLD_ORES)
                .requires(ItemTags.REDSTONE_ORES)
                .requires(ItemTags.EMERALD_ORES)
                .requires(ItemTags.LAPIS_ORES)
                .requires(ItemTags.DIAMOND_ORES)
                .requires(Blocks.ANCIENT_DEBRIS)
                .unlockedBy("has_coal_ores", has(ItemTags.COAL_ORES))
                .unlockedBy("has_iron_ores", has(ItemTags.IRON_ORES))
                .unlockedBy("has_copper_ores", has(ItemTags.COPPER_ORES))
                .unlockedBy("has_gold_ores", has(ItemTags.GOLD_ORES))
                .unlockedBy("has_redstone_ores", has(ItemTags.REDSTONE_ORES))
                .unlockedBy("has_emerald_ores", has(ItemTags.EMERALD_ORES))
                .unlockedBy("has_lapis_ores", has(ItemTags.LAPIS_ORES))
                .unlockedBy("has_diamond_ores", has(ItemTags.DIAMOND_ORES))
                .unlockedBy("has_ancient_debris", has(Blocks.ANCIENT_DEBRIS))
                .save(recipeOutput);

        //TODO, add block and ore extractor after adding the drill

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.BLOCK_GENERATOR.get(), 1)
                .pattern("IRI")
                .pattern("ISI")
                .pattern("IRI")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('S', ModItem.CAVE_SOURCE)
                .unlockedBy("has_world_source", has(ModItem.CAVE_SOURCE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlock.ORE_GENERATOR.get(), 1)
                .pattern("IRI")
                .pattern("ISI")
                .pattern("IRI")
                .define('I', Items.IRON_INGOT)
                .define('R', Items.REDSTONE)
                .define('S', ModItem.ORE_SOURCE)
                .unlockedBy("has_world_source", has(ModItem.ORE_SOURCE))
                .save(recipeOutput);
    }
}
