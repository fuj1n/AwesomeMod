package fuj1n.awesomeMod.common.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemAwesomeIngot extends Item {

	private Icon[] iconsList = new Icon[16];

	private static final String[] subNames = { "white", "orange", "magenta", "lBlue", "yellow", "lime", "pink", "gray", "lGray", "cyan", "purple", "blue", "brown", "green", "red", "black" };

	public ItemAwesomeIngot(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	@Override
	public Icon getIconFromDamage(int par1) {
		if (par1 < iconsList.length) {
			return iconsList[par1];
		} else {
			return iconsList[0];
		}
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
		par3List.add(new ItemStack(par1, 1, 2));
		par3List.add(new ItemStack(par1, 1, 3));
		par3List.add(new ItemStack(par1, 1, 4));
		par3List.add(new ItemStack(par1, 1, 5));
		par3List.add(new ItemStack(par1, 1, 6));
		par3List.add(new ItemStack(par1, 1, 7));
		par3List.add(new ItemStack(par1, 1, 8));
		par3List.add(new ItemStack(par1, 1, 9));
		par3List.add(new ItemStack(par1, 1, 10));
		par3List.add(new ItemStack(par1, 1, 11));
		par3List.add(new ItemStack(par1, 1, 12));
		par3List.add(new ItemStack(par1, 1, 13));
		par3List.add(new ItemStack(par1, 1, 14));
		par3List.add(new ItemStack(par1, 1, 15));
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		iconsList[0] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotWhite");
		iconsList[1] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotOrange");
		iconsList[2] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotMagenta");
		iconsList[3] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotLBlue");
		iconsList[4] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotYellow");
		iconsList[5] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotLime");
		iconsList[6] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotPink");
		iconsList[7] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotGray");
		iconsList[8] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotLGray");
		iconsList[9] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotCyan");
		iconsList[10] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotPurple");
		iconsList[11] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotBlue");
		iconsList[12] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotBrown");
		iconsList[13] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotGreen");
		iconsList[14] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotRed");
		iconsList[15] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeIngotBlack");
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage() < subNames.length ? par1ItemStack.getItemDamage() : 0];
	}

}
