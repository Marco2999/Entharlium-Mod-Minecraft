package util;

import EntharliumMod.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod (modid = reference.MOD_ID, name = reference.NAME, version = reference.VERSION)
public class Main {
	
	@Instance 
	public static Main instance;
	
	@SidedProxy(clientSide = reference.CLIENT_PROXY_CLASS, serverSide = reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event){
		
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){
		
	}
	@EventHandler
	public static void Postinit(FMLPostInitializationEvent event){
		
	}
	
}
