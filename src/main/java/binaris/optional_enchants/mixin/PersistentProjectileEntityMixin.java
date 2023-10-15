package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin {
    @Unique
    private final PersistentProjectileEntity thisEntity = (PersistentProjectileEntity) (Object) this;

    @Inject(method = "onEntityHit", at = @At("TAIL"))
    public void onEntityHitInject(EntityHitResult entityHitResult, CallbackInfo ci){
        // Ender
        // Confirm if this is an ArrowEntity and teleport the entity with any vehicle to the entity target
        // Also play an enderman teleport sound
        if(thisEntity.getOwner() instanceof LivingEntity livingEntity && thisEntity instanceof ArrowEntity){
            if(EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.ENDER) >= 1){

                Entity target = entityHitResult.getEntity();
                LivingEntity owner = (LivingEntity) thisEntity.getOwner();

                owner.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                if(owner.hasVehicle()){
                    owner.getRootVehicle().teleport(target.getX(), target.getY() + 1, target.getZ());
                }
                else {
                    owner.teleport(target.getX(), target.getY() + 1, target.getZ());
                }
            }
        }

        // Explosive
        // Very original, create an explosion in the target location
        if(thisEntity.getOwner() instanceof LivingEntity livingEntity && thisEntity instanceof ArrowEntity){
            if(EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.EXPLOSIVE) >= 1){

                Entity target = entityHitResult.getEntity();
                int level = EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.EXPLOSIVE);
                target.getWorld().createExplosion(target, target.getX(), (target.getY() + 2.0F * thisEntity.getY()) / 3.0F, target.getZ(), level * Config.getFloat("explosive.base_damage"), World.ExplosionSourceType.NONE);
            }
        }

    }
    @Inject(method = "onBlockHit", at = @At("TAIL"))
    public void onBlockHitInject(BlockHitResult blockHitResult, CallbackInfo ci) {
        // Ender
        // Confirm if this is an ArrowEntity and teleport the entity with any vehicle to the block target
        // Also play an enderman teleport sound
        if (thisEntity.getOwner() instanceof LivingEntity livingEntity && thisEntity instanceof ArrowEntity) {
            if (EnchantUtils.getLevel(livingEntity, OptionalEnchants_Enchantments.ENDER) >= 1) {
                LivingEntity owner = (LivingEntity) thisEntity.getOwner();
                BlockPos blockPos = blockHitResult.getBlockPos();

                owner.playSound(SoundEvents.ENTITY_ENDERMAN_TELEPORT, 1.0F, 1.0F);
                if (owner.hasVehicle()) {
                    owner.getRootVehicle().teleport(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
                } else {
                    owner.teleport(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
                }
            }
        }
    }
}
