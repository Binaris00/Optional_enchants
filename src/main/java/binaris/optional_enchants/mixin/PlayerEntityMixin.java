package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.registry.OE_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Unique
    private final PlayerEntity thisPlayer = (PlayerEntity) (Object) this;





    @Inject(method = "getBlockBreakingSpeed", at = @At("RETURN"), cancellable = true)
    private void addTerraformingSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
        if(thisPlayer.getActiveHand() != null && EnchantUtils.hasEnchant(thisPlayer, OE_Enchantments.TERRAFORMING, EquipmentSlot.MAINHAND) && cir.getReturnValue() > 1.0)
            cir.setReturnValue(cir.getReturnValue() + Config.getInt("terraforming.velocity"));
    }
}

