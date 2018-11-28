package EntharliumMod.proxy;

import blocks.TPBlock.TileEntityTeleportationBlock;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import util.reference;

public class CommonProxy {
	
	public void preInit() {
		
	}
	
	public void init() {
		
	}

	public void registerItemRenderer(Item item, int meta, String id) {}
		
	@SuppressWarnings("deprecation")
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityTeleportationBlock.class, reference.MOD_ID + ":teleportation_block");
	}
			
}
