package EntharliumMod.items;

import EntharliumMod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import util.IHasModel;
import util.Main;

public class WeaponBase extends Item implements IHasModel {

	public WeaponBase(String name) {
		
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
				
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
}
