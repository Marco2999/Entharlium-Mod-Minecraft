package EntharliumMod.items.tools;

import EntharliumMod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import util.IHasModel;
import util.Main;

public class ToolSpade extends ItemSpade implements IHasModel{

	public ToolSpade(String name, ToolMaterial material) {
		
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);	
		
		ModItems.ITEMS.add(this);
	}	
	
	@Override
	public void registerModels() {
				
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
