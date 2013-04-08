package modJam;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

/**
 * COPY INFORMATION
 * 
 * This is a dummy container created for instances of GuiContainer that do not use any slots,
 * this class has no other uses, and therefore must be treated as a redundant class. 
 */

public class ContainerDummy extends Container{

	public boolean isGuiAvailable = true;
	
	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return isGuiAvailable;
	}

}
