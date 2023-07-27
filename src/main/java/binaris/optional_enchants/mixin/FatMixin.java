package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.enchantment.Fat_Enchantment;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class FatMixin {


    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Inject(at = @At("HEAD"), method = "tick")
    public void onEquipFat(CallbackInfo ci){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        int armor = 0;

        for(ItemStack stack : getArmorItems()) {
            if (EnchantUtils.hasEnchant(stack, OptionalEnchants_Enchantments.FAT)) {
                armor += 1;
            }

            if (livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MAX_HEALTH, Fat_Enchantment.getUUID())) {
                livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(Fat_Enchantment.getUUID());
            }
        }



        if(!livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MAX_HEALTH, Fat_Enchantment.getUUID())){
            EntityAttributeModifier attribute = new EntityAttributeModifier(Fat_Enchantment.getUUID(), "Fat_enchantment", OptionalEnchantsConfig.CONFIG.getOrDefault("fat.hearts_addition", 4.5D) * armor, EntityAttributeModifier.Operation.ADDITION);
            livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(attribute);
        }

    }


}
