package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class NetherBane extends SimpleEnchantBuilder {


    public NetherBane() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}, 5, false, false, null, null, true, true, "nether_bane");
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
        return !(other instanceof DamageEnchantment || other instanceof EndHarm);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity){
            if(livingEntity.getType() == EntityType.ZOMBIFIED_PIGLIN || livingEntity.getType() == EntityType.PIGLIN ||
                    livingEntity.getType() == EntityType.PIGLIN_BRUTE || livingEntity.getType() == EntityType.HOGLIN || livingEntity.getType() == EntityType.ZOGLIN){

                target.damage(target.getWorld().getDamageSources().mobAttack(user), (Config.getFloat("nether_base.base_damage") * level));
            }
        }
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);
    }
}
