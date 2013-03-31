package modJam;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderChair implements ISimpleBlockRenderingHandler{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
		
		
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		renderer.setRenderBounds(0.251, 0.001, 0.251, 0.349, 0.599, 0.349);
		renderer.renderStandardBlock(Block.planks, x, y, z);
		renderer.setRenderBounds(0.651, 0.001, 0.251, 0.749, 0.599, 0.349);
		renderer.renderStandardBlock(Block.planks, x, y, z);
		renderer.setRenderBounds(0.251, 0.001, 0.651, 0.349, 0.599, 0.749);
		renderer.renderStandardBlock(Block.planks, x, y, z);
		renderer.setRenderBounds(0.651, 0.001, 0.651, 0.749, 0.599, 0.749);
		renderer.renderStandardBlock(Block.planks, x, y, z);
		renderer.setRenderBounds(0.251, 0.599, 0.251, 0.749, 0.699, 0.749);
		renderer.renderStandardBlock(Block.planks, x, y, z);
		renderChairBasedOnSide(world, x, y, z, block, modelId, renderer);
		return false;
	}
	
	public void renderChairBasedOnSide(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer){
		BlockChair handlerBlock = (BlockChair)block;
		ForgeDirection face = handlerBlock.face;
		if(face == ForgeDirection.NORTH){
			renderer.setRenderBounds(0.251, 0.699, 0.651, 0.749, 1.399, 0.749);
			renderer.renderStandardBlock(Block.planks, x, y, z);	
		}else if(face == ForgeDirection.SOUTH){
			renderer.setRenderBounds(0.251, 0.699, 0.251, 0.749, 1.399, 0.349);
			renderer.renderStandardBlock(Block.planks, x, y, z);
		}else if(face == ForgeDirection.EAST){
			renderer.setRenderBounds(0.251, 0.699, 0.251, 0.349, 1.399, 0.749);
			renderer.renderStandardBlock(Block.planks, x, y, z);	
		}else if(face == ForgeDirection.WEST){
			renderer.setRenderBounds(0.651, 0.699, 0.251, 0.749, 1.399, 0.749);
			renderer.renderStandardBlock(Block.planks, x, y, z);
		}
	}
	
	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxyModJam.chairRenderType;
	}

}
