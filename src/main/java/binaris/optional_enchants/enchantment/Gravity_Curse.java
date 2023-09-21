package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Gravity_Curse extends SimpleEnchantBuilder {

    public Gravity_Curse() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET},
                1, true, false, null, null, true, false, "gravity_curse");
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(user.getRandom().nextInt(100) <= Config.getInt("gravity_curse.probability")){
            if(!user.hasStatusEffect(StatusEffects.LEVITATION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, Config.getInt("gravity_curse.effect_base_time"), Config.getInt("gravity_curse.effect_amplifier")));
            }
        }
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(user.getRandom().nextInt(100) <= Config.getInt("gravity_curse.probability")){
            if(!user.hasStatusEffect(StatusEffects.LEVITATION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, Config.getInt("gravity_curse.effect_base_time"), Config.getInt("gravity_curse.effect_amplifier")));
            }
        }
    }
}
