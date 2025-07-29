package def.downlaods.entropy.datagen;

import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EntropyLangGen extends FabricLanguageProvider {
    protected EntropyLangGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder builder) {
        builder.add(EntropyItems.ENDECITE_SHARD,"Endecite Shard");
        builder.add(EntropyItems.ENDECITE_PLATELET,"Endecite Platelet");
        builder.add(EntropyItems.ENDELIGHT_BULB,"Endelight Bulb");

        builder.add(EntropyBlocks.END_SAND,"End Sand");
        builder.add(EntropyBlocks.INFUSED_END_SAND,"Infused End Sand");
        builder.add(EntropyBlocks.DENSELY_INFUSED_END_SAND,"Densely Infused End Sand");

        builder.add(EntropyBlocks.ENDECITE,"Endecite");
        builder.add(EntropyBlocks.ENDELIGHT,"Endelight");
    }
}
