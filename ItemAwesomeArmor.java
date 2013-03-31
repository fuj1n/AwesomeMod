package modJam;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.ItemArmor;

public class ItemAwesomeArmor extends ItemArmor{

	private String texture;
	
	public ItemAwesomeArmor(int par1, EnumArmorMaterial par2EnumArmorMaterial, int par3, int par4, String tex) {
		super(par1, par2EnumArmorMaterial, par3, par4);
		texture = tex;
	}
	
	@Override
	public void updateIcons(IconRegister par1IconRegister){
		String type;
		switch (this.armorType){
		case 0:
			type = "Helmet";
			break;
		case 1:
			type = "Chestplate";
			break;
		case 2:
			type = "Leggings";
			break;
		case 3:
			type = "Boots";
			break;
		default:
			type = "Unknown";
			break;
		}
		this.iconIndex = par1IconRegister.registerIcon(this.texture + "." + type);
		
	}

}
