package binaris.optional_enchants;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Optional_Enchants implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("optional_enchants");

	@Override
	public void onInitialize() {


		LOGGER.info("Loading Optional Enchants");
		LOGGER.info("Thanks for loading my mod! -Binaris");
	}
}