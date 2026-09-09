package ax1.PortableCave.datagen;

import ax1.PortableCave.block.ModBlock;
import ax1.PortableCave.item.ModItem;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItem.CAVE_SOURCE.get(), 1)
                .requires(Items.STONE)
                .requires(Items.DEEPSLATE)
                .requires(Items.GRANITE)
                .requires(Items.DIORITE)
                .requires(Items.ANDESITE)
                .requires(Items.CALCITE)
                .requires(Items.TUFF)
                .requires(Items.DRIPSTONE_BLOCK)
                .requires(Items.OBSIDIAN)
                .unlockedBy("has_stone", has(Items.STONE))
                .unlockedBy("has_deepslate", has(Items.DEEPSLATE))
                .unlockedBy("has_granite", has(Items.GRANITE))
                .unlockedBy("has_diorite", has(Items.DIORITE))
                .unlockedBy("has_andesite", has(Items.ANDESITE))
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .unlockedBy("has_tuff", has(Items.TUFF))
                .unlockedBy("has_dripstone_block", has(Items.DRIPSTONE_BLOCK))
                .unlockedBy("has_obsidian", has(Items.OBSIDIAN))
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
                .requires(Items.ANCIENT_DEBRIS)
                .unlockedBy("has_coal_ores", has(ItemTags.COAL_ORES))
                .unlockedBy("has_iron_ores", has(ItemTags.IRON_ORES))
                .unlockedBy("has_copper_ores", has(ItemTags.COPPER_ORES))
                .unlockedBy("has_gold_ores", has(ItemTags.GOLD_ORES))
                .unlockedBy("has_redstone_ores", has(ItemTags.REDSTONE_ORES))
                .unlockedBy("has_emerald_ores", has(ItemTags.EMERALD_ORES))
                .unlockedBy("has_lapis_ores", has(ItemTags.LAPIS_ORES))
                .unlockedBy("has_diamond_ores", has(ItemTags.DIAMOND_ORES))
                .unlockedBy("has_ancient_debris", has(Items.ANCIENT_DEBRIS))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.IRON_DRILL.get(), 1)
                .pattern("  I")
                .pattern("DI ")
                .pattern("DDD")
                .define('I', Items.IRON_INGOT)
                .define('D', Items.DEEPSLATE)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_deepslate", has(Items.DEEPSLATE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.DIAMOND_DRILL.get(), 1)
                .pattern("  D")
                .pattern("BD ")
                .pattern("BBB")
                .define('D', Items.DIAMOND)
                .define('B', Items.IRON_BLOCK)
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_iron_block", has(Items.IRON_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.NETHERITE_DRILL.get(), 1)
                .pattern("  N")
                .pattern("BN ")
                .pattern("BBB")
                .define('N', Items.NETHERITE_INGOT)
                .define('B', Items.DIAMOND_BLOCK)
                .unlockedBy("has_netherite", has(Items.NETHERITE_INGOT))
                .unlockedBy("has_diamond_block", has(Items.DIAMOND_BLOCK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItem.ULTIMATE_DRILL.get(), 1)
                .pattern("  T")
                .pattern("BS ")
                .pattern("BBB")
                .define('T', Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
                .define('S', Items.NETHER_STAR)
                .define('B', Items.NETHERITE_BLOCK)
                .unlockedBy("has_netherite_template", has(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
                .unlockedBy("has_nether_star", has(Items.NETHER_STAR))
                .unlockedBy("has_netherite_block", has(Items.NETHERITE_BLOCK))
                .save(recipeOutput);

        //TODO, add  ALL OF the blocks and ores extractors

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
