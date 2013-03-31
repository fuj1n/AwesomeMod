package modJam;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ForgeDirection;

public class BlockChair extends Block{

	public ForgeDirection face;
	public Block belowBlock;
	
	public BlockChair(int par1, ForgeDirection face, Block belowBlock) {
		super(par1, Material.wood);
		this.setBlockBounds(0.25F, 0F, 0.25F, 0.75F, 1.4F, 0.75F);
		this.face = face;
		this.belowBlock = belowBlock;
	}
	
	@Override
	public boolean renderAsNormalBlock(){	
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return false;
	}

}
