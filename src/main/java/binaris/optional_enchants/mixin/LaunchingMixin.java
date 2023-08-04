package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.OptionalEnchantsConfig;
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
public class LaunchingMixin {

    @Unique
    Vec3d velocity;

    @Inject(method = "onStoppedUsing", at = @At("HEAD"))
    public void addLaunchingVelocity(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo info) {
        TridentItem thisItem = (TridentItem) (Object) this;
        int i = thisItem.getMaxUseTime(stack) - remainingUseTicks;
        velocity = user.getRotationVector().multiply(EnchantUtils.getLevel(stack, OptionalEnchants_Enchantments.LAUNCHING)).multiply(OptionalEnchantsConfig.CONFIG.getOrDefault("launching.velocity", 1.0D));

        if (EnchantUtils.getLevel(stack, OptionalEnchants_Enchantments.LAUNCHING) > 0 && i >= 10 && EnchantUtils.getLevel(stack, Enchantments.RIPTIDE) <= 0) {
            user.setVelocity(user.getVelocity().add(velocity));
            user.fallDistance = 0;
        }
    }
}
