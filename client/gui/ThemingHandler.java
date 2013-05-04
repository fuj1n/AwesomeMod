package fuj1n.awesomeMod.client.gui;

import java.io.File;
import java.util.logging.Level;

import fuj1n.awesomeMod.ModJam;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public class ThemingHandler {

	public File configFile;
	public Configuration config;
	public int defaultFileId = 0, defaultTextureIndex = 0;
	
	public int numberOfFiles = 2;
	public int themesPerFile = 3;

	public ThemingHandler(File configDir) {
		configFile = new File(configDir, "fuj1n.modJam.theme.cfg");
		config = new Configuration(configFile, true);
		config.load();
		int[] configData = readConfiguration();
		defaultFileId = configData[0];
		defaultTextureIndex = configData[1];
	}

	public void writeConfiguration(int textureFile, int textureIndex) {
		configFile.delete();
		config = new Configuration(configFile, true);
		config.load();
		Property var1 = config.get("Looks", "textureFileId", textureFile);
		var1.comment = "The ID of the texture file used for the background";
		Property var2 = config.get("Looks", "textureIndex", textureIndex);
		var2.comment = "The index of the texture on the file for the background";
		config.save();
	}

	public int[] readConfiguration() {
		config.load();
		config.addCustomCategoryComment("Looks", "The looks of the mods GUI's - This file does not need to be modified, push (by default) P in game to modify.");
		int textureFile = config.get("Looks", "textureFileId", 0).getInt(0);
		int textureIndex = config.get("Looks", "textureIndex", 0).getInt(0);
		config.save();
		boolean shouldRewrite = false;
		if(textureFile >= numberOfFiles){
			textureFile = 0;
			shouldRewrite = true;
			ModJam.log("The read texture file ID is out of bounds.", Level.WARNING);
		}if(textureIndex >= themesPerFile){
			textureIndex = 0;
			shouldRewrite = true;
			ModJam.log("The read texture index ID is out of bounds.", Level.WARNING);
		}if(shouldRewrite){
			writeConfiguration(textureFile, textureIndex);
			ModJam.log("Re-wrote configuration file.", Level.FINE);
		}
		return new int[] { textureFile, textureIndex };
	}

	public int getFileId() {
		return readConfiguration()[0];
	}

	public int getTextureIndex() {
		return readConfiguration()[1];
	}

}
