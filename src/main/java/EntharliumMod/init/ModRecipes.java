package EntharliumMod.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	public static void init() {
		
		GameRegistry.addSmelting(ModItems.ENTHARLIUM_MIX, new ItemStack(ModItems.ENTHARLIUM_GEM, 1), 1.0f);
	}
}
