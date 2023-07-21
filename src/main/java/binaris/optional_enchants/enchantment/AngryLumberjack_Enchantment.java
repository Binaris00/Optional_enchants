package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class AngryLumberjack_Enchantment extends Enchantment {
    public AngryLumberjack_Enchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[] {EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
