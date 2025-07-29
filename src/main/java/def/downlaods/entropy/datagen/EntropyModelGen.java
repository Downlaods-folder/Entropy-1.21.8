package def.downlaods.entropy.datagen;

import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class EntropyModelGen extends FabricModelProvider {
    public EntropyModelGen(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(EntropyBlocks.END_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(EntropyBlocks.INFUSED_END_SAND);
        blockStateModelGenerator.registerSimpleCubeAll(EntropyBlocks.DENSELY_INFUSED_END_SAND);

        blockStateModelGenerator.registerSimpleCubeAll(EntropyBlocks.ENDECITE);
        blockStateModelGenerator.registerSimpleCubeAll(EntropyBlocks.ENDELIGHT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(EntropyItems.ENDECITE_SHARD, Models.GENERATED);
        itemModelGenerator.register(EntropyItems.ENDECITE_PLATELET, Models.GENERATED);
        itemModelGenerator.register(EntropyItems.ENDELIGHT_BULB, Models.GENERATED);
    }
}
