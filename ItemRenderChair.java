package fuj1n.awesomeMod;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.ForgeHooks;

public class ItemRenderChair implements IItemRenderer {

	private Block block;
	private Block belowBlock;
	
	public ItemRenderChair(Block block, Block belowBlock){
		this.block = block;
		this.belowBlock = belowBlock;
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type != type.FIRST_PERSON_MAP;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		switch(helper){
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
		BlockChair handlerBlock = (BlockChair)block;
		Tessellator tessellator = Tessellator.instance;
		switch(type){
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
		renderer.renderNorthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderEastFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderSouthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderWestFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderTopFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderBottomFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.0, 0.25, 0.35, 0.6, 0.35);
		renderer.renderNorthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderEastFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderSouthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderWestFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderTopFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderBottomFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		/** Render back **/
		renderer.setRenderBounds(0.251, 0.701, 0.251, 0.749, 1.399, 0.349);
		renderer.renderNorthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderEastFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderSouthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderWestFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderTopFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderBottomFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.7, 0.25, 0.75, 1.4, 0.35);
		renderer.renderNorthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderEastFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderSouthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderWestFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderTopFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderBottomFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		/** End render back **/
		renderer.setRenderBounds(0.651, 0.001, 0.251, 0.749, 0.599, 0.349);
		renderer.renderNorthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderEastFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderSouthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderWestFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderTopFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderBottomFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.65, 0.0, 0.25, 0.75, 0.6, 0.35);
		renderer.renderNorthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderEastFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderSouthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderWestFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderTopFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderBottomFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(+1F, 0F, 0F);
		renderer.setRenderBounds(0.251, 0.001, 0.651, 0.349, 0.599, 0.749);
		renderer.renderNorthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderEastFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderSouthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderWestFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderTopFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderBottomFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.0, 0.65, 0.35, 0.6, 0.75);
		renderer.renderNorthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderEastFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderSouthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderWestFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderTopFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderBottomFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.setRenderBounds(0.651, 0.001, 0.651, 0.749, 0.599, 0.749);
		renderer.renderNorthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderEastFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderSouthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderWestFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderTopFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderBottomFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.65, 0.0, 0.65, 0.75, 0.6, 0.75);
		renderer.renderNorthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderEastFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderSouthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderWestFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderTopFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderBottomFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		tessellator.draw();
		tessellator.startDrawingQuads();
		tessellator.setNormal(0F, +1F, 0F);
		renderer.setRenderBounds(0.251, 0.601, 0.251, 0.749, 0.699, 0.749);
		renderer.renderNorthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderEastFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderSouthFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderWestFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderTopFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.renderBottomFace(block, 0D, 0D, 0D, belowBlock.getBlockTextureFromSide(0));
		renderer.setRenderBounds(0.25, 0.6, 0.25, 0.75, 0.7, 0.75);
		renderer.renderNorthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderEastFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderSouthFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderWestFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderTopFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		renderer.renderBottomFace(block, 0D, 0D, 0D, block.getBlockTextureFromSideAndMetadata(0, item.getItemDamage()));
		tessellator.draw();
		switch(type){
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
