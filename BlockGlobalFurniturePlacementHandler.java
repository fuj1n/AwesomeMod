package modJam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public abstract class BlockGlobalFurniturePlacementHandler extends Block{
	
	public BlockGlobalFurniturePlacementHandler(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	public abstract boolean isBlockInLocalPlacementWhiteList(World par1World, int par2, int par3, int par4);
	
	public boolean isBlockInGlobalPlacementWhiteList(World par1World, int par2, int par3, int par4){
		int var1 = par1World.getBlockId(par2, par3 - 1, par4);
		if(isBlockInLocalPlacementWhiteList(par1World, par2, par3, par4)){
			return true;
		}
		return var1 == Block.glass.blockID || var1 == Block.ice.blockID || var1 == Block.mobSpawner.blockID || var1 == ModJam.awesomeOre.blockID || var1 == ModJam.woodTable.blockID || var1 == ModJam.stoneTable.blockID || var1 == ModJam.awesomeBlock.blockID || var1 == ModJam.awesomeBlockStandard.blockID;
	}
	
	public boolean testPlacement(World par1World, int par2, int par3, int par4){
		return par1World.doesBlockHaveSolidTopSurface(par2, par3 - 1, par4) || isBlockInGlobalPlacementWhiteList(par1World, par2, par3, par4);
	}
	
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
	@Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return testPlacement(par1World, par2, par3, par4);
    }
	
    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
	@Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4)
    {
        return testPlacement(par1World, par2, par3, par4);
    }
	
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5) {
    	if(!canBlockStay(par1World, par2, par3, par4)){
    		Block.blocksList[par1World.getBlockId(par2, par3, par4)].dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
    		par1World.setBlockToAir(par2, par3, par4);
    	}
    }
	
    /**
     * Returns the mobility information of the block, 0 = free, 1 = can't push but can move over, 2 = total immobility
     * and stop pistons
     */
    public int getMobilityFlag()
    {
        return 0;
    }
}
