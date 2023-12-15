package binaris.optional_enchants.enchantment;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OE_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;

import java.util.UUID;

public class Barbaric extends SimpleEnchantBuilder {

    UUID BARBARIC_ATTRIBUTE_ID = UUID.fromString("FFFFFFFF-EEEE-DDDD-CCCC-000000000001");
    public Barbaric() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND}, 1, false, false,
                null, MoreTargets.AXE, true, true, "barbaric");
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(EnchantUtils.hasEnchant(user, OE_Enchantments.BARBARIC, EquipmentSlot.MAINHAND)){
            if (user.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, BARBARIC_ATTRIBUTE_ID)) {
                user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(BARBARIC_ATTRIBUTE_ID);
            }

            if(!user.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, BARBARIC_ATTRIBUTE_ID)){
                EntityAttributeModifier attribute = new EntityAttributeModifier(BARBARIC_ATTRIBUTE_ID, "barbaric_damage_enchantment", Config.getDouble("barbaric.damage") * (20 - user.getArmor()), EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
                user.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).addTemporaryModifier(attribute);
            }

        }
    }
}
