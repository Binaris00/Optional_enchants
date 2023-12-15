package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.util.EnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class Hunting extends EnchantBuilder {


    public Hunting() {
        super(Rarity.COMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}, 3, false, false, null,
                null, true, true, "hunting");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity){
            if(livingEntity.getType() == EntityType.PIG || livingEntity.getType() == EntityType.COW ||
                    livingEntity.getType() == EntityType.CHICKEN || livingEntity.getType() == EntityType.SHEEP ||
                    livingEntity.getType() == EntityType.MOOSHROOM || livingEntity.getType() == EntityType.RABBIT){
                target.damage(target.getWorld().getDamageSources().mobAttack(user),  Config.getFloat("hunting.damage") * level);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }
}
