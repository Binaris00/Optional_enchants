package binaris.optional_enchants.mixin;

import binaris.optional_enchants.registry.OptionalEnchants_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MiningToolItem.class)
public class BreakingCurseMixin {
    @Inject(at = @At("HEAD"), method = "postMine")
    void BreakingPosMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner, CallbackInfoReturnable<Boolean> cir){
        if(EnchantUtils.hasEnchant(stack, OptionalEnchants_Enchantments.BREAKING_CURSE)){

            int level = EnchantUtils.getLevel(stack, OptionalEnchants_Enchantments.BREAKING_CURSE);
            stack.damage(2 * level, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }
    }
}
