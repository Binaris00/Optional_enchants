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
public class NinjaStyleMixin {
    @Inject(method = "onDeath", at = @At("HEAD"))
    public void Ninja_kill(DamageSource source, CallbackInfo callbackInfo) {
        if (!(source.getAttacker() instanceof PlayerEntity)) {

            LivingEntity user = (LivingEntity) source.getSource();

            if (user != null) {
                if (EnchantUtils.hasEnchant(user, Optional_Enchants.NINJA_STYLE, EquipmentSlot.MAINHAND)) {

                    int level = EnchantUtils.getLevel(user, Optional_Enchants.NINJA_STYLE);
                    EnchantUtils.appendDuration(user, StatusEffects.SPEED, 20 * level, 0);
                }
            }
        }
    }

}