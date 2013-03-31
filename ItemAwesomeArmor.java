package modJam;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ItemAwesomeArmor extends ItemArmor{

	private String texture;
	
	private static final String[] subNames = { 
		"white", "orange", "magenta",
		"lBlue", "yellow", "lime", "pink", "gray", "lGray", "cyan",
		"purple", "blue", "brown", "green", "red", "black"
	};
	
	public ItemAwesomeArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String tex) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(ModJam.modJamCreativeTab);
		texture = tex;
	}
	
	public void setItemColorIDToNBT(ItemStack par1ItemStack, int colorMeta){
		NBTTagCompound nbt;
		if(par1ItemStack.getTagCompound() != null){
		nbt = par1ItemStack.getTagCompound();
		}else{
			nbt = new NBTTagCompound();
		}
        
        nbt.setByte("Color", (byte)colorMeta);
        par1ItemStack.setTagCompound(nbt);
	}
	
	public int getItemColorIDBasedOnNBT(ItemStack par1ItemStack){
		if(par1ItemStack.getTagCompound() != null){
			NBTTagCompound nbt = par1ItemStack.getTagCompound();
			if(nbt.hasKey("Color")){
				return nbt.getByte("Color");
			}
		}
		return 0;
	}
	
	public String getArmorNameByType(int type){
		String typeStr;
		switch (this.armorType){
		case 0:
			typeStr = "Helmet";
			break;
		case 1:
			typeStr = "Chestplate";
			break;
		case 2:
			typeStr = "Leggings";
			break;
		case 3:
			typeStr = "Boots";
			break;
		default:
			typeStr = "Unknown";
			break;
		}
		return typeStr;
	}
	
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
	@Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
		ItemStack var1 = new ItemStack(par1, 1, 0);
		for(int i = 0; i < 15; i++){
			setItemColorIDToNBT(var1, i);
			par3List.add(var1);
		}
    }
	
	@Override
	public void updateIcons(IconRegister par1IconRegister){
		String type = getArmorNameByType(this.armorType);
		this.iconIndex = par1IconRegister.registerIcon(this.texture + "." + type);
		
	}
	
	   @Override
	    public String getUnlocalizedName(ItemStack par1ItemStack){
	    	return getUnlocalizedName() + "." + getArmorNameByType(this.armorType) + "." + this.subNames[getItemColorIDBasedOnNBT(par1ItemStack)];
	    }

}
