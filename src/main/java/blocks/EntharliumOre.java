package blocks;

import java.util.Random;

import EntharliumMod.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class EntharliumOre extends BlockBase {

	public EntharliumOre(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(3);
		setResistance(30);
		setHarvestLevel("pickaxe", 3);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.ENTHARLIUM_GEM;
	}
	
	@Override
	public int quantityDropped(Random rand) {
		if(rand.nextInt(100)<=90) {
			return 1;
		}else {
			return 2;
		}
	}
		
}
