package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;

public class NetherBane_Enchantment extends Enchantment {
    public NetherBane_Enchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof DamageEnchantment || other instanceof EndHarm_Enchantment);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity){
            if(livingEntity.getType() == EntityType.ZOMBIFIED_PIGLIN || livingEntity.getType() == EntityType.PIGLIN ||
                    livingEntity.getType() == EntityType.PIGLIN_BRUTE || livingEntity.getType() == EntityType.HOGLIN || livingEntity.getType() == EntityType.ZOGLIN){

                target.damage(target.getWorld().getDamageSources().mobAttack(user), 3.0F * level);
            }
        }
    }
}
