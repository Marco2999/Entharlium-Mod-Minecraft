package EntharliumMod.items;

import EntharliumMod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import util.IHasModel;
import util.Main;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
				
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
