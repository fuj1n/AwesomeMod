package fuj1n.awesomeMod.common.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemHoe;
import fuj1n.awesomeMod.ModJam;

public class ItemAwesomeHoe extends ItemHoe {

	public String texture;

	public ItemAwesomeHoe(int par1, EnumToolMaterial par2EnumToolMaterial, String tex) {
		super(par1, par2EnumToolMaterial);
		this.setCreativeTab(ModJam.modJamCreativeTab);
		texture = tex;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon(texture);
	}

}
