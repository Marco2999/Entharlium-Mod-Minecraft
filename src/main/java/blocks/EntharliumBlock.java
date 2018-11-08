package blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EntharliumBlock extends BlockBase {

	public EntharliumBlock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(5);
		setResistance(30);
		setHarvestLevel("pickaxe", 1);
	}
	
}
