package modJam;

import net.minecraft.item.ItemBlock;

public class ItemChair extends ItemBlock{

	public int chairType;
	
	public ItemChair(int par1, int par2) {
		super(par1);
		chairType = par2;
	}

}
