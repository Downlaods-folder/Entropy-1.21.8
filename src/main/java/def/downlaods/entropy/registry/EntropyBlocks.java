package def.downlaods.entropy.registry;

import def.downlaods.entropy.Entropy;
import def.downlaods.entropy.block.InfusionBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class EntropyBlocks {
    public static final Block END_SAND = registerBlock("end_sand", properties -> new Block(properties
            .mapColor(MapColor.PALE_YELLOW).instrument(NoteBlockInstrument.SNARE).strength(0.7F).sounds(BlockSoundGroup.SAND)
    ));
    public static final Block INFUSED_END_SAND = registerBlock("infused_end_sand", properties -> new Block(properties
            .mapColor(MapColor.PALE_GREEN).instrument(NoteBlockInstrument.FLUTE).strength(1.0F).sounds(BlockSoundGroup.SCULK)
    ));
    public static final Block DENSELY_INFUSED_END_SAND = registerBlock("densely_infused_end_sand", properties -> new Block(properties
            .mapColor(MapColor.BLACK).instrument(NoteBlockInstrument.BASEDRUM).strength(1.3F).sounds(BlockSoundGroup.DEEPSLATE)
    ));

    public static final Block ENDECITE = registerBlock("endecite", properites -> new Block(properites
            .mapColor(MapColor.PURPLE).requiresTool().strength(50.0F, 1200.0F).sounds(BlockSoundGroup.AMETHYST_BLOCK)
    ));
    public static final Block ENDELIGHT = registerBlock("endelight", properites -> new Block(properites
            .mapColor(MapColor.WATER_BLUE).strength(0.3F,10F).luminance(state -> 15).sounds(BlockSoundGroup.FROGLIGHT)
    ));

    public static final Block INFUSION_BLOCK = registerBlock("infusion_block", properites -> new InfusionBlock(properites
            .mapColor(MapColor.DARK_AQUA).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().luminance(state -> 9).strength(5.0F, 1200.0F)));


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Entropy.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(Entropy.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(Entropy.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Entropy.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Entropy.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Entropy.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        Entropy.LOGGER.info("Registering Mod Blocks for " + Entropy.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
        });
    }
}
