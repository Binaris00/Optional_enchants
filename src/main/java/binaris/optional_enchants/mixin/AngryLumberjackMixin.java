package binaris.optional_enchants.mixin;

import binaris.optional_enchants.Optional_Enchants;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class AngryLumberjackMixin {

    @Inject(at = @At("HEAD"), method = "onDeath")
    public void lumberjackKill(DamageSource source, CallbackInfo callbackInfo) {
        if (source.getAttacker() instanceof PlayerEntity) {

            LivingEntity user = (LivingEntity) source.getAttacker();

            if (user != null) {
                if (EnchantUtils.hasEnchant(user, Optional_Enchants.ANGRY_LUMBERJACK, EquipmentSlot.MAINHAND)) {
                    int level = EnchantUtils.getLevel(user, Optional_Enchants.ANGRY_LUMBERJACK);

                    EnchantUtils.appendDuration(user, StatusEffects.HASTE, 20 * level, 1);
                }
            }
        }
    }

}
