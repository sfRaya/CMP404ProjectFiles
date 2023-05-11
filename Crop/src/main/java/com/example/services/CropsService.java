package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.example.applogic.Crop;
import com.example.db.DatabaseClass;

public class CropsService {
	private Map<Integer,Crop> cropsDB;    // <cropID, Crop object>
	private Map<String,String> cropsList; // <cropName, plantMethod>
	private Map<Integer, Integer> plantedCropsDB ; //<farmID, CropID>
	
	public CropsService() {
		super();
		plantedCropsDB = DatabaseClass.getPlantedCropsDB();
		cropsDB = DatabaseClass.getCropsDB();
		cropsList = DatabaseClass.getCropsList();
	}
	
	//get all crops
	public Crop getCrop(int farmID) {
		if (plantedCropsDB.containsKey(farmID)) {
			return cropsDB.get(plantedCropsDB.get(farmID));
		}
		else {
			System.out.print("farm contains no crop");
			return null;}
		}
	
	//add planted crop
	
	public Crop addPlantedCrop(int farmID, String cropname) {
		
		Crop newCrop = new Crop(cropname);
		
		cropsDB.put(newCrop.getCropID(), newCrop);
		plantedCropsDB.put(farmID, newCrop.getCropID());
		return newCrop;
	}
	
	public String deletePlantedCrop(int farmID) {
		
		if (getCrop(farmID) != null) {
			Crop newCrop = getCrop(farmID);
			cropsDB.remove(newCrop.getCropID());
			plantedCropsDB.remove(farmID);
			return "Crop removed successfully!";
		}
		else
		{return "Error...Crop/Farm not found";}
		
	}
	//the function below is to delete using a combination of crop ID and farmID if needed
//	
//	
//public String deletePlantedCrop(int cropID, int farmID) {
//		
//		if (cropsDB.get(cropID) != null && plantedCropsDB.get(farmID) != null) {
//			cropsDB.remove(cropID);
//			plantedCropsDB.remove(farmID);
//			return "Crop removed successfully!";
//		}
//		else
//		{return "Error...Crop/Farm not found";}
//		
//	}
}