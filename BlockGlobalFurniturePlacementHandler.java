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
		return var1 == Block.glass.blockID || var1 == Block.mobSpawner.blockID || var1 == ModJam.awesomeOre.blockID || var1 == ModJam.woodTable.blockID || var1 == ModJam.stoneTable.blockID;
	}
}
