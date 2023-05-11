package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.example.applogic.Farm;
import com.example.db.DatabaseClass;

public class FarmService {
	private Map<Integer,Farm> farmsDB;    // <farmID, Farm object>
	private Map<Integer, String> FarmsandFarmersDB; // <userID, farmID>
	private Map<Integer, String> PlantedFarmsandFarmersDB; // <userID, farmID>

	
	public FarmService() {
		super();
		farmsDB = DatabaseClass.getFarmsDB();
		FarmsandFarmersDB = DatabaseClass.getFarmsandFarmersDB();
		PlantedFarmsandFarmersDB = DatabaseClass.getPlantedFarmsandFarmersDB();

	}
	
	// Retrieve list of all farms
	public List<Farm> getAllFarms(String username) {
		List<Farm> allFarms = new ArrayList<>();

	        for (Map.Entry<Integer, String> entry : FarmsandFarmersDB.entrySet()) {
	            if (entry.getValue().equals(username)) {
	                allFarms.add(getFarm(entry.getKey()));
	            }
	        }
			return allFarms;
		
	}
	
	public List<Farm> getAllPlantedFarms(String username) {
		List<Farm> allFarms = new ArrayList<>();

	        for (Map.Entry<Integer, String> entry : PlantedFarmsandFarmersDB.entrySet()) {
	            if (entry.getValue().equals(username)) {
	                allFarms.add(getFarm(entry.getKey()));
	            }
	        }
			return allFarms;
		
	}
	
	//Retrieve farm by farmID
	public Farm getFarm(int farmID) {
		if (farmsDB.containsKey(farmID)) {				
				return farmsDB.get(farmID);
		}
		return null;
	}
	
	// Add a farm to a farmer
	public Farm addFarm(String username) {
		
		Farm newFarm = new Farm();
		
		farmsDB.put(newFarm.getFarmID(), newFarm);
		FarmsandFarmersDB.put(newFarm.getFarmID(), username);
		return newFarm;
	}
	
	public List<Farm> addPlantedFarm(String username, int farmID) {

		PlantedFarmsandFarmersDB.put(farmID, username);
		return getAllPlantedFarms(username);
	}

	
	// Delete a farm from a farmer
	public String deleteFarm(String username, int farmID) {
		
		if (farmsDB.get(farmID) != null) 
		{
				farmsDB.remove(farmID);
				if(FarmsandFarmersDB.get(farmID) != null) {
					FarmsandFarmersDB.remove(farmID);
				}
				if(PlantedFarmsandFarmersDB.get(farmID) != null) {
					PlantedFarmsandFarmersDB.remove(farmID);
			}
				return "Farm deleted successfully!";
		
			}
		
		else {			
			return "Error...Farm not found";

		}

	}
		
	public String deletePlantedFarm(String username, int farmID) {
			
			if (farmsDB.get(farmID) != null) 
			{
					if(PlantedFarmsandFarmersDB.get(farmID) != null) {
						PlantedFarmsandFarmersDB.remove(farmID);
				}
					return "Farm deleted successfully!";
			
				}
			
			else {			
				return "Error...Farm not found";
	
			}
	
		}
	
	
}