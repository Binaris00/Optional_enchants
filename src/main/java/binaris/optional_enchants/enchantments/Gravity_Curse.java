package binaris.optional_enchants.enchantments;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.util.EnchantBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Gravity_Curse extends EnchantBuilder {

    public Gravity_Curse() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET},
                1, true, false, null, null, true, false, "gravity_curse");
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(user.getRandom().nextInt(100) <= OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.probability", 20)){
            if(!user.hasStatusEffect(StatusEffects.LEVITATION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.effect_base_time", 200), OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.effect_amplifier", 2)));
            }
        }
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(user.getRandom().nextInt(100) <= OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.probability", 20)){
            if(!user.hasStatusEffect(StatusEffects.LEVITATION)){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.effect_base_time", 200), OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.effect_amplifier", 2)));
            }
        }
    }
}
