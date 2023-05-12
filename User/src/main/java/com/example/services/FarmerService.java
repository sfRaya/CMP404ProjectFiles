package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.example.applogic.Farmer;
import com.example.db.DatabaseClass;

public class FarmerService {
	private Map<String,Farmer> farmersDB; // <username, Farmer object>
	
	public FarmerService() {
		super();
		farmersDB = DatabaseClass.getFarmersDB();
	}
	
	// Retrieve list of all farm IDs
	public List<Integer> getAllFarmIDs(String username) {
		List<Integer> allFarms = new ArrayList<>();
		if (farmersDB.containsKey(username)) {				
			for(int i: farmersDB.get(username).getFarmIDs())
			{
					allFarms.add(i);
			}
			
			return allFarms;
		}
		return null;
	}
	
	// Add a farm ID to a farmer
	public Farmer addFarmID(String username, int FarmID) {
		if (farmersDB.get(username) == null || farmersDB.get(username).getFarmIDs().contains(FarmID)) {return null;}
		
		farmersDB.get(username).getFarmIDs().add(FarmID);
		return farmersDB.get(username);
	}
	
//	//where the farm is inputed by user
//	public Farm addFarm(String username, Farm f) {
//		if (farmersDB.get(username) == null) {return null;}
//		
//		farmsDB.put(f.getFarmID(), f);
//		farmersDB.get(username).getFarms().add(f.getFarmID());
//		return f;
//	}
	
	// Delete a farm ID from a farmer
	public String deleteFarmID(String username, int farmID) {
		
		if (farmersDB.get(username) == null) {return "Error...Farmer not found";}
		if (farmersDB.get(username).getFarmIDs().isEmpty()) {return "Error...No farms exist for this farmer";}
		
		if (farmersDB.get(username).getFarmIDs().contains(farmID)) {
			farmersDB.get(username).getFarmIDs().remove(farmID);
			return "Farm removed successfully";
		}
		else {return "Error...Farm not found";}
	}
	
	// Retrieve list of all farm IDs
		public List<Integer> getAllPlantedFarmIDs(String username) {
			List<Integer> allFarms = new ArrayList<>();
			if (farmersDB.containsKey(username)) {				
				for(int i: farmersDB.get(username).getPlantedFarmIDs())
				{
						allFarms.add(i);
				}
				
				return allFarms;
			}
			return null;
		}
		
		// Add a farm ID to a farmer
		public Farmer addPlantedFarmID(String username, int FarmID) {
			if (farmersDB.get(username) == null || farmersDB.get(username).getPlantedFarmIDs().contains(FarmID)) {return null;}
			
			farmersDB.get(username).getPlantedFarmIDs().add(FarmID);
			return farmersDB.get(username);
		}
		
//		//where the farm is inputed by user
//		public Farm addFarm(String username, Farm f) {
//			if (farmersDB.get(username) == null) {return null;}
//			
//			farmsDB.put(f.getFarmID(), f);
//			farmersDB.get(username).getFarms().add(f.getFarmID());
//			return f;
//		}
		
		// Delete a farm ID from a farmer
		public String deletePlantedFarmID(String username, int farmID) {
			
			if (farmersDB.get(username) == null) {return "Error...Farmer not found";}
			if (farmersDB.get(username).getPlantedFarmIDs().isEmpty()) {return "Error...No farms exist for this farmer";}
			
			if (farmersDB.get(username).getPlantedFarmIDs().contains(farmID)) {
				farmersDB.get(username).getPlantedFarmIDs().remove(farmID);
				return "Farm removed successfully";
			}
			else {return "Error...Farm not found";}
		}
	
}