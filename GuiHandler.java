package modJam;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		switch(ID){
		case 0:
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
		}
		return null;
	}

}