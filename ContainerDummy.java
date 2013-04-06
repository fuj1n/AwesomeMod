package modJam;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDummy extends Container{

	public boolean isGuiAvailable = true;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return isGuiAvailable;
	}

}
