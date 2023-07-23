package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class SkywardShot_Enchantment extends Enchantment {
    public SkywardShot_Enchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (user.getRandom().nextInt(100) <= 10 * level){
            if(target instanceof LivingEntity livingEntity && !livingEntity.hasStatusEffect(StatusEffects.LEVITATION)){
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 1));
            }
        }
    }
}
