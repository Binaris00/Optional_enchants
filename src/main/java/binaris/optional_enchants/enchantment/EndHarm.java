package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class EndHarm extends SimpleEnchantBuilder {


    public EndHarm() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}, 5, false, false, null, null, true, true, "end_harm");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity) {
            if(target.getType() == EntityType.ENDERMAN || target.getType() == EntityType.ENDERMITE || target.getType() == EntityType.ENDER_DRAGON || target.getType() == EntityType.SHULKER) {

                target.damage(target.getWorld().getDamageSources().mobAttack(user), Config.getFloat("end_harm.attack_damage") * level);
                int i = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, 3));
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }


    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }
    @Override
    public boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment || other instanceof NetherBane);
    }
}
