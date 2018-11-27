package EntharliumMod.items.tools;

import EntharliumMod.init.ModItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSword;
import util.IHasModel;
import util.Main;

public class ToolShield extends ItemShield implements IHasModel{

	public ToolShield(String name, ToolMaterial material) {
		
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);	
		setMaxDamage(1000000);
		
		ModItems.ITEMS.add(this);
	}	
	
	@Override
	public void registerModels() {
				
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
