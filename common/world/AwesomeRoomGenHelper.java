package fuj1n.awesomeMod.common.world;

import java.util.ArrayList;
import java.util.Random;

public class AwesomeRoomGenHelper {

	public static ArrayList<Integer> possibleColors = new ArrayList<Integer>();
	
	public static int getRandomSecondaryColor(Random par1Random){
		if(possibleColors.isEmpty()){
			return -1;
		}
		
		return possibleColors.get(par1Random.nextInt(possibleColors.size()));
	}
	
}
