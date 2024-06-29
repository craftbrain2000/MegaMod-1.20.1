package net.craftbrain2000.cbmm.datagen;

import net.craftbrain2000.cbmm.CBMM;
import net.craftbrain2000.cbmm.block.ModBlocks;
import net.craftbrain2000.cbmm.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> BOURSSITE_SMELTABLES = List.of(ModItems.RAW_BOURSSITE.get(),
            ModBlocks.BOURSSITE_ORE.get(),ModBlocks.DEEPSLATE_BOURSSITE_ORE.get());
1
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter,BOURSSITE_SMELTABLES, RecipeCategory.MISC, ModItems.BOURSSITE_INGOT.get(), 0.25f, 200, "bourssite");
        oreBlasting(pWriter,BOURSSITE_SMELTABLES, RecipeCategory.MISC, ModItems.BOURSSITE_INGOT.get(), 0.25f, 100, "bourssite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BOURSSITE_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.BOURSSITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.BOURSSITE_INGOT.get()), has(ModItems.BOURSSITE_INGOT.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BOURSSITE_INGOT.get(),9)
                .requires(ModBlocks.BOURSSITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.BOURSSITE_BLOCK.get()), has(ModBlocks.BOURSSITE_BLOCK.get()))
                .save(pWriter);
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, CBMM.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}

