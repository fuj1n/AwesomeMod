package fuj1n.awesomeMod.common.blocks;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import fuj1n.awesomeMod.client.ClientProxyModJam;

public class BlockAwesome extends Block {

	private Icon bottomBlock;
	private Icon[] blockColors = new Icon[16];

	public Collection blockInfo = new ArrayList();

	public String blockType;

	public BlockAwesome(int par1, String par2String) {
		super(par1, Material.iron);
		blockType = par2String;
		this.setLightOpacity(15);
	}

	@Override
	public Icon getIcon(int par1, int par2) {
		if (!blockType.equals("none")) {
			return blockColors[par2];
		} else {
			return bottomBlock;
		}
	}

	@Override
    public boolean isBlockSolidOnSide(World world, int x, int y, int z, ForgeDirection side){
        return true;
    }
	
	public Icon getUnderlyingTexture(int par1, int par2) {
		return bottomBlock;
	}

	/**
	 * Determines if a torch can be placed on the top surface of this block.
	 * Useful for creating your own block that torches can be on, such as
	 * fences.
	 * 
	 * @param world
	 *            The current world
	 * @param x
	 *            X Position
	 * @param y
	 *            Y Position
	 * @param z
	 *            Z Position
	 * @return True to allow the torch to be placed
	 */
	@Override
	public boolean canPlaceTorchOnTop(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
		if (!blockType.equals("none")) {
			return ClientProxyModJam.awesomeBlockRenderType;
		} else {
			return 0;
		}
	}

	public Block addAdditionalInfo(String s) {
		blockInfo.add(s);
		return this;
	}

	@Override
	public int getLightValue(IBlockAccess world, int x, int y, int z) {
		if (ClientProxyModJam.awesomeBlockRenderStage == 0) {
			Block block = blocksList[world.getBlockId(x, y, z)];
			if (block != null && block != this) {
				return block.getLightValue(world, x, y, z);
			}
			return lightValue[blockID];
		} else {
			return 15;
		}
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood
	 * returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		if (!blockType.equals("none")) {
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
	public int damageDropped(int par1) {
		return par1;
	}

	/**
	 * When this method is called, your block should register all the icons it
	 * needs with the given IconRegister. This is the only chance you get to
	 * register icons.
	 */
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		if (!blockType.equals("none")) {
			blockColors[0] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".white");
			blockColors[1] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".orange");
			blockColors[2] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".magenta");
			blockColors[3] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".LBlue");
			blockColors[4] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".yellow");
			blockColors[5] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".lime");
			blockColors[6] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".pink");
			blockColors[7] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".gray");
			blockColors[8] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".LGray");
			blockColors[9] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".cyan");
			blockColors[10] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".purple");
			blockColors[11] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".blue");
			blockColors[12] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".brown");
			blockColors[13] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".green");
			blockColors[14] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".red");
			blockColors[15] = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock." + blockType + ".black");
		}
		bottomBlock = par1IconRegister.registerIcon("awesomeMod:fuj1n.AwesomeMod.awesomeBlock");
	}

}
