package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerEntity.class)
public class GravitateMixin {
    @Inject(at = @At("HEAD"), method = "tick")
    public void onShiftGravitate(CallbackInfo ci){
        PlayerEntity player = (PlayerEntity) (Object) this;

        if(player.isSneaking() && EnchantUtils.hasEnchant(player, OptionalEnchants_Enchantments.GRAVITATE, EquipmentSlot.LEGS)){
            int level = EnchantUtils.getLevel(player, OptionalEnchants_Enchantments.GRAVITATE, EquipmentSlot.LEGS);
            player.getEquippedStack(EquipmentSlot.LEGS).damage(player.getRandom().nextInt(100) <= Config.getInt("gravitate.damage_probability") ? 1 : 0, player, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.LEGS));

            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, Config.getInt("gravitate.effect_base_time"), level - 1));
        }

    }
}
