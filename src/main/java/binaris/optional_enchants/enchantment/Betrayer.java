package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.util.EnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.ArrowEntity;

public class Betrayer extends EnchantBuilder {


    public Betrayer() {
        super(Rarity.RARE, EnchantmentTarget.CROSSBOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
                4, false, false, null, null, true, true, "betrayer");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {
            if(livingEntity.getType() == EntityType.PILLAGER || livingEntity.getType() == EntityType.RAVAGER ||
                    livingEntity.getType() == EntityType.EVOKER || livingEntity.getType() == EntityType.VINDICATOR || livingEntity.getType() == EntityType.ILLUSIONER) {
                target.damage(target.getWorld().getDamageSources().arrow(new ArrowEntity(user.getWorld(), user), user), Config.getFloat("betrayer.base_damage") * level);
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
