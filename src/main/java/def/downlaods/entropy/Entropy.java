package def.downlaods.entropy;

import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Entropy implements ModInitializer {

    public static final String MOD_ID = "entropy";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        EntropyItems.registerModItems();
        EntropyBlocks.registerModBlocks();

        LOGGER.info("Mod Implemented :D");
    }
}
