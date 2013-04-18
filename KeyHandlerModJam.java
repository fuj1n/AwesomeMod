package fuj1n.awesomeMod;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class KeyHandlerModJam extends KeyHandler{

	public KeyHandlerModJam(KeyBinding[] keyBindings) {
		super(keyBindings);
	}
	
	public KeyHandlerModJam(KeyBinding[] keyBindings, boolean[] repeatings){
		super(keyBindings, repeatings);
	}

	@Override
	public String getLabel() {
		return "fuj1n.ModJam.KeyBindingTickHandler";
	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb,
			boolean tickEnd, boolean isRepeat) {
		if(kb == ClientProxyModJam.themeProps){
			if(Minecraft.getMinecraft().theWorld != null && Minecraft.getMinecraft().currentScreen == null){
				Minecraft.getMinecraft().thePlayer.openGui(ModJam.instance, 1, null, 0, 0, 0);
			}
		}
	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {}

	@Override
	public EnumSet<TickType> ticks() {
		return EnumSet.of(TickType.CLIENT);
	}

}
