package def.downlaods.entropy.registry;

import def.downlaods.entropy.Entropy;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class EntropyItems {
    public static final Item ENDECITE_SHARD = registerItem("endecite_shard", Item::new);
    public static final Item ENDECITE_PLATELET = registerItem("endecite_platelet", Item::new);
    public static final Item ENDELIGHT_BULB = registerItem("endelight_bulb", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Entropy.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Entropy.MOD_ID, name)))));
    }
    public static void registerModItems() {
        Entropy.LOGGER.info("Registering Mod Items for " + Entropy.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            // add stuff to main mc creative
        });
    }
}
