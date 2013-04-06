package modJam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAwesome extends Block{

	private Icon bottomBlock;
	private Icon[] blockColors = new Icon[16];
	
	public Collection blockInfo = new ArrayList();
	
	public String blockType;
	
	public BlockAwesome(int par1, String par2String) {
		super(par1, Material.iron);
		blockType = par2String;
		this.setLightOpacity(15);
		this.setTickRandomly(true);
	}
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2){
		if(!blockType.equals("none")){
			return blockColors[par2];
		}else{
			return bottomBlock;
		}
	}
	
	public Icon getUnderlyingTexture(int par1, int par2){
		return bottomBlock;
	}
	
	@Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}
	
	@Override
	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random){
		par1World.updateAllLightTypes(par2, par3, par4);
		par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate(par1World));
	}
	
    /**
     * Determines if a torch can be placed on the top surface of this block.
     * Useful for creating your own block that torches can be on, such as fences.
     *
     * @param world The current world
     * @param x X Position
     * @param y Y Position
     * @param z Z Position
     * @return True to allow the torch to be placed
     */
    public boolean canPlaceTorchOnTop(World world, int x, int y, int z)
    {
        return true;
    }
	
	@Override
	public boolean renderAsNormalBlock(){
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}
	
	@Override
	public int getRenderType(){
		if(!blockType.equals("none")){
			return ClientProxyModJam.awesomeBlockRenderType;
		}else{
			return 0;
		}
	}
	
	public Block addAdditionalInfo(String s){
		blockInfo.add(s);
		return this;
	}
	
	@Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
		boolean[] map = getBlockSideMap(world, x, y, z);
		int[] brightnessMap = getBlockBrightnessMap(world, x, y, z);
		if(map[0] || map[1] || map[2] || map[3] || map[4] || map[5]){
			int brightestValue = 0;
			if(map[0] && brightnessMap[0] > brightestValue){
				brightestValue = brightnessMap[0];
			}if(map[1] && brightnessMap[1] > brightestValue){
				brightestValue = brightnessMap[1];
			}if(map[2] && brightnessMap[2] > brightestValue){
				brightestValue = brightnessMap[2];
			}if(map[3] && brightnessMap[3] > brightestValue){
				brightestValue = brightnessMap[3];
			}if(map[4] && brightnessMap[4] > brightestValue){
				brightestValue = brightnessMap[4];
			}if(map[5] && brightnessMap[5] > brightestValue){
				brightestValue = brightnessMap[5];
			}return brightestValue;
		}
        if(ClientProxyModJam.awesomeBlockRenderStage == 0){
            Block block = blocksList[world.getBlockId(x, y, z)];
            if (block != null && block != this)
            {
                return block.getLightValue(world, x, y, z);
            }
            return lightValue[blockID];
        }else{
        	return 15;
        }
    }
	
	public boolean isBlock(IBlockAccess par1World, int par2, int par3, int par4, int block){
		return par1World.getBlockId(par2, par3, par4) == block;
	}
	
	public int[] getBlockBrightnessMap(IBlockAccess par1World, int par2, int par3, int par4){
		int[] returnValue = new int[6];
		returnValue[0] = par1World.getBlockMetadata(par2, par3 - 1, par4);
		returnValue[1] = par1World.getBlockMetadata(par2, par3 + 1, par4);
		returnValue[2] = par1World.getBlockMetadata(par2 - 1, par3, par4);
		returnValue[3] = par1World.getBlockMetadata(par2 + 1, par3, par4);
		returnValue[4] = par1World.getBlockMetadata(par2, par3, par4 - 1);
		returnValue[5] = par1World.getBlockMetadata(par2, par3, par4 + 1);
		return returnValue;
	}
	
	public boolean[] getBlockSideMap(IBlockAccess par1World, int par2, int par3, int par4){
		boolean[] returnValue = new boolean[6];
		returnValue[0] = isBlock(par1World, par2, par3 - 1, par4, ModJam.lightGen.blockID);
		returnValue[1] = isBlock(par1World, par2, par3 + 1, par4, ModJam.lightGen.blockID);
		returnValue[2] = isBlock(par1World, par2 - 1, par3, par4, ModJam.lightGen.blockID);
		returnValue[3] = isBlock(par1World, par2 + 1, par3, par4, ModJam.lightGen.blockID);
		returnValue[4] = isBlock(par1World, par2, par3, par4 - 1, ModJam.lightGen.blockID);
		returnValue[5] = isBlock(par1World, par2, par3, par4 + 1, ModJam.lightGen.blockID);
		return returnValue;
	}
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
		if(!blockType.equals("none")){
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
    }
	
	@Override
	public int damageDropped(int par1){
		return par1;
	}
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
    	if(!blockType.equals("none")){
	    	this.blockColors[0] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".white");
	    	this.blockColors[1] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".orange");
	    	this.blockColors[2] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".magenta");
	    	this.blockColors[3] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".LBlue");
	    	this.blockColors[4] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".yellow");
	    	this.blockColors[5] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".lime");
	    	this.blockColors[6] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".pink");
	    	this.blockColors[7] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".gray");
	    	this.blockColors[8] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".LGray");
	    	this.blockColors[9] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".cyan");
	    	this.blockColors[10] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".purple");
	    	this.blockColors[11] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".blue");
	    	this.blockColors[12] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".brown");
	    	this.blockColors[13] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".green");
	    	this.blockColors[14] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".red");
	    	this.blockColors[15] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock."+ blockType +".black");
    	}
    	this.bottomBlock = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock");
    }

}
