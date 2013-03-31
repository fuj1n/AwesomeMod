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
		BlockChair handlerBlock = (BlockChair)block;
		ClientProxyModJam.chairRenderStage = 0;
		renderer.setRenderBounds(0.251, 0.001, 0.251, 0.349, 0.599, 0.349);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.chairRenderStage = 1;
		renderer.setRenderBounds(0.25, 0.0, 0.25, 0.35, 0.6, 0.35);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.chairRenderStage = 0;
		renderer.setRenderBounds(0.651, 0.001, 0.251, 0.749, 0.599, 0.349);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.chairRenderStage = 1;
		renderer.setRenderBounds(0.65, 0.0, 0.25, 0.75, 0.6, 0.35);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.chairRenderStage = 0;
		renderer.setRenderBounds(0.251, 0.001, 0.651, 0.349, 0.599, 0.749);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.chairRenderStage = 1;
		renderer.setRenderBounds(0.25, 0.0, 0.65, 0.35, 0.6, 0.75);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.chairRenderStage = 0;
		renderer.setRenderBounds(0.651, 0.001, 0.651, 0.749, 0.599, 0.749);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.chairRenderStage = 1;
		renderer.setRenderBounds(0.65, 0.0, 0.65, 0.75, 0.6, 0.75);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.chairRenderStage = 0;
		renderer.setRenderBounds(0.251, 0.601, 0.251, 0.749, 0.699, 0.749);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.chairRenderStage = 1;
		renderer.setRenderBounds(0.25, 0.6, 0.25, 0.75, 0.7, 0.75);
		renderer.renderStandardBlock(block, x, y, z);
		renderChairBasedOnSide(world, x, y, z, block, modelId, renderer);
		ClientProxyModJam.chairRenderStage = 0;
		return true;
	}
	
	public void renderChairBasedOnSide(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer){
		BlockChair handlerBlock = (BlockChair)block;
		ForgeDirection face = handlerBlock.face;
		if(face == ForgeDirection.NORTH){
			ClientProxyModJam.chairRenderStage = 0;
			renderer.setRenderBounds(0.251, 0.701, 0.651, 0.749, 1.399, 0.749);
			renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);	
			ClientProxyModJam.chairRenderStage = 1;
			renderer.setRenderBounds(0.25, 0.7, 0.65, 0.75, 1.4, 0.75);
			renderer.renderStandardBlock(block, x, y, z);	
		}else if(face == ForgeDirection.SOUTH){
			ClientProxyModJam.chairRenderStage = 0;
			renderer.setRenderBounds(0.251, 0.701, 0.251, 0.749, 1.399, 0.349);
			renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
			ClientProxyModJam.chairRenderStage = 1;
			renderer.setRenderBounds(0.25, 0.7, 0.25, 0.75, 1.4, 0.35);
			renderer.renderStandardBlock(block, x, y, z);
		}else if(face == ForgeDirection.EAST){
			ClientProxyModJam.chairRenderStage = 0;
			renderer.setRenderBounds(0.251, 0.701, 0.251, 0.349, 1.399, 0.749);
			renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);	
			ClientProxyModJam.chairRenderStage = 1;
			renderer.setRenderBounds(0.25, 0.7, 0.25, 0.35, 1.4, 0.75);
			renderer.renderStandardBlock(block, x, y, z);	
		}else if(face == ForgeDirection.WEST){
			ClientProxyModJam.chairRenderStage = 0;
			renderer.setRenderBounds(0.651, 0.701, 0.251, 0.749, 1.399, 0.749);
			renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
			ClientProxyModJam.chairRenderStage = 1;
			renderer.setRenderBounds(0.65, 0.7, 0.25, 0.75, 1.4, 0.75);
			renderer.renderStandardBlock(block, x, y, z);
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
