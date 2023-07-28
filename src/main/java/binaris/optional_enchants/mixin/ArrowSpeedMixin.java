package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BowItem.class)
public class ArrowSpeedMixin {

    @Inject(method = "onStoppedUsing", at =
    @At(value = "INVOKE",
            target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setVelocity(Lnet/minecraft/entity/Entity;FFFFF)V",
            shift = At.Shift.AFTER

    ),
            locals = LocalCapture.CAPTURE_FAILSOFT
    )
    public void ArrowSpeed(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci, PlayerEntity playerEntity, boolean bl, ItemStack itemStack, int i, float f, boolean bl2, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity){
        if(EnchantUtils.hasEnchant(stack, OptionalEnchants_Enchantments.ARROW_SPEED)){
            persistentProjectileEntity.setVelocity(persistentProjectileEntity.getVelocity().multiply(1.0F + OptionalEnchantsConfig.CONFIG.getOrDefault("arrow_speed.velocitymult", 0.15F) * EnchantUtils.getLevel(stack, OptionalEnchants_Enchantments.ARROW_SPEED)));
        }
    }
}
