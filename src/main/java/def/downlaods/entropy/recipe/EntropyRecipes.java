package def.downlaods.entropy.recipe;

import def.downlaods.entropy.Entropy;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntropyRecipes {
    public static final RecipeSerializer<InfusionBlockRecipe> INFUSION_BLOCK_SERIALIZER = Registry.register(
            Registries.RECIPE_SERIALIZER, Identifier.of(Entropy.MOD_ID, "infusion_block"),
            new InfusionBlockRecipe.Serializer());
    public static final RecipeType<InfusionBlockRecipe> INFUSION_BLOCK_TYPE = Registry.register(
            Registries.RECIPE_TYPE, Identifier.of(Entropy.MOD_ID, "infusion_block"), new RecipeType<InfusionBlockRecipe>() {
                @Override
                public String toString() {
                    return "infusion_block";
                }
            });

    public static void registerRecipes() {
        Entropy.LOGGER.info("Registering Custom Recipes for " + Entropy.MOD_ID);
    }
}
