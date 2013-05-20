package fuj1n.awesomeMod.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemWorldGen extends Item{

	public ItemWorldGen(int par1) {
		super(par1);
	}
	
	@Override
	public void registerIcons(IconRegister par1IconRegister){
		this.itemIcon = par1IconRegister.registerIcon("missingtex");
	}

}
