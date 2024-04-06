package me.bluegecko.sowhatisthisitemafterall;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SoWhatIsThisItemAfterAll.MOD_ID)
public class SoWhatIsThisItemAfterAll {
    public static final String MOD_ID = "sowhatisthisitemafterall";
    private static final Logger LOGGER = LogManager.getLogger();

    public SoWhatIsThisItemAfterAll() {
        LOGGER.info("You got 'So What Is This Item After All'!");
        MinecraftForge.EVENT_BUS.register(new ItemTooltipEventHandler());
    }
}
