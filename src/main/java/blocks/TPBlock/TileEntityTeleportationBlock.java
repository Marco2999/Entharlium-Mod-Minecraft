package blocks.TPBlock;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityTeleportationBlock extends TileEntity implements ITickable, ICapabilityProvider{

	public int usageLeft = 0;
	public int id = 0;

	private ItemStackHandler handler;

	public TileEntityTeleportationBlock() {
		this.handler = new ItemStackHandler(9);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setLong("usageLeft", usageLeft);
//		nbt.setLong("id", id);

		nbt.setTag("ItemStackHandler", this.handler.serializeNBT());

		return super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		usageLeft = (int) nbt.getLong("usageLeft");
//		id = (int) nbt.getLong("id");

		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));

		super.readFromNBT(nbt);
	}

	@Override
	public void update() {		
		if(!handler.getStackInSlot(0).isEmpty()) {
			if(handler.getStackInSlot(0).getItem().equals(EntharliumMod.init.ModItems.ENTHARLIUM_GEM)) {
				usageLeft += 100 * handler.getStackInSlot(0).getCount();
				handler.setStackInSlot(0, ItemStack.EMPTY);
			}
			if(handler.getStackInSlot(0).getItem().equals(Items.DIAMOND)) {
				usageLeft += 25 * handler.getStackInSlot(0).getCount();
				handler.setStackInSlot(0, ItemStack.EMPTY);
			}
			if(handler.getStackInSlot(0).getItem().equals(Items.EMERALD)) {
				usageLeft += 25 * handler.getStackInSlot(0).getCount();
				handler.setStackInSlot(0, ItemStack.EMPTY);
			}
			if(handler.getStackInSlot(0).getItem().equals(Items.GOLD_INGOT)) {
				usageLeft += 5 * handler.getStackInSlot(0).getCount();
				handler.setStackInSlot(0, ItemStack.EMPTY);
			}
			if(handler.getStackInSlot(0).getItem().equals(Items.IRON_INGOT)) {
				usageLeft += 4 * handler.getStackInSlot(0).getCount();
				handler.setStackInSlot(0, ItemStack.EMPTY);
			}
			markDirty();
		}
	}


	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt; 
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return (T) this.handler;
		}
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
			return true;
		}
		return super.hasCapability(capability, facing);
	}

	public double distanceTo(BlockPos pos, BlockPos pos2) {
		return Math.sqrt((pos.getX() - pos2.getX())^2 + (pos.getZ() - pos2.getZ())^2);
	}

	public TileEntityTeleportationBlock findNearestTeleportationBlock(BlockPos pos, World world,  int teleportID, EntityPlayer player){
		TileEntityTeleportationBlock nearest = null;
		for(TileEntity te : world.loadedTileEntityList){
			if(te instanceof TileEntityTeleportationBlock){
				TileEntityTeleportationBlock tele = (TileEntityTeleportationBlock)te;

				if(!pos.equals(tele.pos)){ 
					if (player.getHeldItemMainhand().getItem() == EntharliumMod.init.ModItems.TELEPORT_WAND) {
						if(pos.distanceSq(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ()) <= 5000) {
							if(nearest == null) {
							nearest = (TileEntityTeleportationBlock) te;			
							player.setPosition(te.getPos().getX(), te.getPos().getY()+1, te.getPos().getZ());
						}else {
							if(pos.distanceSq(te.getPos().getX(), te.getPos().getY(), te.getPos().getZ()) <= pos.distanceSq(nearest.getPos().getX(), nearest.getPos().getY(), nearest.getPos().getZ())) {
								nearest = (TileEntityTeleportationBlock) te;
								player.setPosition(te.getPos().getX(), te.getPos().getY()+1, te.getPos().getZ());
							}
						}					
					}					
				}
			}
		}
	}
		return nearest;
	}

	public int getUsageLeft() {
		return usageLeft;
	}

	public void setUsageLeft(int usageLeft) {
		this.usageLeft = usageLeft;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
