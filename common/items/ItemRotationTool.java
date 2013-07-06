package fuj1n.awesomeMod.common.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import fuj1n.awesomeMod.common.blocks.INeonRotatable;

public class ItemRotationTool extends Item {

	public ItemRotationTool(int par1) {
		super(par1);
		this.setMaxDamage(250);
	}

	@Override
	public int getItemStackLimit() {
		return 1;
	}

    public boolean getShareTag()
    {
        return true;
    }
	
	@Override
	public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2) {
		ItemEnchantedBook handlerItem = null;
		if (itemstack2.itemID == Item.enchantedBook.itemID) {
			handlerItem = (ItemEnchantedBook) Item.itemsList[itemstack2.itemID];
			NBTTagList nbttaglist = handlerItem.func_92110_g(itemstack2);

			if (nbttaglist != null) {
				if (nbttaglist.tagCount() == 1) {
					short short1 = ((NBTTagCompound) nbttaglist.tagAt(0)).getShort("id");
					if (short1 == 34) {
						return true;
					}
				}
			}
		}
		return false;
	}

	
	
	/**
	 * Callback for item usage. If the item does something special on right
	 * clicking, he will have one of those. Return True if something happen and
	 * false if it don't. This is for ITEMS, not BLOCKS
	 */
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		Block currentBlock = !par3World.isAirBlock(par4, par5, par6) ? Block.blocksList[par3World.getBlockId(par4, par5, par6)] : null;
		boolean wasSuccessful = false;
		
		if(currentBlock instanceof INeonRotatable.IAlwaysSuccessful){
			if(par1ItemStack != null && par2EntityPlayer != null){
				par1ItemStack.damageItem(2, par2EntityPlayer);
			}
		}
		
		if(currentBlock instanceof INeonRotatable){
			if(par2EntityPlayer.isSneaking()){
				wasSuccessful = true;
				destroyBlock(currentBlock, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
			}else{
				wasSuccessful = ((INeonRotatable)currentBlock).handleRotation(par3World, par4, par5, par6, par2EntityPlayer);
			}
		}else if(currentBlock instanceof INeonRotatable.IRotatorBreakable){
			if(par2EntityPlayer.isSneaking()){
				wasSuccessful = true;
				destroyBlock(currentBlock, par2EntityPlayer, par3World, par4, par5, par6, par7, par8, par9, par10);
			}
		}
		if (wasSuccessful && !(currentBlock instanceof INeonRotatable.IAlwaysSuccessful)) {
			if(par1ItemStack != null && par2EntityPlayer != null){
				par1ItemStack.damageItem(2, par2EntityPlayer);
				return true;
			}
		}
		
		return currentBlock instanceof INeonRotatable.IAlwaysSuccessful;
	}

	public void destroyBlock(Block par1Block, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10){
		par1Block.dropBlockAsItem(par3World, par4, par5, par6, par3World.getBlockMetadata(par4, par5, par6), 0);
		par1Block.onBlockDestroyedByPlayer(par3World, par4, par5, par6, par3World.getBlockMetadata(par4, par5, par6));
		par3World.setBlockToAir(par4, par5, par6);
		par1Block.breakBlock(par3World, par4, par5, par6, par1Block.blockID, par3World.getBlockMetadata(par4, par5, par6));
	}
	
	@Override
	/**
	 * returns the action that specifies what animation to play when the items is being used
	 */
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		itemIcon = par1IconRegister.registerIcon("AwesomeMod:fuj1n.AwesomeMod.rotationTool");
	}

}
