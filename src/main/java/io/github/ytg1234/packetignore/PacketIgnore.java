package io.github.ytg1234.packetignore;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PacketIgnore implements ModInitializer {
    public static String MOD_ID = "packetignore";
    public static String MOD_NAME = "Packet Ignore";
    public static Logger logger = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        logger.info(MOD_NAME + " initialized.");
    }
}

