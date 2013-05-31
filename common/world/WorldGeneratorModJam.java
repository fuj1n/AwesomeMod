package fuj1n.awesomeMod.common.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
import fuj1n.awesomeMod.ModJam;

public class WorldGeneratorModJam implements IWorldGenerator {
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
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

	public void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int meta = 0; meta < 16; meta++) {
			for (int i = 0; i < 1; i++) {
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				// ModJam.log(awesomeColors[meta] + "generated at: " + xCoord +
				// " " + yCoord + " " + zCoord, Level.INFO);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.stone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
		if (random.nextInt(50) == 1 && world.getWorldInfo().isMapFeaturesEnabled()) {
			int y1 = random.nextInt(12);
			int y2 = 45;
			int y = y1 + y2;
			new WorldGenAwesomeRoom().generate(world, random, chunkX + 6, y, chunkZ + 6);
		}
	}

	public void generateNether(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int meta = 0; meta < 15; meta++) {
			for (int i = 0; i < 1; i++) {
				if (world.rand.nextInt(2) == 1) {
					int xCoord = chunkX + random.nextInt(16);
					int yCoord = random.nextInt(50);
					int zCoord = chunkZ + random.nextInt(16);
					(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.netherrack.blockID)).generate(world, random, xCoord, yCoord, zCoord);
				}
			}
		}
	}

	public void generateEnd(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int meta = 0; meta < 15; meta++) {
			for (int i = 0; i < 10; i++) {
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.whiteStone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}

	public void generateMisc(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for (int meta = 0; meta < 15; meta++) {
			for (int i = 0; i < 2; i++) {
				int xCoord = chunkX + random.nextInt(16);
				int yCoord = random.nextInt(50);
				int zCoord = chunkZ + random.nextInt(16);
				(new WorldGenMinable(ModJam.oreAwesomeID, meta, 10, Block.stone.blockID)).generate(world, random, xCoord, yCoord, zCoord);
			}
		}
	}

}
