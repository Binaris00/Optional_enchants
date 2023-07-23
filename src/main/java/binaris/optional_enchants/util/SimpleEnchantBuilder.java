package binaris.optional_enchants.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class SimpleEnchantBuilder extends Enchantment {
    Rarity rarity;
    int minPower;
    int maxPower;
    int maxLevel;
    boolean isCursed;
    boolean isTreasure;
    @Nullable Enchantment[] incompatibleEnchantments;
    @Nullable Item[] applyTo;

    public SimpleEnchantBuilder(Rarity weight, EnchantmentTarget type, EquipmentSlot[] equipmentSlots, int minPower, int maxPower, int maxLevel, boolean isCursed, boolean isTreasure, Enchantment[] incompatibleEnchantments, Item[] applyTo) {
        super(weight, type, equipmentSlots);
        this.rarity = weight;
        this.minPower = minPower;
        this.maxPower = maxPower;
        this.maxLevel = maxLevel;
        this.isCursed = isCursed;
        this.isTreasure = isTreasure;
        this.incompatibleEnchantments = incompatibleEnchantments;
        this.applyTo = applyTo;

    }

    @Override
    public int getMinPower(int level) {
        return minPower;
    }

    @Override
    public int getMaxPower(int level) {
        return maxPower;
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        if(incompatibleEnchantments != null) {
            if (EnchantUtils.isEnchantType(other, incompatibleEnchantments))
                return false;
        }

        return super.canAccept(other);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        if(applyTo != null) {
            for (Item i : applyTo) {
                if (stack.getItem() == i) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isCursed() {
        return isCursed;
    }

    @Override
    public boolean isTreasure() {
        return isTreasure;
    }

    @Override
    public Rarity getRarity() {
        return this.rarity;
    }
}
