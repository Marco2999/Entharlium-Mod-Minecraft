package EntharliumMod.items.tools;

import EntharliumMod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import util.IHasModel;
import util.Main;

public class ToolSword extends ItemSword implements IHasModel{

	public ToolSword(String name, ToolMaterial material) {
		
		super(material);
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
