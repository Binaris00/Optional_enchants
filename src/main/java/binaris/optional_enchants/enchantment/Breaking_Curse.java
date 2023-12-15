package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.registry.OE_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import binaris.optional_enchants.util.EnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;


public class Breaking_Curse extends EnchantBuilder {


    public Breaking_Curse() {
        super(Rarity.RARE, EnchantmentTarget.VANISHABLE, EquipmentSlot.values(), 2, true, false,
                null, null, true, false, "breaking_curse");
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        for(ItemStack stack : user.getArmorItems()){
            if(EnchantUtils.hasEnchant(stack, OE_Enchantments.BREAKING_CURSE)){
                stack.damage(level, user, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.HEAD));}
        }
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(user.getMainHandStack().getItem() instanceof ToolItem){
            ItemStack stack = user.getMainHandStack();

            if(EnchantUtils.hasEnchant(stack, OE_Enchantments.BREAKING_CURSE)){
                stack.damage(level, user, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.HEAD));}
        }


    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
