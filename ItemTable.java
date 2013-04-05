package modJam;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemTable extends ItemBlock{
	
	private static final String[] subNames = { 
		"white", "orange", "magenta",
		"lBlue", "yellow", "lime", "pink", "gray", "lGray", "cyan",
		"purple", "blue", "brown", "green", "red", "black"
	};
	
	public ItemTable(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}
	
    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack){
    	return getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage()];
    }

}
