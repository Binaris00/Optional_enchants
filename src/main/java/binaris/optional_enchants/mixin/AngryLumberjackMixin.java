package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
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
                if (EnchantUtils.hasEnchant(user, OptionalEnchants_Enchantments.ANGRY_LUMBERJACK, EquipmentSlot.MAINHAND)) {
                    int level = EnchantUtils.getLevel(user, OptionalEnchants_Enchantments.ANGRY_LUMBERJACK);
                    EnchantUtils.appendDuration(user, StatusEffects.HASTE, Config.getInt("angry_lumberjack.effect_base_time") * level,
                            Config.getInt("angry_lumberjack.effect.amplifier"));
                }
            }
        }
    }

}