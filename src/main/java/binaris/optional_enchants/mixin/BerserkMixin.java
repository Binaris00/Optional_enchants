package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(LivingEntity.class)
public abstract class BerserkMixin {
    @Shadow @Final private static Logger LOGGER;
    @Unique
    UUID BERSERK_ATTRIBUTE_ID = UUID.fromString("FFFFFFFF-EEEE-DDDD-CCCC-000000000002");
    @Inject(method = "tick", at = @At("HEAD"))
    public void berserkCheck(CallbackInfo ci){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
            if (livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, BERSERK_ATTRIBUTE_ID) && !EnchantUtils.hasEnchant(livingEntity, OptionalEnchants_Enchantments.BERSERK, EquipmentSlot.MAINHAND)) {
                livingEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).removeModifier(BERSERK_ATTRIBUTE_ID);
                LOGGER.info("removiendo...");
            }




            if(!livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_ATTACK_DAMAGE, BERSERK_ATTRIBUTE_ID) && EnchantUtils.hasEnchant(livingEntity, OptionalEnchants_Enchantments.BERSERK, EquipmentSlot.MAINHAND)) {
                float inVar = (livingEntity.getMaxHealth() - livingEntity.getHealth() * EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.BERSERK, EquipmentSlot.MAINHAND));
                EntityAttributeModifier attribute = new EntityAttributeModifier(BERSERK_ATTRIBUTE_ID, "berserk_enchantment",
                        (float) OptionalEnchantsConfig.CONFIG.getOrDefault("berserk.mult", 0.629D) * Math.log10(inVar) /
                                Math.log10(OptionalEnchantsConfig.CONFIG.getOrDefault("berserk.logbase", 10) + OptionalEnchantsConfig.CONFIG.getOrDefault("berserk.base", 0.2D)),
                        EntityAttributeModifier.Operation.ADDITION);
                livingEntity.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).addTemporaryModifier(attribute);
                LOGGER.info("Encantamiento funcionando!");
            }
    }
}
