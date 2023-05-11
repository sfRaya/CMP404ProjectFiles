package com.example.db;
import com.example.applogic.Farm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseClass {
	private static Map<Integer, String> FarmsandFarmersDB = new HashMap<>(); // <Username, farmID> - Farms created by the user, not necessarily planted farms
	private static Map<Integer,Farm> farmsDB = new HashMap<>();     // <farmID, farm object>   - List of all farms created in the system
	private static Map<Integer, String> PlantedFarmsandFarmersDB = new HashMap<>(); // <Username, farmID> - Farms created by the user, not necessarily planted farms

	
	public static Map<Integer,Farm> getFarmsDB() {
		return farmsDB;
	}
	
	public static Map<Integer, String> getFarmsandFarmersDB() {
		return FarmsandFarmersDB;
	}
	
	public static Map<Integer, String> getPlantedFarmsandFarmersDB() {
		return PlantedFarmsandFarmersDB;
	}

	public static void setFarmsDB(Map<Integer,Farm> farmsDB) {
		DatabaseClass.farmsDB = farmsDB;
	}
	
	public static void setFarmsandFarmersDB(Map<Integer, String> farmsDB) {
		DatabaseClass.FarmsandFarmersDB = farmsDB;
	}
	
	public static void setPlantedFarmsandFarmersDB(Map<Integer, String> farmsDB) {
		DatabaseClass.PlantedFarmsandFarmersDB = farmsDB;
	}


}
