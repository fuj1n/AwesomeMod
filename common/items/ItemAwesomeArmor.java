package fuj1n.awesomeMod.common.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fuj1n.awesomeMod.ModJam;

public class ItemAwesomeArmor extends ItemArmor {

	private String texture;

	private Icon overlayTexture;

	public ItemAwesomeArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String tex) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(ModJam.modJamCreativeTab);
		texture = tex;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return false;
	}

	/*
	 * public Icon getIcon(ItemStack stack, int pass){ if(pass == 0){ return
	 * this.itemIcon; }else if(pass == 1){ if(hasColor(stack)){ return
	 * this.overlayTexture; } } return this.itemIcon; }
	 */

	public void setItemColorIDToNBT(ItemStack par1ItemStack, int colorMeta) {
		NBTTagCompound nbt;
		if (par1ItemStack.getTagCompound() != null) {
			nbt = par1ItemStack.getTagCompound();
		} else {
			nbt = new NBTTagCompound();
		}

		nbt.setByte("Color", (byte) colorMeta);
		par1ItemStack.setTagCompound(nbt);
	}

	@Override
	public boolean hasColor(ItemStack par1ItemStack) {
		return false;
		// return par1ItemStack.getTagCompound() == null ? false :
		// par1ItemStack.getTagCompound().hasKey("Color");
	}

	/*
	 * public int getColor(ItemStack par1ItemStack){ return
	 * hasColor(par1ItemStack) ? 0 :
	 * par1ItemStack.getTagCompound().getByte("Color"); }
	 */

	public String getArmorNameByType(int type) {
		String typeStr;
		switch (armorType) {
		case 0:
			typeStr = "helmet";
			break;
		case 1:
			typeStr = "chestplate";
			break;
		case 2:
			typeStr = "leggings";
			break;
		case 3:
			typeStr = "boots";
			break;
		default:
			typeStr = "unknown";
			break;
		}
		return typeStr;
	}

	/**
	 * returns a list of items with the same ID, but different meta (eg: dye
	 * returns 16 items)
	 */
	@Override
	public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		/*
		 * ItemStack var1 = new ItemStack(par1, 1, 0); for(int i = 0; i < 15;
		 * i++){ setItemColorIDToNBT(var1, i); par3List.add(var1); }
		 */
		par3List.add(new ItemStack(par1, 1, 0));
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		String type = getArmorNameByType(armorType);
		itemIcon = par1IconRegister.registerIcon(texture + "." + type);
		overlayTexture = par1IconRegister.registerIcon(texture + "." + type + ".overlay");

	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, int layer) {
		int suffix = this.armorType == 2 ? 2 : 1;

		return "awesomeMod:textures/models/armor/awesome_layer_" + suffix + ".png";
	}
	
	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return getUnlocalizedName() + "." + getArmorNameByType(armorType);
		// return getUnlocalizedName() + "." +
		// getArmorNameByType(this.armorType) + "." +
		// this.subNames[getColor(par1ItemStack)];
	}

}
