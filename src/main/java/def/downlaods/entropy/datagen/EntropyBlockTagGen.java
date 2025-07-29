package def.downlaods.entropy.datagen;

import def.downlaods.entropy.registry.EntropyBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class EntropyBlockTagGen extends FabricTagProvider.BlockTagProvider {
    public EntropyBlockTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(EntropyBlocks.ENDECITE);

        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(EntropyBlocks.ENDECITE);
    }
}
