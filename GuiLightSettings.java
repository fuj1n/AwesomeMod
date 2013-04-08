package modJam;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;

public class GuiLightSettings extends GuiContainer{

	private World world;
	private int x, y, z;
	private EntityPlayer entityPlayer;
	
	private ContainerDummy container;
	
	private GuiLightTextField lightField;
	private GuiButton buttonSubtract;
	private GuiButton buttonAdd;
	private GuiButton buttonSet;
	
	public GuiLightSettings(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		super(new ContainerDummy());
		container = (ContainerDummy)this.inventorySlots;
		world = par1World;
		x = par2;
		y = par3;
		z = par4;
		entityPlayer = par5EntityPlayer;
		xSize = 176;
		ySize = 66;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
        fontRenderer.drawString("Light Settings", 8, 5, 4210752);
	}
	
	@Override
    public void initGui() {
		super.initGui();
		buttonSubtract = new GuiButton(0, this.width / 2 - 40, this.height / 2 - 18, 20, 20, "-");
		buttonAdd = new GuiButton(1, this.width / 2 + 20, this.height / 2 - 18, 20, 20, "+");
		buttonSet = new GuiButton(2, this.width / 2 - 35, this.height / 2 + 5, 70, 20, "Set");
		this.buttonList.add(buttonSubtract);
		this.buttonList.add(buttonAdd);
		this.buttonList.add(buttonSet);
		this.lightField = new GuiLightTextField(this.fontRenderer, this.width / 2 - 15, this.height / 2 - 18, 30, 20);
		this.lightField.setMaxStringLength(2);
        this.lightField.setVisible(true);
        this.lightField.setTextColor(16777215);
		this.lightField.setText(Integer.toString(world.getBlockMetadata(x, y, z)));
	}
	
	@Override
    protected void actionPerformed(GuiButton par1GuiButton) {
		switch(par1GuiButton.id){
		case 0: 
			if(Integer.parseInt(this.lightField.getText()) > 0){
				int value = Integer.parseInt(this.lightField.getText()) - 1;
				this.lightField.setText(Integer.toString(value));
			}
			break;
		case 1:
			if(Integer.parseInt(this.lightField.getText()) < 15){
				int value = Integer.parseInt(this.lightField.getText()) + 1;
				this.lightField.setText(Integer.toString(value));
			}
			break;
		case 2:
			//PACKET
			ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
			DataOutputStream outputStream = new DataOutputStream(bos);
			try {
				outputStream.writeShort(Short.parseShort(this.lightField.getText()));
				outputStream.writeInt(x);
				outputStream.writeInt(y);
				outputStream.writeInt(z);
			} catch (Exception ex) {
			        ex.printStackTrace();
			}

			Packet250CustomPayload packet = new Packet250CustomPayload();
			packet.channel = "fuj1nAMetaPacket";
			packet.data = bos.toByteArray();
			packet.length = bos.size();
			//END PACKET
			if(FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT){
				System.out.println(packet);
				PacketDispatcher.sendPacketToServer(packet);
			}
			this.entityPlayer.closeScreen();
			break;
		}
	}
	
	protected void keyTyped(char par1, int par2) {
		if (!this.checkHotbarKeys(par2)) {
			if (this.lightField.textboxKeyTyped(par1, par2)) {}
			else {
				super.keyTyped(par1, par2);
			}
		}
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/lightSettings.png");
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        this.lightField.setFocused(true);
        this.lightField.drawTextBox();
	}

}
