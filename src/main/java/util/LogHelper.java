package util;

import org.apache.logging.log4j.Level;

import net.minecraftforge.fml.common.FMLLog;

public class LogHelper {

	@SuppressWarnings("deprecation")
	public static void log(Level logLevel, Object object) {
		FMLLog.log(reference.MOD_ID, logLevel, String.valueOf(object));
	}
	
	public static void all (Object object) {
		log(Level.ALL, object);
	}
	
	public static void info (Object object) {
		log(Level.INFO, object);
	}
}
