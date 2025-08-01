package def.downlaods.entropy.registry;

import def.downlaods.entropy.Entropy;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EntropyGroups {
    public static final ItemGroup ENTROPY_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Entropy.MOD_ID, "entropy_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(EntropyItems.BORNITE))
                    .displayName(Text.translatable("itemGroup.entropy.entropy_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(EntropyItems.ENDECITE_SHARD);
                        entries.add(EntropyItems.ENDECITE_PLATELET);

                        entries.add(EntropyItems.ENDELIGHT_BULB);

                        entries.add(EntropyItems.BORNITE);

                        entries.add(EntropyItems.ROSE_QUARTZ);
                    }).build());

    public static final ItemGroup ENTROPY_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Entropy.MOD_ID, "entropy_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(EntropyBlocks.ENDELIGHT))
                    .displayName(Text.translatable("itemGroup.entropy.entropy_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(EntropyBlocks.END_SAND);
                        entries.add(EntropyBlocks.INFUSED_END_SAND);
                        entries.add(EntropyBlocks.DENSELY_INFUSED_END_SAND);

                        entries.add(EntropyBlocks.ENDECITE);
                        entries.add(EntropyBlocks.ENDELIGHT);

                        entries.add(EntropyBlocks.INFUSION_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        Entropy.LOGGER.info("Registering Item Groups for " + Entropy.MOD_ID);
    }
}
