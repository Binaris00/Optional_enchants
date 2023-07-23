package binaris.optional_enchants.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class EnchantUtils {

    public static boolean hasEnchant(LivingEntity livingEntity, Enchantment enchantment, EquipmentSlot slot){
        return EnchantmentHelper.getLevel(enchantment, livingEntity.getEquippedStack(slot)) >= 1;
    }

    public static boolean hasEnchant(ItemStack itemStack, Enchantment enchantment){
        return EnchantmentHelper.getLevel(enchantment, itemStack) >= 1;
    }

    public static int getLevel(LivingEntity livingEntity, Enchantment enchantment){
        if(EnchantmentHelper.getLevel(enchantment, livingEntity.getMainHandStack()) >= 1){return EnchantmentHelper.getLevel(enchantment, livingEntity.getMainHandStack());}
        if(EnchantmentHelper.getLevel(enchantment,  livingEntity.getOffHandStack()) >= 1){return EnchantmentHelper.getLevel(enchantment, livingEntity.getOffHandStack());}
        return 0;
    }

    public static int getLevel(LivingEntity livingEntity, Enchantment enchantment, EquipmentSlot slot){
        if(EnchantmentHelper.getLevel(enchantment, livingEntity.getEquippedStack(slot)) >= 1){return EnchantmentHelper.getLevel(enchantment, livingEntity.getEquippedStack(slot));}
        return 0;
    }

    public static void appendDuration(LivingEntity livingEntity, StatusEffect status, int more_duration, int amplifier){
        if(livingEntity.hasStatusEffect(status)){
            int old_duration = livingEntity.getStatusEffect(status).getDuration();
            int old_amplifier = livingEntity.getStatusEffect(status).getAmplifier();

            livingEntity.addStatusEffect(new StatusEffectInstance(status, old_duration + more_duration, old_amplifier));
        }
        else{
            livingEntity.addStatusEffect(new StatusEffectInstance(status, more_duration, amplifier));
        }
    }

    public static boolean hasFullArmorEnchant(PlayerEntity player, Enchantment enchantment){
        if(hasAllArmor(player)) {
            return hasEnchant(player, enchantment, EquipmentSlot.HEAD) && hasEnchant(player, enchantment, EquipmentSlot.CHEST)
                    && hasEnchant(player, enchantment, EquipmentSlot.LEGS) && hasEnchant(player, enchantment, EquipmentSlot.FEET);
        }

        return false;
    }

    private static boolean hasAllArmor(PlayerEntity player) {
        ItemStack boots = player.getInventory().getArmorStack(0);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack breastplate = player.getInventory().getArmorStack(2);
        ItemStack helmet = player.getInventory().getArmorStack(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    public static boolean isEnchantType(Enchantment other, Enchantment[] type) {
        if (type == null) return false;
        for(Enchantment e : type) {
            if (other == e) return true;
        }
        return false;
    }
}
