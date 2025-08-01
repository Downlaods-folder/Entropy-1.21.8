package def.downlaods.entropy.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record InfusionBlockRecipe (Ingredient inputItem, ItemStack output) implements Recipe<InfusionBlockRecipeInput> {
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    // read Recipe JSON files --> new GrowthChamberRecipe

    @Override
    public boolean matches(InfusionBlockRecipeInput input, World world) {
        if(world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(InfusionBlockRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<InfusionBlockRecipeInput>> getSerializer() {
        return EntropyRecipes.INFUSION_BLOCK_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<InfusionBlockRecipeInput>> getType() {
        return EntropyRecipes.INFUSION_BLOCK_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
        return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<InfusionBlockRecipe> {
        public static final MapCodec<InfusionBlockRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(InfusionBlockRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(InfusionBlockRecipe::output)
        ).apply(inst, InfusionBlockRecipe::new));

        public static final PacketCodec<RegistryByteBuf, InfusionBlockRecipe> STREAM_CODEC =
                PacketCodec.tuple(
                        Ingredient.PACKET_CODEC, InfusionBlockRecipe::inputItem,
                        ItemStack.PACKET_CODEC, InfusionBlockRecipe::output,
                        InfusionBlockRecipe::new);

        @Override
        public MapCodec<InfusionBlockRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, InfusionBlockRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
