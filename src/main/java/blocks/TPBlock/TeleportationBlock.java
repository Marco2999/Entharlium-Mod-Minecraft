package blocks.TPBlock;

import blocks.BlockBase;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import util.IHasModel;
import util.handlers.GuiHandler;

public class TeleportationBlock extends BlockBase implements IHasModel, ITileEntityProvider{

	public TeleportationBlock(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.METAL);
		setHardness(3.5f);
		setResistance(17.5f);
		setHarvestLevel("pickaxe", 2);
	}

	public TileEntityTeleportationBlock getTileEntity(IBlockAccess world, BlockPos pos) {
		return new TileEntityTeleportationBlock();
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTeleportationBlock();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {	
//		if(!worldIn.isRemote) {
//			playerIn.openGui(util.Main.instance, GuiHandler.TELEPORTATION_BLOCK, worldIn, pos.getX(), pos.getY(), pos.getZ());
//		}
		getTileEntity(worldIn, pos).findNearestTeleportationBlock(pos, worldIn, getTileEntity(worldIn, pos).getId());
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

}

