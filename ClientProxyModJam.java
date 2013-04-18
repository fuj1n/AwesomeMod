package fuj1n.awesomeMod;

import net.minecraft.block.Block;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyModJam extends CommonProxyModJam{
	
    public static int awesomeOreRenderType;
    public static int chairRenderType;
    public static int tableRenderType;
    public static int awesomeBlockRenderType;
    public static int lightGenRenderType;
    public static int awesomeOreRenderStage = 0;
    public static int furnitureRenderStage = 0;
    public static int awesomeBlockRenderStage = 0;
    
    //Key binding
    public static KeyBinding themeProps;
    
    @Override
    public void preInit(){
		ModJam.themeHandler = new ThemingHandler(ModJam.configDir);
    }
    
	@Override
	public void Init(){
		awesomeOreRenderType = RenderingRegistry.getNextAvailableRenderId();
		chairRenderType = RenderingRegistry.getNextAvailableRenderId();
		tableRenderType = RenderingRegistry.getNextAvailableRenderId();
		awesomeBlockRenderType = RenderingRegistry.getNextAvailableRenderId();
		lightGenRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderAwesomeOre());
        RenderingRegistry.registerBlockHandler(new RenderChair());
        RenderingRegistry.registerBlockHandler(new RenderTable());
        RenderingRegistry.registerBlockHandler(new RenderAwesomeBlock());
        RenderingRegistry.registerBlockHandler(new RenderLightGen());
        awesomeArmorID = RenderingRegistry.addNewArmourRendererPrefix("awesome");
    	themeProps = new KeyBinding("Awesome Mod Theme Settings", 25);
    	KeyBindingRegistry.registerKeyBinding(new KeyHandlerModJam(new KeyBinding[]{themeProps}, new boolean[]{false}));
	}
	
	@Override
	public void postInit(){
        MinecraftForgeClient.registerItemRenderer(ModJam.stoneChair.itemID, new ItemRenderChair(ModJam.stoneChairNorth, Block.stone));
        MinecraftForgeClient.registerItemRenderer(ModJam.woodChair.itemID, new ItemRenderChair(ModJam.woodChairNorth, Block.planks));
	}
}
