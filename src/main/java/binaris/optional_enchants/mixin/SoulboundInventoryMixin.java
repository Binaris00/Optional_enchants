package binaris.optional_enchants.mixin;

import binaris.optional_enchants.registry.OE_Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PlayerInventory.class)
public class SoulboundInventoryMixin {

    @Unique
    ItemStack stack = ItemStack.EMPTY;

    @ModifyArg(
            method = "dropAll",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;"
            )
    )
    private ItemStack dontDropSoulbound(ItemStack stack) {
        this.stack = ItemStack.EMPTY;
        if (EnchantmentHelper.getLevel(OE_Enchantments.SOULBOUND, stack) > 0)
            this.stack = stack;
        return (EnchantmentHelper.getLevel(OE_Enchantments.SOULBOUND, stack) > 0) ? ItemStack.EMPTY : stack;
    }

    @ModifyArg(
            method = "dropAll",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/List;set(ILjava/lang/Object;)Ljava/lang/Object;"
            )
    )
    private Object dontRemoveSoulbound(Object stack) {
        return this.stack;
    }
}
