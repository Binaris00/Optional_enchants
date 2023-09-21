package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class Exposing_Enchantment extends SimpleEnchantBuilder {
    public Exposing_Enchantment() {
        super(Rarity.RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND}, 3, false, false, null, null, true, true, "exposing");
    }


    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(EnchantUtils.getLevel(user, OptionalEnchants_Enchantments.EXPOSING) >= 1 && target instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, Config.getInt("exposing.effect_base_time") * EnchantUtils.getLevel(user, OptionalEnchants_Enchantments.EXPOSING)));
        }
    }
}
