package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public class ExplosiveMixin {

    @Unique
    private final PersistentProjectileEntity thisEntity = (PersistentProjectileEntity) (Object) this;
    @Inject(method = "onEntityHit", at = @At("TAIL"))
    public void explosive_arrow(EntityHitResult entityHitResult, CallbackInfo ci){
        if(thisEntity.getOwner() instanceof LivingEntity livingEntity && thisEntity instanceof ArrowEntity){
            if(EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.EXPLOSIVE) >= 1){

                Entity target = entityHitResult.getEntity();
                int level = EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.EXPLOSIVE);
                target.getWorld().createExplosion(target, target.getX(), (target.getY() + 2.0F * thisEntity.getY()) / 3.0F, target.getZ(), level * Config.getFloat("explosive.base_damage"), World.ExplosionSourceType.NONE);
            }
        }
    }
}
