package fuj1n.awesomeMod.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiLightButton extends GuiButton {
	/** Button width in pixels */
	protected int width;

	/** Button height in pixels */
	protected int height;

	/** The x position of this control. */
	public int xPosition;

	/** The y position of this control. */
	public int yPosition;

	/** The string displayed on this control. */
	public String displayString;

	/** ID for this control. */
	public int id;

	/** True if this control is enabled, false to disable. */
	public boolean enabled;

	/** Hides the button completely if false. */
	public boolean drawButton;
	protected boolean field_82253_i;

	/** Resources */
	ResourceLocation backgroundLocation = new ResourceLocation("awesomeMod:textures/gui/lightButtons.png");
	
	public GuiLightButton(int par1, int par2, int par3, String par4Str) {
		super(par1, par2, par3, 200, 20, par4Str);
	}

	public GuiLightButton(int par1, int par2, int par3, int par4, int par5, String par6Str) {
		super(par1, par2, par3, par4, par5, par6Str);
		width = 200;
		height = 20;
		enabled = true;
		drawButton = true;
		id = par1;
		xPosition = par2;
		yPosition = par3;
		width = par4;
		height = par5;
		displayString = par6Str;
	}

	/**
	 * Returns 0 if the button is disabled, 1 if the mouse is NOT hovering over
	 * this button and 2 if it IS hovering over this button.
	 */
	@Override
	protected int getHoverState(boolean par1) {
		byte b0 = 1;

		if (!enabled) {
			b0 = 0;
		} else if (par1) {
			b0 = 2;
		}

		return b0;
	}

	/**
	 * Draws this button to the screen.
	 */
	@Override
	public void drawButton(Minecraft par1Minecraft, int par2, int par3) {
		if (drawButton) {
			FontRenderer fontrenderer = par1Minecraft.fontRenderer;
			par1Minecraft.renderEngine.func_110577_a(backgroundLocation);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			field_82253_i = par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
			int k = this.getHoverState(field_82253_i);
			this.drawTexturedModalRect(xPosition, yPosition, 0, 46 + k * 20, width / 2, height);
			this.drawTexturedModalRect(xPosition + width / 2, yPosition, 200 - width / 2, 46 + k * 20, width / 2, height);
			this.mouseDragged(par1Minecraft, par2, par3);
			int l = 14737632;
			if (!enabled) {
				l = 0xFFFFFF;
			} else if (field_82253_i) {
				l = 0xDDDDDD;
			}

			this.drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, l);
		}
	}

	/**
	 * Fired when the mouse button is dragged. Equivalent of
	 * MouseListener.mouseDragged(MouseEvent e).
	 */
	@Override
	protected void mouseDragged(Minecraft par1Minecraft, int par2, int par3) {
	}

	/**
	 * Fired when the mouse button is released. Equivalent of
	 * MouseListener.mouseReleased(MouseEvent e).
	 */
	@Override
	public void mouseReleased(int par1, int par2) {
	}

	/**
	 * Returns true if the mouse has been pressed on this control. Equivalent of
	 * MouseListener.mousePressed(MouseEvent e).
	 */
	@Override
	public boolean mousePressed(Minecraft par1Minecraft, int par2, int par3) {
		return enabled && drawButton && par2 >= xPosition && par3 >= yPosition && par2 < xPosition + width && par3 < yPosition + height;
	}

	@Override
	public boolean func_82252_a() {
		return field_82253_i;
	}

	@Override
	public void func_82251_b(int par1, int par2) {
	}
}
