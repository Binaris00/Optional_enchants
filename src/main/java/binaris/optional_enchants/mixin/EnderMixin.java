package binaris.optional_enchants.mixin;

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
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public class EnderMixin {

    @Unique
    private final PersistentProjectileEntity thisEntity = (PersistentProjectileEntity) (Object) this;

    @Inject(method = "onEntityHit", at = @At("TAIL"))
    public void enderHitEntity(EntityHitResult entityHitResult, CallbackInfo ci){
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
    }
    @Inject(method = "onBlockHit", at = @At("TAIL"))
    public void enderHitBlock(BlockHitResult blockHitResult, CallbackInfo ci) {
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
