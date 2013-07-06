package fuj1n.awesomeMod.client.gui;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.resources.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.world.World;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import fuj1n.awesomeMod.ModJam;
import fuj1n.awesomeMod.common.inventory.ContainerDummy;

public class GuiLightSettings extends GuiContainer {

	private World world;
	private int x, y, z;
	private EntityPlayer entityPlayer;

	private GuiNumberField lightField;
	private GuiLightButton buttonSubtract;
	private GuiLightButton buttonAdd;
	private GuiLightButton buttonSet;

	public int[] themePrefs = ModJam.themeHandler.readConfiguration();
	
	public GuiLightSettings(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
		super(new ContainerDummy());
		world = par1World;
		x = par2;
		y = par3;
		z = par4;
		entityPlayer = par5EntityPlayer;
		xSize = 176;
		ySize = 66;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		RenderHelper.disableStandardItemLighting();
		fontRenderer.drawString("Light Settings", 8, 5, 0xFFFFFF);
		RenderHelper.enableStandardItemLighting();
	}

	@Override
	public void initGui() {
		super.initGui();
		buttonSubtract = new GuiLightButton(0, width / 2 - 40, height / 2 - 18, 20, 20, "-");
		buttonAdd = new GuiLightButton(1, width / 2 + 20, height / 2 - 18, 20, 20, "+");
		buttonSet = new GuiLightButton(2, width / 2 - 35, height / 2 + 5, 70, 20, "Set");
		buttonList.add(buttonSubtract);
		buttonList.add(buttonAdd);
		buttonList.add(buttonSet);
		lightField = new GuiNumberField(fontRenderer, width / 2 - 15, height / 2 - 18, 30, 20);
		lightField.setMaxNumber(15);
		lightField.setMaxStringLength(2);
		lightField.setVisible(true);
		lightField.setTextColor(16777215);
		lightField.setText(Integer.toString(world.getBlockMetadata(x, y, z)));
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		switch (par1GuiButton.id) {
		case 0:
			lightField.decrement();
			break;
		case 1:
			lightField.increment();
			break;
		case 2:
			set_DO();
			break;
		}
	}

	@Override
	public void handleMouseInput() {
		int DWheelRotation = Mouse.getDWheel();
		if (DWheelRotation != 0) {
			if (DWheelRotation > 0) {
				lightField.increment();
			} else if (DWheelRotation < 0) {
				lightField.decrement();
			}
		} else {
			super.handleMouseInput();
		}
	}

	protected boolean set_DO() {
		if (lightField.getText().isEmpty() || lightField.getText() == null || lightField.getText() == "") {
			lightField.setText("0");
		}
		// PACKET
		ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
		DataOutputStream outputStream = new DataOutputStream(bos);
		try {
			outputStream.writeShort(Short.parseShort(lightField.getText()));
			outputStream.writeInt(x);
			outputStream.writeInt(y);
			outputStream.writeInt(z);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "fuj1nAMetaPacket";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		// END PACKET
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.CLIENT) {
			PacketDispatcher.sendPacketToServer(packet);
		}
		entityPlayer.closeScreen();
		return true;
	}

	protected boolean checkHotkeys(int par1) {
		switch (par1) {
		case 20:
			lightField.setText("");
			lightField.setFocused(true);
			return true;
		case 28:
			return set_DO();
		case 30:
			return lightField.decrement();
		case 203:
			return lightField.decrement();
		case 32:
			return lightField.increment();
		case 205:
			return lightField.increment();
		case 17:
			return lightField.minimum();
		case 200:
			return lightField.minimum();
		case 31:
			return lightField.maximum();
		case 208:
			return lightField.maximum();
		default:
			return false;
		}
	}

	@Override
	protected void keyTyped(char par1, int par2) {
		if (!this.checkHotbarKeys(par2)) {
			if (!this.checkHotkeys(par2)) {
				if (lightField.textboxKeyTyped(par1, par2)) {
				} else {
					super.keyTyped(par1, par2);
				}
			}
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		String textureFilePostfix = themePrefs[0] == 0 ? "" : Integer.toString(themePrefs[0] + 1);
		ResourceLocation background = new ResourceLocation("awesomeMod:textures/gui/lightSettings" + textureFilePostfix + ".png");
		mc.renderEngine.func_110577_a(background);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.drawTexturedModalRect(x, y, 0, themePrefs[1] * ySize, xSize, ySize);
		lightField.setFocused(true);
		lightField.drawTextBox();
	}

}
