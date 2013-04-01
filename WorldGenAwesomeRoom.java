package modJam;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenAwesomeRoom extends WorldGenerator{
	
	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		if(world.getBlockId(i, j, k) != 0){
			//ModJam.log("Generating room at: " + i + " " + j + " " + k, Level.INFO);
			for(int i1 = i; i1 < i + 5; i1++){
				for(int j1 = j; j1 < j + 5; j1++){
					world.setBlock(i1, j1, k, ModJam.awesomeBlock.blockID);
					world.setBlock(i1, j1, k + 4, ModJam.awesomeBlock.blockID);
				}
				for(int k1 = k; k1 < k + 5; k1++){
					world.setBlock(i1, j, k1, ModJam.awesomeBlock.blockID);
					world.setBlock(i1, j + 4, k1, ModJam.awesomeBlock.blockID);
				}
			}
			for(int k1 = k; k1 < k + 5; k1++){
				for(int j1 = j; j1 < j + 5; j1++){
					world.setBlock(i, j1, k1, ModJam.awesomeBlock.blockID);
					world.setBlock(i + 4, j1, k1, ModJam.awesomeBlock.blockID);
				}
			}
			world.setBlock(i + 2, j + 2, k, ModJam.awesomeBlockCreeper.blockID, 5, 2);
			world.setBlock(i + 2, j + 2, k + 4, ModJam.awesomeBlockCreeper.blockID, 5, 2);
			world.setBlock(i + 2, j + 4, k + 2, ModJam.awesomeBlockCreeper.blockID, 5, 2);
			world.setBlock(i + 2, j, k + 2, ModJam.awesomeBlockStandard.blockID, 5, 2);
			world.setBlock(i, j + 2, k + 2, ModJam.awesomeBlockStandard.blockID, 5, 2);
			world.setBlock(i + 4, j + 2, k + 2, ModJam.awesomeBlockStandard.blockID, 5, 2);
			genChestContents(world, random, i + 2, j + 1, k + 2);
			return true;
		}
		return false;
	}
	
	public void genChestContents(World world, Random random, int i, int j, int k){
		if(!ComponentChestContents.chestGen.isEmpty()){
			world.setBlock(i, j, k, Block.chest.blockID);
			TileEntityChest chest;
			if(world.getBlockTileEntity(i, j, k) != null){
				chest = (TileEntityChest) world.getBlockTileEntity(i, j, k);
			}else{
				chest = new TileEntityChest();
				world.setBlockTileEntity(i, j, k, chest);
			}
			int numOfItems = random.nextInt(9) + 1;
			for(int n = 0; n < numOfItems; n++){
				ItemStack item = ComponentChestContents.chestGen.get(random.nextInt(ComponentChestContents.chestGen.size()));
				int slot = random.nextInt(chest.getSizeInventory());
				while(chest.getStackInSlot(slot) != null){
					slot = random.nextInt(chest.getSizeInventory());
				}
				chest.setInventorySlotContents(slot, item);
			}
		}
		
	}

}
