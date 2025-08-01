package def.downlaods.entropy.screen;

import def.downlaods.entropy.Entropy;
import def.downlaods.entropy.screen.custom.InfusionBlockScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class EntropyScreenHandlers {
    public static final ScreenHandlerType<InfusionBlockScreenHandler> INFUSION_BLOCK_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(Entropy.MOD_ID, "infusion_block_screen_handler"),
                    new ExtendedScreenHandlerType<>(InfusionBlockScreenHandler::new, BlockPos.PACKET_CODEC));


    public static void registerScreenHandlers() {
        Entropy.LOGGER.info("Registering Screen Handlers for " + Entropy.MOD_ID);
    }
}
