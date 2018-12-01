package EntharliumMod.proxy;

import blocks.TPBlock.TileEntityTeleportationBlock;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import util.Main;
import util.reference;
import util.handlers.GuiHandler;

public class CommonProxy {
	
	public void preInit() {
		
	}
	
	public void init() {
		
	}
	
	public void registerNetworkStuff() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());
	}

	public void registerItemRenderer(Item item, int meta, String id) {}
		
	@SuppressWarnings("deprecation")
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTeleportationBlock.class, reference.MOD_ID + ":teleportation_block");
	}
			
}
