package binaris.optional_enchants.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;

public class Hunting_Enchantment extends Enchantment {
    public Hunting_Enchantment() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity){
            if(livingEntity.getType() == EntityType.PIG || livingEntity.getType() == EntityType.COW ||
                    livingEntity.getType() == EntityType.CHICKEN || livingEntity.getType() == EntityType.SHEEP ||
                    livingEntity.getType() == EntityType.MOOSHROOM || livingEntity.getType() == EntityType.RABBIT){
                target.damage(target.getWorld().getDamageSources().mobAttack(user), 5.0F * level);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof MiningToolItem || super.isAcceptableItem(stack);
    }
}
