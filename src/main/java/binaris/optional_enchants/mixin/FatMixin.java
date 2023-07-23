package binaris.optional_enchants.mixin;


import binaris.optional_enchants.Optional_Enchants;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class FatMixin {


    @Shadow public abstract Iterable<ItemStack> getArmorItems();

    @Inject(at = @At("HEAD"), method = "tick")
    public void onEquipFat(CallbackInfo ci){
        LivingEntity livingEntity = (LivingEntity) (Object) this;
        int armor = 0;

        for(ItemStack stack : getArmorItems()){
            if(EnchantUtils.hasEnchant(stack, Optional_Enchants.FAT)){
                armor += 1;
            }
        }
        if(armor != 0){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200, armor == 4 ? 4 : armor - 1));
        }

    }


}
