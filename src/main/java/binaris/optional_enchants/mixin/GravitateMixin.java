package binaris.optional_enchants.mixin;

import binaris.optional_enchants.Optional_Enchants;
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

        if(player.isSneaking() && EnchantUtils.hasEnchant(player, Optional_Enchants.GRAVITATE, EquipmentSlot.LEGS)){
            int level = EnchantUtils.getLevel(player, Optional_Enchants.GRAVITATE, EquipmentSlot.LEGS);
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 80, level - 1));
        }

    }
}
