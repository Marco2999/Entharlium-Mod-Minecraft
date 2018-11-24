package EntharliumMod.init;

import java.util.ArrayList;
import java.util.List;

import blocks.BlockBase;
import blocks.EntharliumBlock;
import blocks.EntharliumFurnace;
import blocks.EntharliumOre;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ENTHARLIUM_FURNACE = new EntharliumFurnace("entharlium_furnace", Material.ROCK);
	public static final Block ENTHARLIUM_BLOCK = new EntharliumBlock("entharlium_block", Material.IRON);
	public static final Block ENTHARLIUM_ORE = new EntharliumOre("entharlium_ore", Material.ROCK);
}
