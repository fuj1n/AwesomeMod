package fuj1n.awesomeMod.common.blocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import fuj1n.awesomeMod.ModJam;

public interface INeonRotatable {

	public abstract boolean handleRotation(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer);
	
}
