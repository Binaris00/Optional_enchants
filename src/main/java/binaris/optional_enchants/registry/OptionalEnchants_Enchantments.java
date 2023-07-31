package binaris.optional_enchants.registry;

import binaris.optional_enchants.Optional_Enchants;
import binaris.optional_enchants.config.OptionalEnchantsConfig;
import binaris.optional_enchants.enchantment.*;
import binaris.optional_enchants.util.AnyAspectEnchantment;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;

public class OptionalEnchants_Enchantments {
    static Map<SimpleEnchantBuilder, Boolean> ENCHANTS = new HashMap<>();
    static Map<AnyAspectEnchantment, Boolean> ENCHANTS_ASPECT = new HashMap<>();

    //////////////////////////////////////////////////////////////////
    // Herb's Extra Enchants
    //////////////////////////////////////////////////////////////////

    public static SimpleEnchantBuilder ARROW_SPEED = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND},
            3, false, false, null, null, true, true, "arrow_speed");

    public static SimpleEnchantBuilder EXPLOSIVE = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            2, false, false, new Enchantment[]{Enchantments.POWER, Enchantments.INFINITY}, null, true, true, "explosive");

    public static SimpleEnchantBuilder ENDER = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.BOW, new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND},
            1, false, false, new Enchantment[]{Enchantments.POWER, Enchantments.INFINITY, OptionalEnchants_Enchantments.EXPLOSIVE}, null, true, true, "ender");

    public static SimpleEnchantBuilder TERRAFORMING = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1, false, true, new Enchantment[]{Enchantments.FORTUNE, Enchantments.SILK_TOUCH, OptionalEnchants_Enchantments.AUTO_SMELT, OptionalEnchants_Enchantments.TELEKINESIS}, null, true, false, "terraforming");

    public static SimpleEnchantBuilder LAUNCHING = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.TRIDENT, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            3, false, false, new Enchantment[]{Enchantments.RIPTIDE}, null, true, true, "launching");

    public static SimpleEnchantBuilder NIGHT_VISION = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD},
            1, false, false, null, null, true, true, "night_vision");

    public static SimpleEnchantBuilder BERSERK = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_CHEST, new EquipmentSlot[]{EquipmentSlot.CHEST},
            3, false, false, new Enchantment[]{Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION, OptionalEnchants_Enchantments.FAT}, null, true, true, "berserk");

    public static SimpleEnchantBuilder SOULBOUND = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{},
            1, false, true, null, null, true, false, "soulbound");

    public static SimpleEnchantBuilder EXPOSING = new Exposing_Enchantment();

    public static SimpleEnchantBuilder THUNDERBOLT = new Thunderbolt_Enchantment();

    public static SimpleEnchantBuilder BARBARIC = new Barbaric_Enchantment();

    public static SimpleEnchantBuilder CLEAVING = new Cleaving_Enchantment();

    //////////////////////////////////////////////////////////////////
    public static SimpleEnchantBuilder FAT = new Fat_Enchantment(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.CHEST, EquipmentSlot.FEET},
            1, false, false, new Enchantment[]{Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION},
            null, true, true, "fat");

    public static SimpleEnchantBuilder GRAVITATE = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS},
            3, false, true, new Enchantment[]{Enchantments.SWIFT_SNEAK},
            null, false, false, "gravitate");

    public static SimpleEnchantBuilder NINJA_STYLE = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            4, false, false, null,
            null, true, true, "ninja_style");

    public static SimpleEnchantBuilder ANGRY_LUMBERJACK = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            4, false, false, null,
            null, true, true, "angry_lumberjack");

    public static SimpleEnchantBuilder AUTO_SMELT = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1, false, false, new Enchantment[]{Enchantments.SILK_TOUCH, OptionalEnchants_Enchantments.TELEKINESIS},
            null, true, true, "auto_smelt");

    public static SimpleEnchantBuilder TELEKINESIS = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1, false, false, new Enchantment[]{OptionalEnchants_Enchantments.AUTO_SMELT},
            null, true, true, "telekinesis");


    public static SimpleEnchantBuilder ICE_BOW = new Ice_Bow_Enchantment();
    public static SimpleEnchantBuilder END_HARM = new EndHarm_Enchantment();
    public static SimpleEnchantBuilder SKYWARDSHOT = new SkywardShot_Enchantment();
    public static SimpleEnchantBuilder HUNTING = new Hunting_Enchantment();
    public static SimpleEnchantBuilder GRAVITY_CURSE = new Gravity_Curse();
    public static SimpleEnchantBuilder BREAKING_CURSE = new Breaking_Curse();
    public static SimpleEnchantBuilder NETHER_BANE = new NetherBane_Enchantment();
    public static SimpleEnchantBuilder BETRAYER = new Betrayer_Enchantment();



    public static AnyAspectEnchantment WITHER_ASPECT = new AnyAspectEnchantment(StatusEffects.WITHER, OptionalEnchantsConfig.CONFIG.getOrDefault("wither_aspect.effect_base_time", 120), OptionalEnchantsConfig.CONFIG.getOrDefault("wither_aspect.effect_amplifier", 1), "wither_aspect");
    public static AnyAspectEnchantment POISON_ASPECT = new AnyAspectEnchantment(StatusEffects.POISON, OptionalEnchantsConfig.CONFIG.getOrDefault("poison_aspect.effect_base_time", 200), OptionalEnchantsConfig.CONFIG.getOrDefault("poison_aspect.effect_amplifier", 1), "poison_aspect");
    public static AnyAspectEnchantment SLOWNESS_ASPECT = new AnyAspectEnchantment(StatusEffects.SLOWNESS, OptionalEnchantsConfig.CONFIG.getOrDefault("slowness_aspect.effect_base_time", 120), OptionalEnchantsConfig.CONFIG.getOrDefault("slowness_aspect.effect_amplifier", 1), "slowness_aspect");
    public static AnyAspectEnchantment FRAGILE_STRIKE = new AnyAspectEnchantment(StatusEffects.WEAKNESS, OptionalEnchantsConfig.CONFIG.getOrDefault("fragile_strike.effect_base_time", 80), OptionalEnchantsConfig.CONFIG.getOrDefault("fragile_strike.effect_amplifier", 1), "fragile_strike");
    public static AnyAspectEnchantment HUNGERING_STRIKE = new AnyAspectEnchantment(StatusEffects.HUNGER, OptionalEnchantsConfig.CONFIG.getOrDefault("hungering_strike.effect_base_time", 80), OptionalEnchantsConfig.CONFIG.getOrDefault("hungering_strike.effect_amplifier", 0), "hungering_strike");
    //////////////////////////////////////////////////////////////////



    public static void registerEnchant(String name, Enchantment enchantment){
        Registry.register(Registries.ENCHANTMENT, new Identifier(Optional_Enchants.MOD_ID, name), enchantment);
    }

    public static void registerAllEnchants(){

        ENCHANTS.put(ICE_BOW, OptionalEnchantsConfig.CONFIG.getOrDefault("ice_bow.enable", true));
        ENCHANTS.put(FAT, OptionalEnchantsConfig.CONFIG.getOrDefault("fat.enable", true));
        ENCHANTS.put(GRAVITATE, OptionalEnchantsConfig.CONFIG.getOrDefault("gravitate.enable", true));
        ENCHANTS.put(NINJA_STYLE, OptionalEnchantsConfig.CONFIG.getOrDefault("ninja_style.enable", true));
        ENCHANTS.put(ANGRY_LUMBERJACK, OptionalEnchantsConfig.CONFIG.getOrDefault("angry_lumberjack.enable", true));
        ENCHANTS.put(AUTO_SMELT, OptionalEnchantsConfig.CONFIG.getOrDefault("auto_smelt.enable", true));
        ENCHANTS.put(TELEKINESIS, OptionalEnchantsConfig.CONFIG.getOrDefault("telekinesis.enable", true));
        ENCHANTS.put(END_HARM, OptionalEnchantsConfig.CONFIG.getOrDefault("end_harm.enable", true));
        ENCHANTS.put(SKYWARDSHOT, OptionalEnchantsConfig.CONFIG.getOrDefault("skyward_shot.enable", true));
        ENCHANTS.put(HUNTING, OptionalEnchantsConfig.CONFIG.getOrDefault("hunting.enable", true));
        ENCHANTS.put(GRAVITY_CURSE, OptionalEnchantsConfig.CONFIG.getOrDefault("gravity_curse.enable", true));
        ENCHANTS.put(BREAKING_CURSE, OptionalEnchantsConfig.CONFIG.getOrDefault("breaking_curse.enable", true));
        ENCHANTS.put(NETHER_BANE, OptionalEnchantsConfig.CONFIG.getOrDefault("nether_bane.enable", true));
        ENCHANTS.put(BETRAYER, OptionalEnchantsConfig.CONFIG.getOrDefault("betrayer.enable", true));

        ENCHANTS_ASPECT.put(WITHER_ASPECT, OptionalEnchantsConfig.CONFIG.getOrDefault("wither_aspect.enable", true));
        ENCHANTS_ASPECT.put(POISON_ASPECT, OptionalEnchantsConfig.CONFIG.getOrDefault("poison_aspect.enable", true));
        ENCHANTS_ASPECT.put(SLOWNESS_ASPECT, OptionalEnchantsConfig.CONFIG.getOrDefault("slowness_aspect.enable", true));
        ENCHANTS_ASPECT.put(FRAGILE_STRIKE, OptionalEnchantsConfig.CONFIG.getOrDefault("fragile_strike.enable", true));
        ENCHANTS_ASPECT.put(HUNGERING_STRIKE, OptionalEnchantsConfig.CONFIG.getOrDefault("hungering_strike.enable", true));





        ENCHANTS.put(ARROW_SPEED, OptionalEnchantsConfig.CONFIG.getOrDefault("arrow_speed.enable", true));
        ENCHANTS.put(EXPLOSIVE, OptionalEnchantsConfig.CONFIG.getOrDefault("explosive.enable", true));
        ENCHANTS.put(ENDER, OptionalEnchantsConfig.CONFIG.getOrDefault("ender.enable", true));
        ENCHANTS.put(EXPOSING, OptionalEnchantsConfig.CONFIG.getOrDefault("exposing.enable", true));
        ENCHANTS.put(THUNDERBOLT, OptionalEnchantsConfig.CONFIG.getOrDefault("thunderbolt.enable", true));
        ENCHANTS.put(BARBARIC, OptionalEnchantsConfig.CONFIG.getOrDefault("barbaric.enable", true));
        ENCHANTS.put(CLEAVING, OptionalEnchantsConfig.CONFIG.getOrDefault("cleaving.enable", true));
        ENCHANTS.put(TERRAFORMING, OptionalEnchantsConfig.CONFIG.getOrDefault("terraforming.enable", true));
        ENCHANTS.put(LAUNCHING, OptionalEnchantsConfig.CONFIG.getOrDefault("launching.enable", true));
        ENCHANTS.put(BERSERK, OptionalEnchantsConfig.CONFIG.getOrDefault("berserk.enable", false));
        ENCHANTS.put(SOULBOUND, OptionalEnchantsConfig.CONFIG.getOrDefault("soulbound.enable", true));

        for (Map.Entry<SimpleEnchantBuilder, Boolean> set : ENCHANTS.entrySet()) {
            if(set.getValue()){
                registerEnchant(set.getKey().getId(), set.getKey());
            }
        }

        for (Map.Entry<AnyAspectEnchantment, Boolean> set : ENCHANTS_ASPECT.entrySet()) {
            if(set.getValue()){
                registerEnchant(set.getKey().getId(), set.getKey());
            }
        }

        Optional_Enchants.LOGGER.info("LOADING ENCHANTS");
    }
}
