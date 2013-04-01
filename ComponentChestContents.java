package modJam;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ComponentChestContents {

	public static List<ItemStack> chestGen = new ArrayList();
	
	public static void addItemGen(Block item, int meta, int min, int max, int weight){
		for(int m = min; m <= max; m++){
			for(int i = 0; i < weight; i++){
				chestGen.add(new ItemStack(item, m, meta));
			}
		}
	}
	
	public static void addItemGen(Item item, int meta, int min, int max, int weight){
		for(int m = min; m <= max; m++){
			for(int i = 0; i < weight; i++){
				chestGen.add(new ItemStack(item, m, meta));
			}
		}
	}
	
	public static void addItemGen(Item item, int[] metaList, int min, int max, int weight){
		for(int m = min; m <= max; m++){
			for(int metaIndex = metaList[0]; metaIndex < metaList.length; metaIndex++){
				for(int i = 0; i < weight; i++){
					chestGen.add(new ItemStack(item, m, metaList[metaIndex]));
				}
			}
		}
	}
	
}
