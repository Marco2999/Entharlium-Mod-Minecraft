package blocks.TPBlock;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
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
		NBTTagList list = new NBTTagList();
		for(int slot = 0; slot < handler.getSlots(); slot++) {
			if(handler.getStackInSlot(slot) != ItemStack.EMPTY) {
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) slot);
				handler.getStackInSlot(slot).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		nbt.setTag("Items", list);
		nbt.setLong("usageLeft", usageLeft);
		nbt.setLong("id", id);

		nbt.setTag("ItemStackHandler", this.handler.serializeNBT());

		return super.writeToNBT(nbt);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagList list = nbt.getTagList("Items", 10);
		usageLeft = (int) nbt.getLong("usageLeft");
		id = (int) nbt.getLong("id");

		for(int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			((IInventory) handler).setInventorySlotContents(slot, new ItemStack(stackTag));
		}

		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));

		super.readFromNBT(nbt);
	}

	@Override
	public void update() {		


		//		markDirty();
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
		return Math.sqrt((pos.getX() - pos2.getX())^2 + (pos.getY() - pos2.getY())^2 + (pos.getZ() - pos2.getZ())^2);
	}

	public TileEntityTeleportationBlock findNearestTeleportationBlock(BlockPos pos, World world,  int teleportID){
		TileEntityTeleportationBlock nearest = null;
		for(TileEntity te : world.loadedTileEntityList){
			if(te instanceof TileEntityTeleportationBlock){
				TileEntityTeleportationBlock tele = (TileEntityTeleportationBlock)te;
				//	            if(tele.getId() == teleportID)
				//	                continue;

				if((nearest == null) && (!pos.equals(tele.pos))){
					nearest = tele;
					continue;
				}

				if((!pos.equals(tele.pos)) && (distanceTo(tele.pos, pos) < distanceTo(nearest.pos, tele.pos))){
					nearest = tele;
				}
			}
		}


		// testing
		if(nearest != null) {
			System.out.println("nearest: " + nearest.getPos());
			System.out.println("block: " +  pos);
		}
		else {System.out.println("null");}
		//

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