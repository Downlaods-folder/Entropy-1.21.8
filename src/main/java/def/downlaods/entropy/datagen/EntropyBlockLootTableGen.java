package def.downlaods.entropy.datagen;

import def.downlaods.entropy.registry.EntropyBlocks;
import def.downlaods.entropy.registry.EntropyItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class EntropyBlockLootTableGen extends FabricBlockLootTableProvider {
    protected EntropyBlockLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(EntropyBlocks.END_SAND);
        addDrop(EntropyBlocks.INFUSED_END_SAND);
        addDrop(EntropyBlocks.DENSELY_INFUSED_END_SAND);

        addDrop(EntropyBlocks.ENDECITE, oreDrops(EntropyBlocks.ENDECITE, EntropyItems.ENDECITE_SHARD));
        addDrop(EntropyBlocks.ENDELIGHT, multipleOreDrops(EntropyBlocks.ENDELIGHT, EntropyItems.ENDELIGHT_BULB, 1, 3));
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
