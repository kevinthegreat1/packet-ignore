package io.github.ytg1234.packetignore;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketIgnore implements ModInitializer {
    public static final String MOD_ID = "packetignore";
    public static final String MOD_NAME = "Packet Ignore";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info(MOD_NAME + " initialized.");
    }
}

