package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;

public class Betrayer_Enchantment extends Enchantment {
    public Betrayer_Enchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND});
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if(livingEntity.getType() == EntityType.PILLAGER || livingEntity.getType() == EntityType.RAVAGER ||
                    livingEntity.getType() == EntityType.EVOKER || livingEntity.getType() == EntityType.VINDICATOR || livingEntity.getType() == EntityType.ILLUSIONER) {
                target.damage(target.getWorld().getDamageSources().arrow(new ArrowEntity(user.getWorld(), user), user), 3.0F * level);
                int i = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, i, 2));
            }
        }
    }

    @Override
    public int getMinPower(int level) {
        return 20;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }
}
