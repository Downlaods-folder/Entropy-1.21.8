package def.downlaods.entropy.datagen;

import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class EntropyRecipeGen extends FabricRecipeProvider {
    public EntropyRecipeGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                List<ItemConvertible> ENDECITE_SMELTABLE = List.of(EntropyItems.ENDECITE_SHARD, EntropyBlocks.ENDECITE);
                offerSmelting(ENDECITE_SMELTABLE, RecipeCategory.MISC, EntropyItems.ENDECITE_PLATELET, 2.5F, 250, "endecite");
                offerBlasting(ENDECITE_SMELTABLE, RecipeCategory.MISC, EntropyItems.ENDECITE_PLATELET, 2.5F, 125, "endecite");

                offer2x2CompactingRecipe(RecipeCategory.DECORATIONS, EntropyBlocks.ENDELIGHT, EntropyItems.ENDELIGHT_BULB);
            }
        };
    }

    @Override
    public String getName() {
        return "EntropyMod Recipes :)";
    }
}
