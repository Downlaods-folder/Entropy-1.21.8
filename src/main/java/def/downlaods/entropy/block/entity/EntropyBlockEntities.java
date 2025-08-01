package def.downlaods.entropy.block.entity;

import def.downlaods.entropy.Entropy;
import def.downlaods.entropy.block.entity.custom.InfusionBlockEntity;
import def.downlaods.entropy.registry.EntropyBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntropyBlockEntities {
    public static final BlockEntityType<InfusionBlockEntity> INFUSION_BLOCK_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(Entropy.MOD_ID, "infusion_block_be"),
                    FabricBlockEntityTypeBuilder.create(InfusionBlockEntity::new, EntropyBlocks.INFUSION_BLOCK).build(null));


    public static void registerBlockEntities() {
        Entropy.LOGGER.info("Registering Block Entities for " + Entropy.MOD_ID);
    }
}
