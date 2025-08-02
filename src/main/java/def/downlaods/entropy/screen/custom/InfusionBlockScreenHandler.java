package def.downlaods.entropy.screen.custom;

import def.downlaods.entropy.block.entity.custom.InfusionBlockEntity;
import def.downlaods.entropy.recipe.InfusionBlockRecipe;
import def.downlaods.entropy.screen.EntropyScreenHandlers;
import def.downlaods.entropy.util.EntropyTags;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class InfusionBlockScreenHandler extends ScreenHandler {
    static final Identifier EMPTY_INFUSION_FUEL_SLOT_TEXTURE = Identifier.ofVanilla("container/slot/brewing_fuel");
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    public final InfusionBlockEntity blockEntity;

    public InfusionBlockScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(7));
    }

    public InfusionBlockScreenHandler(int syncId, PlayerInventory playerInventory,
                                      BlockEntity blockEntity, PropertyDelegate arrayPropertyDelegate) {
        super(EntropyScreenHandlers.INFUSION_BLOCK_SCREEN_HANDLER, syncId);
        this.inventory = ((Inventory) blockEntity);
        this.blockEntity = ((InfusionBlockEntity) blockEntity);
        this.propertyDelegate = arrayPropertyDelegate;

        this.addSlot(new InfusionBlockScreenHandler.FuelSlot(inventory, 0, 17, 17));

        this.addSlot(new Slot(inventory, 1, 62, 35));
        this.addSlot(new Slot(inventory, 2, 44, 35));
        this.addSlot(new Slot(inventory, 3, 80, 35));
        this.addSlot(new Slot(inventory, 4, 62, 17));
        this.addSlot(new Slot(inventory, 5, 62, 53));

        this.addSlot(new InfusionBlockScreenHandler.InfusionOutputSlot(inventory, 6, 130, 35, playerInventory.player));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);

        addProperties(arrayPropertyDelegate);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1); // Max Progress
        int arrowPixelSize = 24; // This is the width in pixels of your arrow

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    static class FuelSlot extends Slot {
        public FuelSlot(Inventory inventory, int i, int j, int k) {
            super(inventory, i, j, k);
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return matches(stack);
        }

        public static boolean matches(ItemStack stack) {
            return stack.isIn(EntropyTags.Items.INFUSION_FUEL);
        }

        @Override
        public Identifier getBackgroundSprite() {
            return InfusionBlockScreenHandler.EMPTY_INFUSION_FUEL_SLOT_TEXTURE;
        }
    }

    static class InfusionOutputSlot extends Slot {
        private final PlayerEntity player;
        private int amount;

        public InfusionOutputSlot(Inventory inventory, int index, int x, int y, PlayerEntity player) {
            super(inventory, index, x, y);
            this.player = player;
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return false;
        }

        @Override
        public ItemStack takeStack(int amount) {
            if (this.hasStack()) {
                this.amount = this.amount + Math.min(amount, this.getStack().getCount());
            }

            return super.takeStack(amount);
        }

        @Override
        public void onTakeItem(PlayerEntity player, ItemStack stack) {
            this.onCrafted(stack);
            super.onTakeItem(player, stack);
        }

        @Override
        protected void onCrafted(ItemStack stack, int amount) {
            this.amount += amount;
            this.onCrafted(stack);
        }

        @Override
        protected void onCrafted(ItemStack stack) {
            stack.onCraftByPlayer(this.player, this.amount);
            if (this.player instanceof ServerPlayerEntity serverPlayerEntity && this.inventory instanceof AbstractFurnaceBlockEntity abstractFurnaceBlockEntity) {
                abstractFurnaceBlockEntity.dropExperienceForRecipesUsed(serverPlayerEntity);
            }

            this.amount = 0;
        }
    }
}
