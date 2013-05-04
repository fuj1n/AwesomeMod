package fuj1n.awesomeMod.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.logging.Level;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.IPlayerTracker;
import fuj1n.awesomeMod.ModJam;

public class PlayerTrackerModJam implements IPlayerTracker {

	private static final String modName = "Awesome Mod";

	private int currentMinecraft, currentMod, latestMinecraft, latestMod;

	public PlayerTrackerModJam(int currentMinecraft, int currentMod, int latestMinecraft, int latestMod) {
		this.currentMinecraft = currentMinecraft;
		this.currentMod = currentMod;
		this.latestMinecraft = latestMinecraft;
		this.latestMod = latestMod;
	}

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		if (latestMod > currentMod || latestMinecraft > currentMinecraft && currentMinecraft != 0) {
			player.addChatMessage("[\2472" + insertDots(Integer.toString(latestMinecraft)) + "\247r] " + "A new update for \2475" + modName + "\247r is available.");
		}
	}

	private String insertDots(String s) {
		int length = s.length();
		BufferedReader br = new BufferedReader(new StringReader(s));
		String output = "";
		try {
			for (int i = 0; i < length; i++) {
				if (i == 0) {
					output = "" + (char) br.read();
				} else {
					output = output + "." + (char) br.read();
				}
			}
		} catch (IOException e) {
			ModJam.log("Could not morph string.", Level.SEVERE);
		}
		return output;
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {

	}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {

	}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {

	}
}
