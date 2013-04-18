package fuj1n.awesomeMod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderAwesomeOre implements ISimpleBlockRenderingHandler{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
        Tessellator tessellator = Tessellator.instance;
        if(modelID == ClientProxyModJam.awesomeOreRenderType)
        {              
                block.setBlockBoundsForItemRender();
                GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
                float var7 = 0.0F;
                tessellator.startDrawingQuads();
                tessellator.setNormal(0F, +1.0F, 0F);
                renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
                renderer.renderTopFace(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(1));
                renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
                renderer.renderTopFace(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 1, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0F, -1.0F, 0F);
                renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
                renderer.renderBottomFace(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(0));
                renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
                renderer.renderBottomFace(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 0, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(-1.0F, 0F, 0F);
                renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
                renderer.renderNorthFace(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(2));
                renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
                renderer.renderNorthFace(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 2, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0F, 0F, -1.0F);
                renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
                renderer.renderEastFace(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(3));
                renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
                renderer.renderEastFace(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 3, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(+1.0F, 0F, 0F);
                renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
                renderer.renderSouthFace(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(4));
                renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
                renderer.renderSouthFace(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 4, metadata));
                tessellator.draw();
                tessellator.startDrawingQuads();
                tessellator.setNormal(0F, 0F, +1.0F);
                renderer.setRenderBounds(0.0001, 0.0001, 0.0001, 0.9999, 0.9999, 0.9999);
                renderer.renderWestFace(Block.stone, 0.0D, 0.0D, 0.0D, Block.stone.getBlockTextureFromSide(5));
                renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
                renderer.renderWestFace(block, 0.0D, 0.0D, 0.0D, renderer.getBlockIconFromSideAndMetadata(block, 5, metadata));
                tessellator.draw();
                GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        }
}       

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		BlockAwesomeOre handlerBlock = (BlockAwesomeOre)block;
		ClientProxyModJam.awesomeOreRenderStage = 0;
		renderer.setRenderBounds(0.001, 0.001, 0.001, 0.999, 0.999, 0.999);
		renderer.setOverrideBlockTexture(handlerBlock.belowBlock.getBlockTextureFromSide(0));
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.awesomeOreRenderStage = 1;
		renderer.setRenderBounds(0, 0, 0, 1, 1, 1);
		renderer.clearOverrideBlockTexture();
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.awesomeOreRenderStage = 0;
		renderer.clearOverrideBlockTexture();
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return ClientProxyModJam.awesomeOreRenderType;
	}

}
