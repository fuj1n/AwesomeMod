package modJam;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorModJam implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
			generateNether(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;
		case 0:
			generateOverworld(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;
		case 1:
			generateEnd(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;
		default:
			generateMisc(random, chunkX * 16, chunkZ * 16, world, chunkGenerator, chunkProvider);
			break;
		}
	}
	
	public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		for(int meta = 0; meta < 15; meta++){
			for(int i = 0; i < 5; i++){
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.stone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}
	
	public void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		for(int meta = 0; meta < 15; meta++){
			for(int i = 0; i < 1; i++){
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.stone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}
	
	public void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		for(int meta = 0; meta < 15; meta++){
			for(int i = 0; i < 10; i++){
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.stone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}
	
	public void generateMisc(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		for(int meta = 0; meta < 15; meta++){
			for(int i = 0; i < 2; i++){
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.stone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}
	

}
