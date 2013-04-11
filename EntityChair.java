package modJam;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityChair extends Entity{

	public EntityChair(World par1World, int posX, int posY, int posZ) {
		super(par1World);
		this.setPosition(posX - 0.5, posY - 0.5, posZ - 0.5);
	}

	@Override
	protected void entityInit() {
		// TODO 
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		// TODO
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		// TODO 
		
	}

}
