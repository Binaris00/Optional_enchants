package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class Cleaving extends SimpleEnchantBuilder {

    public Cleaving() {
        super(Rarity.UNCOMMON,
                EnchantmentTarget.WEAPON,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
                4,
                false,
                false,
                null,
                null,
                true, true, "cleaving");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        for(ItemStack stack : target.getArmorItems()){
            if(stack != null && user.getRandom().nextInt(100) <= Config.getInt("cleaving.probability")){
                if(target instanceof LivingEntity livingEntity){
                    stack.damage(level, livingEntity, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
                }
            }
        }
    }


}
