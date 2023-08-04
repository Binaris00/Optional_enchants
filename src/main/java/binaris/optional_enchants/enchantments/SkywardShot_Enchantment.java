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

public class SkywardShot_Enchantment extends EnchantBuilder {
    public SkywardShot_Enchantment() {
        super(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}, 2, false, true, null, null, true, true, "skyward_shot");
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
        if (user.getRandom().nextInt(100) <= OptionalEnchantsConfig.CONFIG.getOrDefault("skyward_shot.effect_probability", 10) * level) {
            if (target instanceof LivingEntity livingEntity && !livingEntity.hasStatusEffect(StatusEffects.LEVITATION)) {
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, OptionalEnchantsConfig.CONFIG.getOrDefault("skyward_shot.effect_time_base", 100),
                        OptionalEnchantsConfig.CONFIG.getOrDefault("skyward_shot.effect_amplifier", 1)));
            }
        }
    }
}