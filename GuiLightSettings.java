package modJam;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
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
	
	public GuiLightSettings(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		super(new ContainerDummy());
		container = (ContainerDummy)this.inventorySlots;
		world = par1World;
		x = par2;
		y = par3;
		z = par4;
		entityPlayer = par5EntityPlayer;
		ySize = 190;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
        fontRenderer.drawString("Light Settings", 8, 5, 4210752);
	}
	
	@Override
    public void initGui() {
		super.initGui();
		buttonList.add(new GuiButton(0, width / 2 - 60, height / 2 - 60, 20, 20, "0"));
		buttonList.add(new GuiButton(1, width / 2 - 10, height / 2 - 60, 20, 20, "1"));
		buttonList.add(new GuiButton(2, width / 2 + 40, height / 2 - 60, 20, 20, "2"));
		buttonList.add(new GuiButton(3, width / 2 - 60, height / 2 - 35, 20, 20, "3"));
		buttonList.add(new GuiButton(4, width / 2 - 10, height / 2 - 35, 20, 20, "4"));
		buttonList.add(new GuiButton(5, width / 2 + 40, height / 2 - 35, 20, 20, "5"));
		buttonList.add(new GuiButton(6, width / 2 - 60, height / 2 - 10, 20, 20, "6"));
		buttonList.add(new GuiButton(7, width / 2 - 10, height / 2 - 10, 20, 20, "7"));
		buttonList.add(new GuiButton(8, width / 2 + 40, height / 2 - 10, 20, 20, "8"));
		buttonList.add(new GuiButton(9, width / 2 - 60, height / 2 + 15, 20, 20, "9"));
		buttonList.add(new GuiButton(10, width / 2 - 10, height / 2 + 15, 20, 20, "10"));
		buttonList.add(new GuiButton(11, width / 2 + 40, height / 2 + 15, 20, 20, "11"));
		buttonList.add(new GuiButton(12, width / 2 - 60, height / 2 + 40, 20, 20, "12"));
		buttonList.add(new GuiButton(13, width / 2 - 10, height / 2 + 40, 20, 20, "13"));
		buttonList.add(new GuiButton(14, width / 2 + 40, height / 2 + 40, 20, 20, "14"));
		buttonList.add(new GuiButton(15, width / 2 - 10, height / 2 + 65, 20, 20, "15"));
	}
	
	@Override
    protected void actionPerformed(GuiButton par1GuiButton) {
		//PACKET
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeShort(par1GuiButton.id);
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
		
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture("/gui/lightSettings.png");
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}

}
