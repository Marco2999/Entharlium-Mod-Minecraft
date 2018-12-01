package blocks.TPBlock;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import util.reference;

public class GuiTeleportationBlock extends GuiContainer{

	private TileEntityTeleportationBlock te;
	private IInventory playerInv;
	
	public GuiTeleportationBlock(IInventory playerInv, TileEntityTeleportationBlock te) {
		super(new ContainerTeleportationBlock(playerInv, te));
		
		this.xSize = 176;
		this.ySize= 166;
		
		this.te = te;
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0F, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(reference.MOD_ID, "textures/gui/container/teleportation_gui.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = I18n.format("container.teleportation_block"); 
		this.mc.fontRenderer.drawString(s, this.xSize / 2 - this.mc.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
		this.mc.fontRenderer.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752);
		this.mc.fontRenderer.drawString("Power: " + te.usageLeft, 100, 40, 4210752);
	}
}
