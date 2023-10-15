package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

import java.util.UUID;

public class Fat extends SimpleEnchantBuilder {

    static UUID ATTRIBUTE_UUID = UUID.fromString("28AB5178-2BC4-11EE-BE56-0242AC120002");
    public Fat(Rarity weight, EnchantmentTarget type, EquipmentSlot[] equipmentSlots, int maxLevel, boolean isCursed, boolean isTreasure, Enchantment[] incompatibleEnchantments, MoreTargets specificTarget, boolean forBookOffer, boolean inEnchantingTable, String id) {
        super(weight, type, equipmentSlots, maxLevel, isCursed, isTreasure, incompatibleEnchantments, specificTarget, forBookOffer, inEnchantingTable, id);
    }

    public static UUID getUUID(){return ATTRIBUTE_UUID;}
}
