package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.util.EnchantmentBuilderAxe;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class Cleaving_Enchantment extends EnchantmentBuilderAxe {


    public Cleaving_Enchantment() {
        super(Rarity.UNCOMMON, 4, false, false, null, true, true, "cleaving");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        for(ItemStack stack : target.getArmorItems()){
            if(stack != null && user.getRandom().nextInt(100) <= OptionalEnchantsConfig.CONFIG.getOrDefault("cleaving.probability", 20)){
                if(target instanceof LivingEntity livingEntity){
                    stack.damage(level, livingEntity, (e) -> {
                        e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
                    });
                }
            }
        }
    }


}
