package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;

import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Ice_Bow_Enchantment extends SimpleEnchantBuilder {

    public Ice_Bow_Enchantment() {
        super(Rarity.RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
                3, false, false, new Enchantment[]{Enchantments.FLAME}, null,
                true, true, "ice_bow");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity Living_target){
            if(level >= 3 && Living_target.hasStatusEffect(StatusEffects.SLOWNESS)){
                int old_duration = Living_target.getStatusEffect(StatusEffects.SLOWNESS).getDuration();
                Living_target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,
                        OptionalEnchantsConfig.CONFIG.getOrDefault("ice_bow.effect_base_time", 60)+old_duration, OptionalEnchantsConfig.CONFIG.getOrDefault("ice_bow_effect_amplifier", 1)));

            }
            else{
                ((LivingEntity) target).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, OptionalEnchantsConfig.CONFIG.getOrDefault("ice_bow.effect_base_time", 60), OptionalEnchantsConfig.CONFIG.getOrDefault("ice_bow_effect_amplifier", 1)));
            }

        }
        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.FLAME;
    }

}
