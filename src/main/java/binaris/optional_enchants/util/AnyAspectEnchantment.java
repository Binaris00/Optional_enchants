package binaris.optional_enchants.util;

import binaris.optional_enchants.Optional_Enchants;
import binaris.optional_enchants.config.Config;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.FireAspectEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class AnyAspectEnchantment extends Enchantment{

    StatusEffect effect;
    int seconds;
    int amplifier;
    String id;

    public AnyAspectEnchantment(StatusEffect effect, int seconds, int amplifier, String id) {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        this.effect = effect;
        this.seconds = seconds;
        this.amplifier = amplifier;
        this.id = id;

        if(Config.getBool(id + ".enable")){
            Registry.register(Registries.ENCHANTMENT, new Identifier(Optional_Enchants.MOD_ID, id), this);
        }
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity){
            livingEntity.addStatusEffect(new StatusEffectInstance(effect, seconds * level, amplifier));
        }
    }

    @Override
    public int getMinPower(int level) {return 10 + 20 * (level - 1);}

    @Override
    public int getMaxPower(int level) {return super.getMinPower(level) + 50;}

    @Override
    public int getMaxLevel() {return 2;}

    @Override
    protected boolean canAccept(Enchantment other) {
        return !(other instanceof FireAspectEnchantment || other instanceof AnyAspectEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {return stack.getItem() instanceof AxeItem || super.isAcceptableItem(stack);}

    @Override
    public Enchantment.Rarity getRarity() {return Rarity.RARE;}
}


