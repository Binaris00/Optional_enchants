package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Gravity_Curse extends Enchantment {
    public Gravity_Curse() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(user.getRandom().nextInt(100) <= 20){
            if(!user.hasStatusEffect(StatusEffects.LEVITATION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 2));
            }
        }
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(user.getRandom().nextInt(100) <= 20){
            if(!user.hasStatusEffect(StatusEffects.LEVITATION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 200, 2));
            }
        }
    }
}
