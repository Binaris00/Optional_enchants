package binaris.optional_enchants.mixin;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.enchantment.Fat;
import binaris.optional_enchants.registry.OE_Enchantments;
import binaris.optional_enchants.util.EnchantUtils;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {
    @Shadow
    public abstract Iterable<ItemStack> getArmorItems();
    @Unique
    private final LivingEntity livingEntity = (LivingEntity) (Object) this;


    @Inject(at = @At("HEAD"), method = "onDeath")
    public void onDeathInject(DamageSource source, CallbackInfo callbackInfo) {
        // AngryLumberjack Mixin
        // When the user dead, give to the attacker haste
        if (source.getAttacker() instanceof PlayerEntity) {

            LivingEntity user = (LivingEntity) source.getAttacker();

            if (user != null) {
                if (EnchantUtils.hasEnchant(user, OE_Enchantments.ANGRY_LUMBERJACK, EquipmentSlot.MAINHAND)) {
                    int level = EnchantUtils.getLevel(user, OE_Enchantments.ANGRY_LUMBERJACK);
                    EnchantUtils.appendDuration(user, StatusEffects.HASTE, Config.getInt("angry_lumberjack.effect_base_time") * level,
                            Config.getInt("angry_lumberjack.effect.amplifier"));
                }
            }
        }

        // Ninja Style
        // When the user dead, give to the attacker speed
        if (source.getAttacker() instanceof PlayerEntity) {
            LivingEntity user = (LivingEntity) source.getSource();
            if (user != null) {
                if (EnchantUtils.hasEnchant(user, OE_Enchantments.NINJA_STYLE, EquipmentSlot.MAINHAND)) {
                    int level = EnchantUtils.getLevel(user, OE_Enchantments.NINJA_STYLE);
                    EnchantUtils.appendDuration(user, StatusEffects.SPEED, Config.getInt("ninja_style.effect_base_time") * level,
                            Config.getInt("ninja_style.effect.amplifier"));
                }
            }
        }


    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void onEquipInject(CallbackInfo ci){
        // Fat
        // Checks all the armor and adds points for the generic max health
        int armor = 0;

        for(ItemStack stack : getArmorItems()) {
            if (EnchantUtils.hasEnchant(stack, OE_Enchantments.FAT)) {
                armor += 1;
            }

            if (livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MAX_HEALTH, Fat.getUUID())) {
                livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).removeModifier(Fat.getUUID());
            }
        }

        if(!livingEntity.getAttributes().hasModifierForAttribute(EntityAttributes.GENERIC_MAX_HEALTH, Fat.getUUID())){
            EntityAttributeModifier attribute = new EntityAttributeModifier(Fat.getUUID(), "Fat_enchantment", Config.getDouble("fat.hearts_addition") * armor, EntityAttributeModifier.Operation.ADDITION);
            livingEntity.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).addTemporaryModifier(attribute);
        }

        // Night Vision
        // Give night vision effect when the living entity is sneaking
        if (EnchantUtils.hasEnchant(livingEntity, OE_Enchantments.NIGHT_VISION, EquipmentSlot.HEAD) && livingEntity.isSneaking()
                || Config.getBool("night_vision.always_active")) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 2000, 100, true, false, false));
        }

        // Gravitate
        if(livingEntity.isSneaking() && EnchantUtils.hasEnchant(livingEntity, OE_Enchantments.GRAVITATE, EquipmentSlot.LEGS)){
            int level = EnchantUtils.getLevel(livingEntity, OE_Enchantments.GRAVITATE, EquipmentSlot.LEGS);
            livingEntity.getEquippedStack(EquipmentSlot.LEGS).damage(livingEntity.getRandom().nextInt(100) <= Config.getInt("gravitate.damage_probability") ? 1 : 0, livingEntity, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.LEGS));

            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, Config.getInt("gravitate.effect_base_time"), level - 1));
        }

    }
}
