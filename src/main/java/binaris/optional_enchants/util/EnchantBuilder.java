package binaris.optional_enchants.util;

import binaris.optional_enchants.Optional_Enchants;
import binaris.optional_enchants.config.Config;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class EnchantBuilder extends Enchantment {
    /**Rare, Uncommon, Common, Very Rare*/
    Rarity rarity;
    EnchantmentTarget target;
    EquipmentSlot[] equipmentSlots;
    int maxLevel;
    boolean isCursed;
    boolean isTreasure;
    @Nullable Enchantment[] incompatibleEnchantments;
    @Nullable MoreTargets specificTarget;
    boolean forBookOffer;
    boolean inEnchantingTable;
    String id;

    public EnchantBuilder(Rarity weight, EnchantmentTarget type, EquipmentSlot[] equipmentSlots, int maxLevel, boolean isCursed, boolean isTreasure, Enchantment[] incompatibleEnchantments, @Nullable MoreTargets specificTarget, boolean forBookOffer, boolean inEnchantingTable, String id) {
        super(weight, type, equipmentSlots);

        this.rarity = weight;
        this.target = type;
        this.equipmentSlots = equipmentSlots;
        this.maxLevel = maxLevel;
        this.isCursed = isCursed;
        this.isTreasure = isTreasure;
        this.incompatibleEnchantments = incompatibleEnchantments;
        this.specificTarget = specificTarget;
        this.forBookOffer = forBookOffer;
        this.inEnchantingTable = inEnchantingTable;
        this.id = id;

        if(Config.getBool(id + ".enable")){
            Registry.register(Registries.ENCHANTMENT, new Identifier(Optional_Enchants.MOD_ID, id), this);
        }
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
        if(specificTarget != null){
            switch (specificTarget){
                case AXE -> {return stack.getItem() instanceof AxeItem;}

                case SHIELD -> {return stack.getItem() instanceof ShieldItem;}
            }
        }
        return super.isAcceptableItem(stack);
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
    public boolean isAvailableForEnchantedBookOffer() {return forBookOffer;}

    public enum MoreTargets{
        AXE,
        SHIELD
    }
}
