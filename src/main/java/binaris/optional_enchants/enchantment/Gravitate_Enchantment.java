package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.SwiftSneakEnchantment;
import net.minecraft.entity.EquipmentSlot;

public class Gravitate_Enchantment extends Enchantment {
    public Gravitate_Enchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS});
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getMinPower(int level) {
        return 30;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof SwiftSneakEnchantment);
    }
}
