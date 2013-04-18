package fuj1n.awesomeMod.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import fuj1n.awesomeMod.common.inventory.ContainerDummy;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		case 0:
			return new ContainerDummy();
		case 1:
			return new ContainerDummy();
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		case 0:
			return new GuiLightSettings(world, x, y, z, player);
		case 1:
			return new GuiThemePreferences(player);
		}
		return null;
	}

}
