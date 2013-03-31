package modJam;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyModJam extends CommonProxyModJam{
	
    public static int awesomeOreRenderType;
    public static int chairRenderType;
    public static int tableRenderType;
    public static int awesomeOreRenderStage = 0;
    public static int chairRenderStage = 0;
    public static int tableRenderStage = 0;
    
	@Override
	public void handler(){
		awesomeOreRenderType = RenderingRegistry.getNextAvailableRenderId();
		chairRenderType = RenderingRegistry.getNextAvailableRenderId();
		tableRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderAwesomeOre());
        RenderingRegistry.registerBlockHandler(new RenderChair());
        RenderingRegistry.registerBlockHandler(new RenderTable());
	}
}
