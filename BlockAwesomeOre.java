package modJam;

import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.IBlockAccess;

public class BlockAwesomeOre extends BlockOre{

	public BlockAwesomeOre(int par1) {
		super(par1);
		this.setCreativeTab(ModJam.modJamCreativeTab);
	}
	
	@Override
	public boolean renderAsNormalBlock(){
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(){
		return true;
	}
	
	@Override
	public int getRenderType(){
		return ClientProxyModJam.awesomeOreRenderType;
	}
	
	@Override
    public int getLightValue(IBlockAccess world, int x, int y, int z)
    {
        if(ClientProxyModJam.awesomeOreRenderStage == 0){
        	return 0;
        }else{
        	return 15;
        }
    }
	
    /**
     * When this method is called, your block should register all the icons it needs with the given IconRegister. This
     * is the only chance you get to register icons.
     */
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeOre");
    }

}
