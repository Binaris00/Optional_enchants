package binaris.optional_enchants.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class EnchantmentBuilderAxe extends SimpleEnchantBuilder {

    public EnchantmentBuilderAxe(Rarity weight, int maxLevel, boolean isCursed, boolean isTreasure, Enchantment[] incompatibleEnchantments, boolean forBookOffer, boolean inEnchantingTable, String id) {
        super(weight, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}, maxLevel, isCursed, isTreasure, incompatibleEnchantments, null, forBookOffer, inEnchantingTable, id);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof AxeItem;
    }
}
