package modJam;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid="fuj1n.modJam", name=CommonProxyModJam.modName, version=CommonProxyModJam.version)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)

public class ModJam {
	@SidedProxy(serverSide="modJam.CommonProxyModJam", clientSide="modJam.ClientProxyModJam")
	public static CommonProxyModJam proxy;
	public static Configuration config;
	
	//Config values
	//Blocks
	public static int oreAwesomeID = 1024;
	public static int woodChairNorthID = 1025;
	public static int woodChairEastID = 1026;
	public static int woodChairSouthID = 1027;
	public static int woodChairWestID = 1028;
	public static int stoneChairNorthID = 1029;
	public static int stoneChairEastID = 1030;
	public static int stoneChairSouthID = 1031;
	public static int stoneChairWestID = 1032;
	//Items
	public static int ingotAwesomeID = 3240;
	//End Config values
	//Blocks
	public static Block awesomeOre;
	public static Block woodChairNorth;
	public static Block woodChairEast;
	public static Block woodChairSouth;
	public static Block woodChairWest;
	public static Block stoneChairNorth;
	public static Block stoneChairEast;
	public static Block stoneChairSouth;
	public static Block stoneChairWest;
	//Items
	public static Item awesomeIngot;
	//CreativeTabs
	public static CreativeTabs modJamCreativeTab;
	//Sub Names
	private static final String[] awesomeColors = { 
		"White", "Orange", "Magenta",
		"Light-Blue", "Yellow", "Lime", "Pink", "Gray", "Light-Gray", "Cyan",
		"Purple", "Blue", "Brown", "Green", "Red", "Black"
	};
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		//Blocks
		oreAwesomeID = config.getBlock("Awesome Ore ID", oreAwesomeID).getInt();
		woodChairNorthID = config.getBlock("Wooden Chair North ID", woodChairNorthID).getInt();
		woodChairEastID = config.getBlock("Wooden Chair East ID", woodChairEastID).getInt();
		woodChairSouthID = config.getBlock("Wooden Chair South ID", woodChairSouthID).getInt();
		woodChairWestID = config.getBlock("Wooden Chair West ID", woodChairWestID).getInt();
		stoneChairNorthID = config.getBlock("Stone Chair North ID", stoneChairNorthID).getInt();
		stoneChairEastID = config.getBlock("Stone Chair East ID", stoneChairEastID).getInt();
		stoneChairSouthID = config.getBlock("Stone Chair South ID", stoneChairSouthID).getInt();
		stoneChairWestID = config.getBlock("Stone Chair West ID", stoneChairWestID).getInt();
		//Items
		ingotAwesomeID = config.getItem("Awesome Ingot ID", ingotAwesomeID).getInt();
		config.save();
	} 
	
	@Init
	public void Init(FMLInitializationEvent event){
		proxy.handler();
		registerCreativeTab();
		initAllBlocks();
		initAllItems();
		registerAllBlocks();
		addAllNames();
		addAllCrafting();
		addAllSmelting();
		registerAllOreDictionary();
	}
	
	public void initAllBlocks(){
		awesomeOre = new BlockAwesomeOre(oreAwesomeID).setHardness(5F).setResistance(5F).setCreativeTab(modJamCreativeTab).setUnlocalizedName("fuj1n.modJam.AwesomeOre");
		woodChairNorth = new BlockChair(woodChairNorthID, ForgeDirection.NORTH, Block.planks);
		woodChairEast = new BlockChair(woodChairEastID, ForgeDirection.EAST, Block.planks);
		woodChairSouth = new BlockChair(woodChairSouthID, ForgeDirection.SOUTH, Block.planks);
		woodChairWest = new BlockChair(woodChairWestID, ForgeDirection.WEST, Block.planks);
		stoneChairNorth = new BlockChair(stoneChairNorthID, ForgeDirection.NORTH, Block.stone);
		stoneChairEast = new BlockChair(stoneChairEastID, ForgeDirection.EAST, Block.stone);
		stoneChairSouth = new BlockChair(stoneChairSouthID, ForgeDirection.SOUTH, Block.stone);
		stoneChairWest = new BlockChair(stoneChairWestID, ForgeDirection.WEST, Block.stone);
	}
	
	public void initAllItems(){
		awesomeIngot = new ItemAwesomeIngot(ingotAwesomeID).setCreativeTab(modJamCreativeTab);
	}
	
	public void registerAllBlocks(){
		GameRegistry.registerBlock(awesomeOre, ItemAwesomeOre.class, "fuj1n.modJam.awesomeOre");
	}
	
	public void addAllNames(){
		for (int i = 0; i < 16; i++) {
			LanguageRegistry.addName(new ItemStack(awesomeOre, 1, i), awesomeColors[new ItemStack(awesomeOre, 1, i).getItemDamage()] + " Awesome Ore");
			LanguageRegistry.addName(new ItemStack(awesomeIngot, 1, i), awesomeColors[new ItemStack(awesomeIngot, 1, i).getItemDamage()] + " Awesome Ingot");
		}
	}
	
	public void registerCreativeTab(){
		modJamCreativeTab = new CreativeTabModJam("fuj1n.modJam");
		LanguageRegistry.instance().addStringLocalization("itemGroup." + modJamCreativeTab.getTabLabel(), CommonProxyModJam.modName);
	}
	
	public void addAllCrafting(){}
	
	public void addAllSmelting(){
		for (int i = 0; i < 16; i++){
			FurnaceRecipes.smelting().addSmelting(oreAwesomeID, i, new ItemStack(awesomeIngot, 1, i), 0.1F);
		}
	}
	
	public void registerAllOreDictionary(){
		for (int i = 0; i < 16; i++) {
			OreDictionary.registerOre("oreAwesome" + awesomeColors[i], new ItemStack(awesomeOre, 1, i));
			OreDictionary.registerOre("ingotAwesome" + awesomeColors[i], new ItemStack(awesomeIngot, 1, i));
		}
		
	}
}
