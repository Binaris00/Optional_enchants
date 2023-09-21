package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class HelmetEnchantsMixin {
    @Unique
    private final LivingEntity thisEntity = (LivingEntity) (Object) this;

    @Inject(method = "tick", at = @At("HEAD"))
    public void effectEnchants(CallbackInfo ci) {
        if (EnchantUtils.hasEnchant(thisEntity, OptionalEnchants_Enchantments.NIGHT_VISION, EquipmentSlot.HEAD) && thisEntity.isSneaking()
                || Config.getBool("night_vision.always_active")) {
            thisEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2000, 100, true, false, false));
        }


    }
}