package com.example.db;
import com.example.applogic.Crop;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
	private static Map<Integer,Crop> cropsDB = new HashMap<>();     // <cropID, crop object>   - List of all crops created in the system
	private static Map<Integer, Integer> plantedCropsDB = new HashMap<>();     // <farmID, cropID>   - List of all farms created in the system
	private static Map<String,String> cropsList = new HashMap<>() {{  // <cropName, plantMethod> - List of all possible crops to plant
		put("Mango", "Plant Mango");
		put("Strawberry", "Plant Strawberry");
		put("Wheat", "Plant Wheat");
	}};


	public static Map<Integer,Crop> getCropsDB() {
		return cropsDB;
	}

	public static void setCropsDB(Map<Integer,Crop> cropsDB) {
		DatabaseClass.cropsDB = cropsDB;
	}

	public static Map<String,String> getCropsList() {
		return cropsList;
	}

	public static void setCropsList(Map<String,String> cropsList) {
		DatabaseClass.cropsList = cropsList;
	}

	public static Map<Integer, Integer> getPlantedCropsDB() {
		return plantedCropsDB;
	}

	public static void setPlantedCropsDB(Map<Integer, Integer> plantedCropsDB) {
		DatabaseClass.plantedCropsDB = plantedCropsDB;
	}


}
