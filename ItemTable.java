package modJam;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ItemTable extends ItemBlock{

	private Icon[] tableOverlay = new Icon[16];
	
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
     * Returns 0 for /terrain.png, 1 for /gui/items.png
     */
	@Override
    public int getSpriteNumber()
    {
        return 1;
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
    
	@Override
	public boolean requiresMultipleRenderPasses(){
		return true;
	}
    
    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @Override
    public Icon getIconFromDamageForRenderPass(int par1, int par2)
    {
    	if(par2 == 0)
    		return this.iconIndex;
    	else if(par2 == 1){
    		return this.tableOverlay[par1];
    	}else{
    		return this.iconIndex;
    	}
    }
    
    public void updateIcons(IconRegister par1IconRegister){
    	int tableType = this.getBlockID() == ModJam.woodTable.blockID ? 0 : 1;
    	switch(tableType){
    	case 0:
    		this.iconIndex = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.tableWood");
    		break;
    	case 1:
    		this.iconIndex = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.tableStone");
    		break;
    	default:
    		this.iconIndex = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.tableWood");
    		break;
    	}
    	this.tableOverlay[0] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableWhite");
    	this.tableOverlay[1] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableOrange");
    	this.tableOverlay[2] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableMagenta");
    	this.tableOverlay[3] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableLBlue");
    	this.tableOverlay[4] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableYellow");
    	this.tableOverlay[5] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableLime");
    	this.tableOverlay[6] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTablePink");
    	this.tableOverlay[7] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableGray");
    	this.tableOverlay[8] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableLGray");
    	this.tableOverlay[9] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableCyan");
    	this.tableOverlay[10] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTablePurple");
    	this.tableOverlay[11] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableBlue");
    	this.tableOverlay[12] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableBrown");
    	this.tableOverlay[13] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableGreen");
    	this.tableOverlay[14] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableRed");
    	this.tableOverlay[15] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.overlayTableBlack");
    }

}
