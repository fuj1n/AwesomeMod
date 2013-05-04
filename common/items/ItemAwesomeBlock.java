package fuj1n.awesomeMod.common.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import fuj1n.awesomeMod.common.blocks.BlockAwesome;

public class ItemAwesomeBlock extends ItemBlock {

	private static final String[] subNames = { "white", "orange", "magenta", "lBlue", "yellow", "lime", "pink", "gray", "lGray", "cyan", "purple", "blue", "brown", "green", "red", "black" };

	public ItemAwesomeBlock(int par1) {
		super(par1);
		this.setHasSubtypes(true);
	}

	/**
	 * allows items to add custom lines of information to the mouseover
	 * description
	 */
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		BlockAwesome handlerBlock = (BlockAwesome) Block.blocksList[this.getBlockID()];
		if (handlerBlock.blockInfo != null) {
			par3List.addAll(handlerBlock.blockInfo);
		}
	}

	/**
	 * Returns the metadata of the block which this Item (ItemBlock) can place
	 */
	@Override
	public int getMetadata(int par1) {
		return par1;
	}

	@Override
	public String getUnlocalizedName(ItemStack par1ItemStack) {
		return getUnlocalizedName() + "." + subNames[par1ItemStack.getItemDamage()];
	}

}
