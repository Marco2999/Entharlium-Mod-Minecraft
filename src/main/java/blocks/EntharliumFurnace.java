package blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EntharliumFurnace extends BlockBase {

	public EntharliumFurnace(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(3.5f);
		setResistance(17.5f);
		setHarvestLevel("pickaxe", 1);
	}
	
}
