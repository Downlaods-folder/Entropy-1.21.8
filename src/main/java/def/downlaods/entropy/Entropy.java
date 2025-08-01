package def.downlaods.entropy;

import def.downlaods.entropy.block.entity.EntropyBlockEntities;
import def.downlaods.entropy.recipe.EntropyRecipes;
import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyGroups;
import def.downlaods.entropy.registry.EntropyItems;
import def.downlaods.entropy.screen.EntropyScreenHandlers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entropy implements ModInitializer {

    public static final String MOD_ID = "entropy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        EntropyGroups.registerItemGroups();

        EntropyItems.registerModItems();
        EntropyBlocks.registerModBlocks();

        EntropyBlockEntities.registerBlockEntities();
        EntropyRecipes.registerRecipes();
        EntropyScreenHandlers.registerScreenHandlers();
    }
}
