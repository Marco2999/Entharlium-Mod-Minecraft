package EntharliumMod.init;

import java.util.ArrayList;
import java.util.List;

import blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block ENTHARLIUM_FURNACE = new BlockBase("entharlium_furnace", Material.ROCK);
}