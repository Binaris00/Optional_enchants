package binaris.optional_enchants.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import org.jetbrains.annotations.Nullable;

public class SimpleEnchantBuilder extends Enchantment {
    Rarity rarity;
    EnchantmentTarget target;
    EquipmentSlot[] equipmentSlots;
    int minPower;
    int maxLevel;
    boolean isCursed;
    boolean isTreasure;
    @Nullable Enchantment[] incompatibleEnchantments;
    @Nullable Item[] applyTo;
    boolean forBookOffer;
    boolean inEnchantingTable;

    public SimpleEnchantBuilder(Rarity weight, EnchantmentTarget type, EquipmentSlot[] equipmentSlots, int minPower, int maxLevel, boolean isCursed, boolean isTreasure, Enchantment[] incompatibleEnchantments, Item[] applyTo, boolean forBookOffer, boolean inEnchantingTable) {
        super(weight, type, equipmentSlots);

        this.rarity = weight;
        this.target = type;
        this.equipmentSlots = equipmentSlots;
        this.minPower = minPower;
        this.maxLevel = maxLevel;
        this.isCursed = isCursed;
        this.isTreasure = isTreasure;
        this.incompatibleEnchantments = incompatibleEnchantments;
        this.applyTo = applyTo;
        this.forBookOffer = forBookOffer;
        this.inEnchantingTable = inEnchantingTable;

    }

    @Override
    public int getMinPower(int level) {
        switch (rarity){
            // 1, 8, 15, 22, 29
            case COMMON -> {return 1 + (level - 1) * 7;}

            // 5, 11, 17, 23, 29
            case UNCOMMON -> {return 5 + (level - 1) * 8;}

            // 6, 12, 18, 24, 30
            case RARE -> {return level * 6;}

            // 9, 18, 27, 36, 45
            default -> {return level * 9;}
        }
    }

    @Override
    public int getMaxPower(int level) {
        return getMinPower(level) + 50;
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
        if(target == EnchantmentTarget.DIGGER && applyTo == null){return stack.getItem() instanceof MiningToolItem;}

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

    @Override
    public boolean isAvailableForRandomSelection() {
        return inEnchantingTable;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return forBookOffer;
    }
}
