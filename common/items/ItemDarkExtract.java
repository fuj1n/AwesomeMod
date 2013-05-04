package fuj1n.awesomeMod.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;

public class ItemDarkExtract extends Item {

	public ItemDarkExtract(int par1) {
		super(par1);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.darkExtract");
	}

}
