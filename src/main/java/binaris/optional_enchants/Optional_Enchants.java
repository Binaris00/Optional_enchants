package binaris.optional_enchants;

import binaris.optional_enchants.enchantment.Ice_Bow_Enchantment;
import binaris.optional_enchants.enchantment.NinjaStyle_Enchantment;
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



	public static final String MOD_ID = "optional_enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "ice_bow"), ICE_BOW);
		Registry.register(Registries.ENCHANTMENT, new Identifier(MOD_ID, "ninja_style"), NINJA_STYLE);


		LOGGER.info("Loading Optional Enchants");
		LOGGER.info("Thanks for loading my mod! -Binaris");
	}
}