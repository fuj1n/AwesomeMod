package modJam;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDarkExtract extends Item{

	public ItemDarkExtract(int par1) {
		super(par1);
	}
	
	@Override
	public void updateIcons(IconRegister par1IconRegister){
		this.iconIndex = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.darkExtract");
	}

}
