package modJam;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxyModJam extends CommonProxyModJam{
	
    public static int awesomeOreRenderType;
    public static int awesomeOreRenderStage = 0;
    
	@Override
	public void handler(){
		awesomeOreRenderType = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(new RenderAwesomeOre());
	}
}
