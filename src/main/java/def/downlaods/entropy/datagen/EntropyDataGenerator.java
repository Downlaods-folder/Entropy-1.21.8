package def.downlaods.entropy.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class EntropyDataGenerator implements DataGeneratorEntrypoint {
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(EntropyLangGen::new);
        pack.addProvider(EntropyModelGen::new);
        pack.addProvider(EntropyRecipeGen::new);
        pack.addProvider(EntropyBlockLootTableGen::new);
        pack.addProvider(EntropyBlockTagGen::new);
    }
}
