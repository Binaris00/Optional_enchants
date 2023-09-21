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
public class NinjaStyleMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    public void Ninja_kill(DamageSource source, CallbackInfo callbackInfo) {
        if (source.getAttacker() instanceof PlayerEntity) {
            LivingEntity user = (LivingEntity) source.getSource();
            if (user != null) {
                if (EnchantUtils.hasEnchant(user, OptionalEnchants_Enchantments.NINJA_STYLE, EquipmentSlot.MAINHAND)) {
                    int level = EnchantUtils.getLevel(user, OptionalEnchants_Enchantments.NINJA_STYLE);
                    EnchantUtils.appendDuration(user, StatusEffects.SPEED, Config.getInt("ninja_style.effect_base_time") * level,
                            Config.getInt("ninja_style.effect.amplifier"));
                }
            }
        }
    }

}