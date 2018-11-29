package util.handlers;

import blocks.TPBlock.ContainerTeleportationBlock;
import blocks.TPBlock.GuiTeleportationBlock;
import blocks.TPBlock.TileEntityTeleportationBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int TELEPORTATION_BLOCK = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == TELEPORTATION_BLOCK) {
			return new ContainerTeleportationBlock(player.inventory, (TileEntityTeleportationBlock) world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == TELEPORTATION_BLOCK) {
			return new GuiTeleportationBlock(player.inventory, (TileEntityTeleportationBlock) world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}

}
