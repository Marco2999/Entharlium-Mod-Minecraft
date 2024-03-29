package EntharliumMod.init;

import java.util.ArrayList;
import java.util.List;

import EntharliumMod.items.ItemBase;
import EntharliumMod.items.armor.ArmorBase;
import EntharliumMod.items.tools.ToolAxe;
import EntharliumMod.items.tools.ToolHoe;
import EntharliumMod.items.tools.ToolPickaxe;
import EntharliumMod.items.tools.ToolShield;
import EntharliumMod.items.tools.ToolSpade;
import EntharliumMod.items.tools.ToolSword;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.common.util.EnumHelper;
import util.reference;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	
	//Items
	public static final Item ENTHARLIUM_MIX = new ItemBase("entharlium_mix", CreativeTabs.MATERIALS);
	public static final Item ENTHARLIUM_GEM = new ItemBase("entharlium_gem", CreativeTabs.MATERIALS);
	public static final Item TELEPORT_WAND = new ItemBase("teleport_wand", CreativeTabs.TOOLS);
	
	//Material
	public static final ToolMaterial MATERIAL_ENTHARLIUM = EnumHelper.addToolMaterial("material_entharlium", 3, 3122, 12.0f, 6.0f, 10);
	public static final ArmorMaterial ARMOR_MATERIAL_ENTHARLIUM = EnumHelper.addArmorMaterial("armor_material_entharlium", reference.MOD_ID+":entharlium", 18, 
			new int[] {3, 11, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0.0f);
	
	//Tools
	public static final ItemSword ENTHARLIUM_SWORD =  new ToolSword("entharlium_sword", MATERIAL_ENTHARLIUM);
	public static final ItemPickaxe ENTHARLIUM_PICKAXE =  new ToolPickaxe("entharlium_pickaxe", MATERIAL_ENTHARLIUM);
	public static final ItemSpade ENTHARLIUM_SHOVEL =  new ToolSpade("entharlium_shovel", MATERIAL_ENTHARLIUM);
	public static final ItemAxe ENTHARLIUM_AXE =  new ToolAxe("entharlium_axe", MATERIAL_ENTHARLIUM);
	public static final ItemHoe ENTHARLIUM_HOE=  new ToolHoe("entharlium_hoe", MATERIAL_ENTHARLIUM);
	
	public static final ItemShield ENTHARLIUM_SHIELD=  new ToolShield("entharlium_shield", MATERIAL_ENTHARLIUM);
	
	//Armor
	public static final Item ENTHARLIUM_HELMET = new ArmorBase("entharlium_helmet", ARMOR_MATERIAL_ENTHARLIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item ENTHARLIUM_CHESTPLATE	= new ArmorBase("entharlium_chestplate", ARMOR_MATERIAL_ENTHARLIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item ENTHARLIUM_LEGGINGS = new ArmorBase("entharlium_leggings", ARMOR_MATERIAL_ENTHARLIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item ENTHARLIUM_BOOTS = new ArmorBase("entharlium_boots", ARMOR_MATERIAL_ENTHARLIUM, 1, EntityEquipmentSlot.FEET);
	
	
}
	
	
