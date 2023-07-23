package binaris.optional_enchants;

import binaris.optional_enchants.enchantment.*;
import binaris.optional_enchants.util.SimpleEnchantBuilder;
import net.fabricmc.api.ModInitializer;

import net.minecraft.enchantment.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Optional_Enchants implements ModInitializer {

	//Enchants
	public static Enchantment FAT = new SimpleEnchantBuilder(Enchantment.Rarity.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.CHEST, EquipmentSlot.FEET},
			20, 50, 1, false, false, new Enchantment[]{Enchantments.PROTECTION, Enchantments.PROJECTILE_PROTECTION, Enchantments.BLAST_PROTECTION, Enchantments.FIRE_PROTECTION}, null);
	public static Enchantment GRAVITATE = new SimpleEnchantBuilder(Enchantment.Rarity.VERY_RARE, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS},
			30, 50, 3, false, true, new Enchantment[]{Enchantments.SWIFT_SNEAK}, null);
	public static Enchantment NINJA_STYLE = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
			1, 50, 4, false, false, null, null);
	public static Enchantment ANGRY_LUMBERJACK = new SimpleEnchantBuilder(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND},
			1, 50, 4, false, false, null, null);

	public static Enchantment ICE_BOW = new Ice_Bow_Enchantment();
	public static Enchantment BETRAYER = new Betrayer_Enchantment();
	public static Enchantment END_HARM = new EndHarm_Enchantment();
	public static Enchantment SKYWARDSHOT = new SkywardShot_Enchantment();
	public static Enchantment WITHERASPECT = new WitherAspect_Enchantment();


	//Curses
	public static Enchantment GRAVITY_CURSE = new Gravity_Curse();

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

		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "gravity_curse"), GRAVITY_CURSE);

		LOGGER.info("Loading Optional Enchants");
		LOGGER.info("Thanks for loading my mod! -Binaris");
	}
}