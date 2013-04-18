package fuj1n.awesomeMod.common.blocks;

import java.util.List;
import java.util.Random;

import javax.jws.Oneway;

import fuj1n.awesomeMod.ModJam;
import fuj1n.awesomeMod.client.ClientProxyModJam;
import fuj1n.awesomeMod.common.entity.EntityChair;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockChair extends BlockGlobalFurniturePlacementHandler{

	private Icon[] blockColors = new Icon[16];
	
	public ForgeDirection face;
	public Block belowBlock;
	public int itemID;
	
	public BlockChair(int par1, ForgeDirection face, Block belowBlock, int itemID) {
		super(par1);
		this.setStepSound(belowBlock.stepSound);
		this.setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 1.4F, 0.75F);
		this.face = face;
		this.belowBlock = belowBlock;
		this.itemID = itemID;
	}
	@Override
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
    	if(par5EntityPlayer.getHeldItem() != null && par5EntityPlayer.getHeldItem().itemID == ModJam.rotationTool.itemID){
    		return false;
    	}
    	List<Entity> entities = par1World.getEntitiesWithinAABB(EntityChair.class, this.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4));
    	if(entities.size() > 0){
    		EntityChair chair = (EntityChair)entities.get(0);
    		chair.mountAct(par5EntityPlayer);
    		return true;
    	}
        return false;
    }
	
    /**
     * Called when a user uses the creative pick block button on this block
     *
     * @param target The full target the player is looking at
     * @return A ItemStack to add to the player's inventory, Null if nothing should be added.
     */
    public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z)
    {
    	int blockID = world.getBlockId(x, y, z);
    	int blockMeta = world.getBlockMetadata(x, y, z);
    	for(int i = 0; i < ModJam.woodChairIDs.length; i++){
    		if(blockID == ModJam.woodChairIDs[i]){
    			return new ItemStack(ModJam.woodChair.itemID, 1, blockMeta);
    		}
    	}
    	for(int i = 0; i < ModJam.stoneChairIDs.length; i++){
    		if(blockID == ModJam.stoneChairIDs[i]){
    			return new ItemStack(ModJam.stoneChair.itemID, 1, blockMeta);
    		}
    	}
        return null;
    }
    
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
    	if(par1World.getEntitiesWithinAABB(EntityChair.class, this.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4)).size() > 0){
        	Entity ent = (Entity) par1World.getEntitiesWithinAABB(EntityChair.class, this.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4)).get(0);
    		ent.setDead();
    	}
    }
	
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
    	int idThis = par1World.getBlockId(par2, par3, par4);
    	int blockFace = idThis == ModJam.woodChairNorth.blockID || idThis == ModJam.stoneChairSouth.blockID ? 2 : idThis == ModJam.woodChairEast.blockID || idThis == ModJam.stoneChairEast.blockID ? 3 : idThis == ModJam.woodChairSouth.blockID || idThis == ModJam.stoneChairSouth.blockID ? 0 : idThis == ModJam.woodChairWest.blockID || idThis == ModJam.stoneChairWest.blockID ? 1 : 4;
    	EntityChair chairMountEntity = new EntityChair(par1World, par2, par3, par4, blockFace);
    	if(par1World.getEntitiesWithinAABB(EntityChair.class, this.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4)).size() == 0){
    		par1World.spawnEntityInWorld(chairMountEntity);
    	}
    }
    
	public boolean isBlockInLocalPlacementWhiteList(World par1World, int par2, int par3, int par4){
		return false;
	}
	
	@Override
	public Icon getBlockTextureFromSideAndMetadata(int par1, int par2){
		return blockColors[par2];
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
		return ClientProxyModJam.chairRenderType;
	}
	
    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return AxisAlignedBB.getAABBPool().getAABB(0.25F, 0F, 0.25F, 0.75F, 1.0F, 0.75F);
    }
	
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
	@Override
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List){}
	
	@Override
	public int damageDropped(int par1){
		return par1;
	}
	
    /**
     * Returns the ID of the items to drop on destruction.
     */
	@Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.itemID;
    }
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
		return true;
	}
	
	public static boolean handleRotation(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer){
		int currentBlock = par1World.getBlockId(par2, par3, par4);
		int nextBlock = currentBlock + 1;
    	int meta = par1World.getBlockMetadata(par2, par3, par4);
    	
    	for(int i = 0; i < ModJam.woodChairIDs.length; i++){
    		if(currentBlock == ModJam.woodChairIDs[i]){
    			if(nextBlock > ModJam.woodChairIDs[3]){
    				nextBlock = ModJam.woodChairIDs[0];
    			}
    		}
    	}
    	
    	for(int i = 0; i < ModJam.stoneChairIDs.length; i++){
    		if(currentBlock == ModJam.stoneChairIDs[i]){
    			if(nextBlock > ModJam.stoneChairIDs[3]){
    				nextBlock = ModJam.stoneChairIDs[0];
    			}
    		}
    	}
    	Block.blocksList[currentBlock].onBlockDestroyedByPlayer(par1World, par2, par3, par4, 0);
    	par1World.setBlock(par2, par3, par4, nextBlock, meta, 2);
    	Block.blocksList[nextBlock].onBlockAdded(par1World, par2, par3, par4);
    	return true;
	}
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
    	this.blockColors[0] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreWhite");
    	this.blockColors[1] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreOrange");
    	this.blockColors[2] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreMagenta");
    	this.blockColors[3] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreLBlue");
    	this.blockColors[4] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreYellow");
    	this.blockColors[5] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreLime");
    	this.blockColors[6] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOrePink");
    	this.blockColors[7] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreGray");
    	this.blockColors[8] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreLGray");
    	this.blockColors[9] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreCyan");
    	this.blockColors[10] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOrePurple");
    	this.blockColors[11] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreBlue");
    	this.blockColors[12] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreBrown");
    	this.blockColors[13] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreGreen");
    	this.blockColors[14] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreRed");
    	this.blockColors[15] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOreBlack");
    }
}
