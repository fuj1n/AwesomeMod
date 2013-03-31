package modJam;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderTable implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID,
			RenderBlocks renderer) {
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		BlockTable handlerBlock = (BlockTable)block;
		ClientProxyModJam.tableRenderStage = 0;
		renderer.setRenderBounds(0.001, 0.001, 0.001, 0.099, 0.899, 0.099);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.tableRenderStage = 1;
		renderer.setRenderBounds(0.0, 0.0, 0.0, 0.1, 0.9, 0.1);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.tableRenderStage = 0;
		renderer.setRenderBounds(0.901, 0.001, 0.001, 0.999, 0.899, 0.099);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.tableRenderStage = 1;
		renderer.setRenderBounds(0.9, 0.0, 0.0, 1.0, 0.9, 0.1);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.tableRenderStage = 0;
		renderer.setRenderBounds(0.001, 0.001, 0.901, 0.099, 0.899, 0.999);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.tableRenderStage = 1;
		renderer.setRenderBounds(0.0, 0.0, 0.9, 0.1, 0.9, 1.0);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.tableRenderStage = 0;
		renderer.setRenderBounds(0.901, 0.001, 0.901, 0.999, 0.899, 0.999);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.tableRenderStage = 1;
		renderer.setRenderBounds(0.9, 0.0, 0.9, 1.0, 0.9, 1.0);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.tableRenderStage = 0;
		renderer.setRenderBounds(0.001, 0.899, 0.001, 0.999, 0.999, 0.999);
		renderer.renderStandardBlock(handlerBlock.belowBlock, x, y, z);
		ClientProxyModJam.tableRenderStage = 1;
		renderer.setRenderBounds(0.0, 0.9, 0.0, 1.0, 1.0, 1.0);
		renderer.renderStandardBlock(block, x, y, z);
		ClientProxyModJam.tableRenderStage = 0;
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return false;
	}

	@Override
	public int getRenderId() {
		return ClientProxyModJam.tableRenderType;
	}

}
