package def.downlaods.entropy.datagen;

import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyItems;
import def.downlaods.entropy.util.EntropyTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EntropyItemTagGen extends FabricTagProvider.ItemTagProvider {
    public EntropyItemTagGen(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(EntropyTags.Items.INFUSION_FUEL)
                .add(EntropyItems.BORNITE);
    }
}
