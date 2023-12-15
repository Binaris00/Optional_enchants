package binaris.optional_enchants.config;

import binaris.optional_enchants.Optional_Enchants;

public class OE_Config {

    public static Config CONFIG = new Config(Optional_Enchants.MOD_ID, Optional_Enchants.MOD_ID, false);

    public static void setCONFIG(){
        CONFIG.addComment("Angry lumberjack enchantment config");
        CONFIG.set("angry_lumberjack.enable", true);
        CONFIG.set("angry_lumberjack.effect_base_time", 20);
        CONFIG.set("angry_lumberjack.effect.amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Arrow speed enchantment config");
        CONFIG.set("arrow_speed.enable", true);
        CONFIG.set("arrow_speed.velocitymult", 0.15F);

        CONFIG.emptyLine();

        CONFIG.addComment("AutoSmelt enchantment config");
        CONFIG.set("auto_smelt.enable", true);

        CONFIG.emptyLine();

        CONFIG.addComment("Barbaric enchantment config");
        CONFIG.set("barbaric.enable", true);
        CONFIG.set("barbaric.damage", 0.04D);

        CONFIG.emptyLine();

        CONFIG.addComment("Betrayer enchantment config");
        CONFIG.set("betrayer.enable", true);
        CONFIG.set("betrayer.base_damage", 3.0F);

        CONFIG.emptyLine();

        CONFIG.addComment("Breaking Curse config");
        CONFIG.set("breaking_curse.enable", true);

        CONFIG.emptyLine();

        CONFIG.addComment("Cleaving enchantment config");
        CONFIG.set("cleaving.enable", true);
        CONFIG.set("cleaving.probability", 20);

        CONFIG.emptyLine();

        CONFIG.addComment("End harm enchantment config");
        CONFIG.set("end_harm.enable", true);
        CONFIG.set("end_harm.attack_damage", 3.0F);

        CONFIG.emptyLine();

        CONFIG.addComment("Ender enchantment config");
        CONFIG.set("ender.enable", true);

        CONFIG.emptyLine();

        CONFIG.addComment("Explosive enchantment config");
        CONFIG.set("explosive.enable", true);
        CONFIG.set("explosive.base_damage", 2.0F);

        CONFIG.emptyLine();

        CONFIG.addComment("Exposing enchantment config");
        CONFIG.set("exposing.enable", true);
        CONFIG.set("exposing.effect_base_time", 40);

        CONFIG.emptyLine();

        CONFIG.addComment("Fat enchantment config");
        CONFIG.set("fat.enable", true);
        CONFIG.set("fat.hearts_addition", 4.5D);

        CONFIG.emptyLine();

        CONFIG.addComment("Fragile strike enchantment config");
        CONFIG.set("fragile_strike.enable", true);
        CONFIG.set("fragile_strike.effect_base_time", 80);
        CONFIG.set("fragile_strike.effect_amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Gravitate enchantment config");
        CONFIG.set("gravitate.enable", true);
        CONFIG.set("gravitate.damage_probability", 30);
        CONFIG.set("gravitate.effect_base_time", 80);

        CONFIG.emptyLine();

        CONFIG.addComment("Gravity curse enchantment config");
        CONFIG.set("gravity_curse.enable", true);
        CONFIG.set("gravity_curse.probability", 20);
        CONFIG.set("gravity_curse.effect_base_time", 200);
        CONFIG.set("gravity_curse.effect_amplifier", 2);

        CONFIG.emptyLine();

        CONFIG.addComment("Hungering strike enchantment config");
        CONFIG.set("hungering_strike.enable", true);
        CONFIG.set("hungering_strike.effect_base_time", 120);
        CONFIG.set("hungering_strike.effect_amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Hunting enchantment config");
        CONFIG.set("hunting.enable", true);
        CONFIG.set("hunting.damage", 5.0F);

        CONFIG.emptyLine();

        CONFIG.addComment("Ice bow enchantment config");
        CONFIG.set("ice_bow.enable", true);
        CONFIG.set("ice_bow.effect_base_time", 60);
        CONFIG.set("ice_bow.effect_amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Log cutter enchantment config");
        CONFIG.set("log_cutter.enable", true);

        CONFIG.emptyLine();

        CONFIG.addComment("Launching enchantment config");
        CONFIG.set("launching.enable", true);
        CONFIG.set("launching.velocity", 1.0D);

        CONFIG.emptyLine();


        CONFIG.addComment("Nether Bane enchantment config");
        CONFIG.set("nether_bane.enable", true);
        CONFIG.set("nether_base.base_damage", 3.0F);

        CONFIG.emptyLine();

        CONFIG.addComment("Night vision enchantment config");
        CONFIG.set("night_vision.enable", true);
        CONFIG.set("night_vision.always_active", false);

        CONFIG.emptyLine();

        CONFIG.addComment("Ninja style enchantment config");
        CONFIG.set("ninja_style.enable", true);
        CONFIG.set("ninja_style.effect_base_time", 20);
        CONFIG.set("ninja_style.effect.amplifier", 0);

        CONFIG.emptyLine();

        CONFIG.addComment("Poison aspect enchantment config");
        CONFIG.set("poison_aspect.enable", true);
        CONFIG.set("poison_aspect.effect_base_time", 200);
        CONFIG.set("poison_aspect.effect_amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Skyward Shot enchantment config");
        CONFIG.set("skyward_shot.enable", true);
        CONFIG.set("skyward_shot.effect_probability", 10);
        CONFIG.set("skyward_shot.effect_time_base", 100);
        CONFIG.set("skyward_shot.effect_amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Slowness aspect enchantment config");
        CONFIG.set("slowness_aspect.enable", true);
        CONFIG.set("slowness_aspect.effect_base_time", 120);
        CONFIG.set("slowness_aspect.effect_amplifier", 1);

        CONFIG.emptyLine();

        CONFIG.addComment("Soulbound enchantment config");
        CONFIG.set("soulbound.enable", true);

        CONFIG.emptyLine();

        CONFIG.addComment("Telekinesis enchantment config");
        CONFIG.set("telekinesis.enable", true);

        CONFIG.emptyLine();

        CONFIG.addComment("Terraforming enchantment config");
        CONFIG.set("terraforming.enable", true);
        CONFIG.set("terraforming.velocity", 58);

        CONFIG.emptyLine();

        CONFIG.addComment("Thunderbolt enchantment config");
        CONFIG.set("thunderbolt.enable", true);
        CONFIG.set("thunderbolt.probability", 30);

        CONFIG.emptyLine();

        CONFIG.addComment("Wither aspect enchantment config");
        CONFIG.set("wither_aspect.enable", true);
        CONFIG.set("wither_aspect.effect_base_time", 120);
        CONFIG.set("wither_aspect.effect_amplifier", 1);

        CONFIG.load();
    }
}
