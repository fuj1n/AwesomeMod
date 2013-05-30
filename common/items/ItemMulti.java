package fuj1n.awesomeMod.common.items;

import java.util.ArrayList;
import java.util.List;

import fuj1n.awesomeMod.common.lib.MultiItemReference;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemMulti extends Item {

	public Icon[] icons = new Icon[MultiItemReference.ICON_PATHS.length];

	public ItemMulti(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int i = 0; i < MultiItemReference.NAMES_UNLOCALIZED.length; i++) {
			par3List.add(new ItemStack(this, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		if (par1ItemStack.getItemDamage() < MultiItemReference.NAMES_UNLOCALIZED.length) {
			return this.getUnlocalizedName() + "." + MultiItemReference.NAMES_UNLOCALIZED[par1ItemStack.getItemDamage()];
		} else {
			return this.getUnlocalizedName();
		}
	}

	@Override
	public Icon getIconFromDamage(int par1) {
		if (par1 < MultiItemReference.ICON_PATHS.length) {
			return icons[par1];
		} else {
			return this.itemIcon;
		}
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		if (par1ItemStack.getItemDamage() < MultiItemReference.ITEM_INFORMATION.length && MultiItemReference.ITEM_INFORMATION[par1ItemStack.getItemDamage()] != null) {
			String s = MultiItemReference.ITEM_INFORMATION[par1ItemStack.getItemDamage()];
			List infoList = new ArrayList();
			while(s.contains(";")){
				String temp = s.substring(0, s.indexOf(";"));
				s = s.substring(s.indexOf(";") + 1);
				infoList.add(temp);
			}
			infoList.add(s);
			par3List.addAll(infoList);
		}
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		for (int i = 0; i < MultiItemReference.ICON_PATHS.length; i++) {
			icons[i] = par1IconRegister.registerIcon("awesomeMod:" + MultiItemReference.ICON_PATHS[i]);
		}
	}

}
