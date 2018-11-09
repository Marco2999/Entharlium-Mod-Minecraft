package EntharliumMod.init;

import java.util.ArrayList;
import java.util.List;

import EntharliumMod.items.ItemBase;
import EntharliumMod.items.tools.ToolSword;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	//Items
	public static final Item ENTHARLIUM_MIX = new ItemBase("entharlium_mix");
	public static final Item ENTHARLIUM_GEM = new ItemBase("entharlium_gem");
	
	//Material
	public static final ToolMaterial MATERIAL_ENTHARLIUM = EnumHelper.addToolMaterial("material_entharlium", 3, 3122, 12.0f, 6.0f, 10);
	
	//Tools
	public static final ItemSword ENTHARLIUM_SWORD =  new ToolSword("entharlium_sword", MATERIAL_ENTHARLIUM);
}
