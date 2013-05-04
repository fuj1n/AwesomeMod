package fuj1n.awesomeMod.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderChair implements IItemRenderer {

	private Block block;
	private Block belowBlock;

	public ItemRenderChair(Block block, Block belowBlock) {
		this.block = block;
		this.belowBlock = belowBlock;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type != ItemRenderType.FIRST_PERSON_MAP;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (helper) {
		case BLOCK_3D:
			return true;
		case ENTITY_BOBBING:
			return true;
		case ENTITY_ROTATION:
			return true;
		case EQUIPPED_BLOCK:
			return true;
		case INVENTORY_BLOCK:
			return true;
		default:
			return false;
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		RenderBlocks renderer = Minecraft.getMinecraft().renderGlobal.globalRenderBlocks;
		Tessellator tessellator = Tessellator.instance;
		switch (type) {
		case ENTITY:
			GL11.glScalef(0.5F, 0.5F, 0.5F);
			GL11.glTranslatef(-0.5F, 0F, -0.5F);
			break;
		case INVENTORY:
			GL11.glTranslatef(0F, -0.3F, 0F);
		default:
			break;
		}
		tessellator.startDrawingQuads();
		tessellator.setNormal(-1F, 0F, 0F);
		renderer.setRenderBounds(0.251, 0.001, 0.251, 0.349, 0.599, 0.349);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.0, 0.25, 0.35, 0.6, 0.35);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		/** Render back **/
		renderer.setRenderBounds(0.251, 0.701, 0.251, 0.749, 1.399, 0.349);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.7, 0.25, 0.75, 1.4, 0.35);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		/** End render back **/
		renderer.setRenderBounds(0.651, 0.001, 0.251, 0.749, 0.599, 0.349);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.65, 0.0, 0.25, 0.75, 0.6, 0.35);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(+1F, 0F, 0F);
		renderer.setRenderBounds(0.251, 0.001, 0.651, 0.349, 0.599, 0.749);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.0, 0.65, 0.35, 0.6, 0.75);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.setRenderBounds(0.651, 0.001, 0.651, 0.749, 0.599, 0.749);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.65, 0.0, 0.65, 0.75, 0.6, 0.75);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, +1F, 0F);
		renderer.setRenderBounds(0.251, 0.601, 0.251, 0.749, 0.699, 0.749);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.6, 0.25, 0.75, 0.7, 0.75);
		renderer.renderFaceZNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceZPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceXNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYPos(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		renderer.renderFaceYNeg(block, 0D, 0D, 0D, block.getIcon(0, item.getItemDamage()));
		tessellator.draw();
		switch (type) {
		case ENTITY:
			GL11.glTranslatef(+0.5F, 0F, +0.5F);
			break;
		case INVENTORY:
			GL11.glTranslatef(0F, +0.3F, 0F);
		default:
			break;
		}
	}

}
