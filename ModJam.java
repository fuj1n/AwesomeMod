package modJam;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.Configuration;
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
	public static int oreAwesomeID = 1024;
	//Blocks
	public static Block awesomeOre;
	//CreativeTabs
	public static CreativeTabs modJamCreativeTab;
	
	@PreInit
	public void PreInit(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		oreAwesomeID = config.getBlock("Awesome Ore ID", oreAwesomeID).getInt();
		config.save();
	}
	
	@Init
	public void Init(FMLInitializationEvent event){
		proxy.handler();
		initAllBlocks();
		registerAllBlocks();
		addAllNames();
		registerCreativeTab();
	}
	
	public void initAllBlocks(){
		awesomeOre = new BlockAwesomeOre(oreAwesomeID).setHardness(5F).setResistance(5F).setUnlocalizedName("fuj1n.modJam.AwesomeOre");
	}
	
	public void registerAllBlocks(){
		GameRegistry.registerBlock(awesomeOre, "fuj1n.modJam.awesomeOre");
	}
	
	public void addAllNames(){
		LanguageRegistry.addName(awesomeOre, "Awesome Ore");
	}
	
	public void registerCreativeTab(){
		modJamCreativeTab = new CreativeTabModJam("fuj1n.modJam");
		LanguageRegistry.instance().addStringLocalization("itemGroup." + modJamCreativeTab.getTabLabel(), CommonProxyModJam.modName);
	}
}
