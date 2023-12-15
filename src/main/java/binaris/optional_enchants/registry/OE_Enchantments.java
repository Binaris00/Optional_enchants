package binaris.optional_enchants.registry;

import binaris.optional_enchants.config.Config;
import binaris.optional_enchants.enchantment.*;
import binaris.optional_enchants.util.AnyAspectEnchantment;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;

public class OE_Enchantments {
    public static Enchantment ARROW_SPEED = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.CROSSBOW,
            new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND},
            3,
            false,
            false,
            null,
            null,
            true,
            true,
            "arrow_speed");

    public static Enchantment EXPLOSIVE = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.BOW,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            2, false,
            false,
            new Enchantment[]{Enchantments.POWER, Enchantments.INFINITY},
            null,
            true,
            true,
            "explosive");

    public static Enchantment ENDER = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.BOW,
            new EquipmentSlot[]{EquipmentSlot.OFFHAND, EquipmentSlot.MAINHAND},
            1,
            false,
            false,
            new Enchantment[]{Enchantments.POWER, Enchantments.INFINITY, OE_Enchantments.EXPLOSIVE},
            null,
            true,
            true,
            "ender");

    public static Enchantment TERRAFORMING = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE,
            EnchantmentTarget.DIGGER,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1,
            false,
            true,
            new Enchantment[]{Enchantments.FORTUNE, Enchantments.SILK_TOUCH, OE_Enchantments.AUTO_SMELT, OE_Enchantments.TELEKINESIS},
            null,
            true,
            false,
            "terraforming");

    public static Enchantment LAUNCHING = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.TRIDENT,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            3,
            false,
            false,
            new Enchantment[]{Enchantments.RIPTIDE},
            null,
            true,
            true,
            "launching");

    public static Enchantment NIGHT_VISION = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.ARMOR_HEAD,
            new EquipmentSlot[]{EquipmentSlot.HEAD},
            1,
            false,
            false,
            null,
            null, true,
            true,
            "night_vision");

    public static Enchantment SOULBOUND = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE,
            EnchantmentTarget.BREAKABLE,
            new EquipmentSlot[]{},
            1,
            false,
            true,
            null,
            null,
            true,
            false,
            "soulbound");

    public static Enchantment EXPOSING = new Exposing();

    public static Enchantment THUNDERBOLT = new Thunderbolt();

    public static Enchantment BARBARIC = new Barbaric();

    public static Enchantment CLEAVING = new Cleaving();

    //////////////////////////////////////////////////////////////////
    public static Enchantment FAT = new Fat(Enchantment.Rarity.RARE,
            EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.CHEST, EquipmentSlot.FEET},
            1,
            false,
            false, new Enchantment[]{Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION},
            null,
            true,
            true,
            "fat");

    public static Enchantment GRAVITATE = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE,
            EnchantmentTarget.ARMOR_LEGS,
            new EquipmentSlot[]{EquipmentSlot.LEGS},
            3,
            false,
            true,
            new Enchantment[]{Enchantments.SWIFT_SNEAK},
            null,
            false,
            false,
            "gravitate");

    public static Enchantment NINJA_STYLE = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            4,
            false,
            false,
            null,
            null,
            true,
            true,
            "ninja_style");

    public static Enchantment ANGRY_LUMBERJACK = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.DIGGER,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            4,
            false,
            false,
            null,
            SimpleEnchantBuilder.MoreTargets.AXE,
            true,
            true,
            "angry_lumberjack");

    public static Enchantment AUTO_SMELT = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.DIGGER,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1,
            false,
            false, new Enchantment[]{Enchantments.SILK_TOUCH, OE_Enchantments.TELEKINESIS},
            null,
            true,
            true,
            "auto_smelt");

    public static Enchantment TELEKINESIS = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.DIGGER,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1,
            false,
            false,
            new Enchantment[]{OE_Enchantments.AUTO_SMELT},
            null,
            true,
            true,
            "telekinesis");

    public static Enchantment LOG_CUTTER = new SimpleEnchantBuilder(Enchantment.Rarity.RARE,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND},
            1,
            false,
            false,
            null,
            SimpleEnchantBuilder.MoreTargets.AXE,
            true,
            true,
            "log_cutter");
    public static Enchantment ICE_BOW = new Ice_Bow();
    public static Enchantment END_HARM = new EndHarm();
    public static Enchantment SKYWARDSHOT = new SkywardShot();
    public static Enchantment HUNTING = new Hunting();
    public static Enchantment GRAVITY_CURSE = new Gravity_Curse();
    public static Enchantment BREAKING_CURSE = new Breaking_Curse();
    public static Enchantment NETHER_BANE = new NetherBane();
    public static Enchantment BETRAYER = new Betrayer();



    public static Enchantment WITHER_ASPECT = new AnyAspectEnchantment(StatusEffects.WITHER, Config.getInt("wither_aspect.effect_base_time"), Config.getInt("wither_aspect.effect_amplifier"), "wither_aspect");
    public static Enchantment POISON_ASPECT = new AnyAspectEnchantment(StatusEffects.POISON, Config.getInt("poison_aspect.effect_base_time"), Config.getInt("poison_aspect.effect_amplifier"), "poison_aspect");
    public static Enchantment SLOWNESS_ASPECT = new AnyAspectEnchantment(StatusEffects.SLOWNESS, Config.getInt("slowness_aspect.effect_base_time"), Config.getInt("slowness_aspect.effect_amplifier"), "slowness_aspect");
    public static Enchantment FRAGILE_STRIKE = new AnyAspectEnchantment(StatusEffects.WEAKNESS, Config.getInt("fragile_strike.effect_base_time"), Config.getInt("fragile_strike.effect_amplifier"), "fragile_strike");
    public static Enchantment HUNGERING_STRIKE = new AnyAspectEnchantment(StatusEffects.HUNGER, Config.getInt("hungering_strike.effect_base_time"), Config.getInt("hungering_strike.effect_amplifier"), "hungering_strike");
    //////////////////////////////////////////////////////////////////

    public static void registerAllEnchants(){
    }
}
