package binaris.optional_enchants;

import binaris.optional_enchants.enchantment.*;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Optional_Enchants implements ModInitializer {

	public static Enchantment ICE_BOW = new Ice_Bow_Enchantment();
	public static Enchantment NINJA_STYLE = new NinjaStyle_Enchantment();
	public static Enchantment ANGRY_LUMBERJACK = new AngryLumberjack_Enchantment();
	public static Enchantment BETRAYER = new Betrayer_Enchantment();
	public static Enchantment END_HARM = new EndHarm_Enchantment();
	public static Enchantment FAT = new Fat_Enchantment();
	public static Enchantment GRAVITATE = new Gravitate_Enchantment();
	public static Enchantment SKYWARDSHOT = new SkywardShot_Enchantment();
	public static Enchantment WITHERASPECT = new WitherAspect_Enchantment();

	public static final String MOD_ID = "optional_enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "ice_bow"), ICE_BOW);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "ninja_style"), NINJA_STYLE);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "angry_lumberjack"), ANGRY_LUMBERJACK);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "betrayer"), BETRAYER);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "end_harm"), END_HARM);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "fat"), FAT);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "gravitate"), GRAVITATE);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "skyward_shot"), SKYWARDSHOT);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "wither_aspect"), WITHERASPECT);



		LOGGER.info("Loading Optional Enchants");
		LOGGER.info("Thanks for loading my mod! -Binaris");
	}
}