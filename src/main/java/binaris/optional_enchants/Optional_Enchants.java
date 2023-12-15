package binaris.optional_enchants;

import binaris.optional_enchants.config.OE_Config;
import binaris.optional_enchants.registry.OE_Enchantments;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Optional_Enchants implements ModInitializer {

	public static final String MOD_ID = "optional_enchants";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		OE_Config.setCONFIG();
		OE_Enchantments.registerAllEnchants();

		LOGGER.info("Loading Optional Enchants");
		LOGGER.info("Thanks for loading my mod! -Binaris");
	}
}