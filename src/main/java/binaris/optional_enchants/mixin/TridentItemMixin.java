package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TridentItem;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TridentItem.class)
public abstract class TridentItemMixin {

    @Unique
    Vec3d velocity;
    @Unique
    TridentItem tridentItem = (TridentItem) (Object) this;

    @Inject(method = "onStoppedUsing", at = @At("HEAD"))
    public void StoppedUsingInject(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo info) {
        int i = tridentItem.getMaxUseTime(stack) - remainingUseTicks;
        velocity = user.getRotationVector().multiply(EnchantUtils.getLevel(stack, OptionalEnchants_Enchantments.LAUNCHING)).multiply(Config.getDouble("launching.velocity"));

        if (EnchantUtils.getLevel(stack, OptionalEnchants_Enchantments.LAUNCHING) > 0 && i >= 10 && EnchantUtils.getLevel(stack, Enchantments.RIPTIDE) <= 0) {
            user.setVelocity(user.getVelocity().add(velocity));
            user.fallDistance = 0;
        }
    }
}
