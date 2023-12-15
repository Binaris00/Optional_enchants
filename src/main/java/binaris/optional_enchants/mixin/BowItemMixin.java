package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OE_Enchantments;
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
public abstract class BowItemMixin {
    @Inject(method = "onStoppedUsing", at =
    @At(value = "INVOKE",
            target = "Lnet/minecraft/entity/projectile/PersistentProjectileEntity;setVelocity(Lnet/minecraft/entity/Entity;FFFFF)V",
            shift = At.Shift.AFTER

    ),
            locals = LocalCapture.CAPTURE_FAILSOFT
    )
    public void StoppedUsingInject(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci, PlayerEntity playerEntity, boolean bl, ItemStack itemStack, int i, float f, boolean bl2, ArrowItem arrowItem, PersistentProjectileEntity persistentProjectileEntity){
        // Arrow Speed
        // Set more velocity to the persistentProjectileEntity
        if(EnchantUtils.hasEnchant(stack, OE_Enchantments.ARROW_SPEED)){
            persistentProjectileEntity.setVelocity(persistentProjectileEntity.getVelocity().multiply(1.0F + Config.getFloat("arrow_speed.velocitymult") * EnchantUtils.getLevel(stack, OE_Enchantments.ARROW_SPEED)));
        }
    }
}
