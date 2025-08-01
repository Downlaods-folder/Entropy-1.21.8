package def.downlaods.entropy.client;

import def.downlaods.entropy.screen.EntropyScreenHandlers;
import def.downlaods.entropy.screen.custom.InfusionBlockScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

public class EntropyClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(EntropyScreenHandlers.INFUSION_BLOCK_SCREEN_HANDLER, InfusionBlockScreen::new);
    }
}
