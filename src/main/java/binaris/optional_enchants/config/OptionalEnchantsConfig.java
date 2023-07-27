package binaris.optional_enchants.config;

import binaris.optional_enchants.Optional_Enchants;
import com.mojang.datafixers.util.Pair;

public class OptionalEnchantsConfig {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(Optional_Enchants.MOD_ID + "config").provider(configs).request();
    }
    private static void createConfigs() {
        configs.addComment("Ice bow enchantment config");
        configs.addKeyValuePair(new Pair<>("ice_bow.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("ice_bow.effect_base_time", 60), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("ice_bow.effect_amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Fat enchantment config");
        configs.addKeyValuePair(new Pair<>("fat.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("fat.hearts_addition", 4.5D), "Double");

        configs.emptyLine();

        configs.addComment("Gravitate enchantment config");
        configs.addKeyValuePair(new Pair<>("gravitate.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("gravitate.damage_probability", 30), "int (max 100)");
        configs.addKeyValuePair(new Pair<>("gravitate.effect_base_time", 80), "int (this is in ticks)");

        configs.emptyLine();

        configs.addComment("Ninja style enchantment config");
        configs.addKeyValuePair(new Pair<>("ninja_style.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("ninja_style.effect_base_time", 20), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("ninja_style.effect.amplifier", 0), "int");

        configs.emptyLine();

        configs.addComment("Angry lumberjack enchantment config");
        configs.addKeyValuePair(new Pair<>("angry_lumberjack.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("angry_lumberjack.effect_base_time", 20), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("angry_lumberjack.effect.amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Auto Smelt enchantment config");
        configs.addKeyValuePair(new Pair<>("auto_smelt.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Telekinesis enchantment config");
        configs.addKeyValuePair(new Pair<>("telekinesis.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Wither Aspect enchantment config");
        configs.addKeyValuePair(new Pair<>("wither_aspect.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("wither_aspect.effect_base_time", 120), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("wither_aspect.effect_amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Poison Aspect enchantment config");
        configs.addKeyValuePair(new Pair<>("poison_aspect.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("poison_aspect.effect_base_time", 200), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("poison_aspect.effect_amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Slowness Aspect enchantment config");
        configs.addKeyValuePair(new Pair<>("slowness_aspect.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("slowness_aspect.effect_base_time", 120), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("slowness_aspect.effect_amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Fragile strike enchantment config");
        configs.addKeyValuePair(new Pair<>("fragile_strike.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("fragile_strike.effect_base_time", 80), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("fragile_strike.effect_amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Hungering Strike enchantment config");
        configs.addKeyValuePair(new Pair<>("hungering_strike.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("hungering_strike.effect_base_time", 80), "int (this is in ticks)");
        configs.addKeyValuePair(new Pair<>("hungering_strike.effect_amplifier", 0), "int");

        configs.emptyLine();

        configs.addComment("End Harm enchantment config");
        configs.addKeyValuePair(new Pair<>("end_harm.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("end_harm.attack_damage", 3.0F), "float");

        configs.emptyLine();

        configs.addComment("Skyward Shot enchantment config");
        configs.addKeyValuePair(new Pair<>("skyward_shot.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("skyward_shot.effect_probability", 10), "int (max 100)");
        configs.addKeyValuePair(new Pair<>("skyward_shot.effect_time_base", 100), "(this is in ticks");
        configs.addKeyValuePair(new Pair<>("skyward_shot.effect_amplifier", 1), "int");

        configs.emptyLine();

        configs.addComment("Hunting enchantment config");
        configs.addKeyValuePair(new Pair<>("hunting.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("hunting.damage", 5.0F), "float");

        configs.emptyLine();

        configs.addComment("Gravity curse config");
        configs.addKeyValuePair(new Pair<>("gravity_curse.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("gravity_curse.probability", 20), "int (max 100)");
        configs.addKeyValuePair(new Pair<>("gravity_curse.effect_base_time", 200), "(this is in ticks)");
        configs.addKeyValuePair(new Pair<>("gravity_curse.effect_amplifier", 2), "int");

        configs.emptyLine();

        configs.addComment("Breaking curse config");
        configs.addKeyValuePair(new Pair<>("breaking_curse.enable", true), "boolean");

        configs.emptyLine();

        configs.addComment("Nether Bane enchantment config");
        configs.addKeyValuePair(new Pair<>("nether_bane.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("nether_base.base_damage", 3.0F), "float");

        configs.emptyLine();

        configs.addComment("Betrayer enchantment config");
        configs.addKeyValuePair(new Pair<>("betrayer.enable", true), "boolean");
        configs.addKeyValuePair(new Pair<>("betrayer.base_damage", 3.0F), "float");

    }

}
