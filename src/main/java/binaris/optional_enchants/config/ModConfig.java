package binaris.optional_enchants.config;

import binaris.optional_enchants.Optional_Enchants;

import java.io.IOException;

public class ModConfig {

    public static Config CONFIG;
    public static void registerConfig(){
        CONFIG = new Config(Optional_Enchants.MOD_ID, Optional_Enchants.MOD_ID, false);
        setCONFIG();

        try {
            CONFIG.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void setCONFIG(){
        CONFIG.set("Comment", "Angry lumberjack enchantment config");
        CONFIG.set("angry_lumberjack.enable", true);
        CONFIG.set("angry_lumberjack.effect_base_time", 20);
        CONFIG.set("angry_lumberjack.effect.amplifier", 1);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Arrow speed enchantment config");
        CONFIG.set("arrow_speed.enable", true);
        CONFIG.set("arrow_speed.velocitymult", 0.15F);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "AutoSmelt enchantment config");
        CONFIG.set("auto_smelt.enable", true);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Barbaric enchantment config");
        CONFIG.set("barbaric.enable", true);
        CONFIG.set("barbaric.damage", 0.04D);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Betrayer enchantment config");
        CONFIG.set("betrayer.enable", true);
        CONFIG.set("betrayer.base_damage", 3.0F);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Breaking Curse config");
        CONFIG.set("breaking_curse.enable", true);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Cleaving enchantment config");
        CONFIG.set("cleaving.enable", true);
        CONFIG.set("cleaving.probability", 20);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "End harm enchantment config");
        CONFIG.set("end_harm.enable", true);
        CONFIG.set("end_harm.attack_damage", 3.0F);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Ender enchantment config");
        CONFIG.set("ender.enable", true);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Explosive enchantment config");
        CONFIG.set("explosive.enable", true);
        CONFIG.set("explosive.base_damage", 2.0F);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Exposing enchantment config");
        CONFIG.set("exposing.enable", true);
        CONFIG.set("exposing.effect_base_time", 40);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Fat enchantment config");
        CONFIG.set("fat.enable", true);
        CONFIG.set("fat.hearts_addition", 4.5D);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Fragile strike enchantment config");
        CONFIG.set("fragile_strike.enable", true);
        CONFIG.set("fragile_strike.effect_base_time", 80);
        CONFIG.set("fragile_strike.effect_amplifier", 1);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Gravitate enchantment config");
        CONFIG.set("gravitate.enable", true);
        CONFIG.set("gravitate.damage_probability", 30);
        CONFIG.set("gravitate.effect_base_time", 80);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Gravity curse enchantment config");
        CONFIG.set("gravity_curse.enable", true);
        CONFIG.set("gravity_curse.probability", 20);
        CONFIG.set("gravity_curse.effect_base_time", 200);
        CONFIG.set("gravity_curse.effect_amplifier", 2);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Hungering strike enchantment config");
        CONFIG.set("hungering_strike.enable", true);
        CONFIG.set("hungering_strike.effect_base_time", 120);
        CONFIG.set("hungering_strike.effect_amplifier", 1);

        CONFIG.set("Comment", "Hunting enchantment config");
        CONFIG.set("hunting.enable", true);
        CONFIG.set("hunting.damage", 5.0F);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Ice bow enchantment config");
        CONFIG.set("ice_bow.enable", true);
        CONFIG.set("ice_bow.effect_base_time", 60);
        CONFIG.set("ice_bow.effect_amplifier", 1);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Log cutter enchantment config");
        CONFIG.set("log_cutter.enable", true);
        
        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Launching enchantment config");
        CONFIG.set("launching.enable", true);
        CONFIG.set("launching.velocity", 1.0D);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Nether Bane enchantment config");
        CONFIG.set("nether_bane.enable", true);
        CONFIG.set("nether_base.base_damage", 3.0F);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Night vision enchantment config");
        CONFIG.set("night_vision.enable", true);
        CONFIG.set("night_vision.always_active", false);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Ninja style enchantment config");
        CONFIG.set("ninja_style.enable", true);
        CONFIG.set("ninja_style.effect_base_time", 20);
        CONFIG.set("ninja_style.effect.amplifier", 0);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Poison aspect enchantment config");
        CONFIG.set("poison_aspect.enable", true);
        CONFIG.set("poison_aspect.effect_base_time", 200);
        CONFIG.set("poison_aspect.effect_amplifier", 1);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Skyward Shot enchantment config");
        CONFIG.set("skyward_shot.enable", true);
        CONFIG.set("skyward_shot.effect_probability", 10);
        CONFIG.set("skyward_shot.effect_time_base", 100);
        CONFIG.set("skyward_shot.effect_amplifier", 1);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Slowness aspect enchantment config");
        CONFIG.set("slowness_aspect.enable", true);
        CONFIG.set("slowness_aspect.effect_base_time", 120);
        CONFIG.set("slowness_aspect.effect_amplifier", 1);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Soulbound enchantment config");
        CONFIG.set("soulbound.enable", true);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Telekinesis enchantment config");
        CONFIG.set("telekinesis.enable", true);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Terraforming enchantment config");
        CONFIG.set("terraforming.enable", true);
        CONFIG.set("terraforming.velocity", 58);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Thunderbolt enchantment config");
        CONFIG.set("thunderbolt.enable", true);
        CONFIG.set("thunderbolt.probability", 30);

        CONFIG.set("EmptyLine", "");

        CONFIG.set("Comment", "Wither aspect enchantment config");
        CONFIG.set("wither_aspect.enable", true);
        CONFIG.set("wither_aspect.effect_base_time", 120);
        CONFIG.set("wither_aspect.effect_amplifier", 1);

    }
}
