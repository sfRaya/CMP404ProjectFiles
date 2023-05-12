package com.example.db;
import com.example.applogic.Crop;


import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
	private static Map<Integer,Crop> monitorDB = new HashMap<>();     // <farmID, farm object>   - List of all farms created in the system

	public static Map<Integer, Crop> getMonitorDB() {
		return monitorDB;
	}

	public static void setMonitorDB(Map<Integer, Crop> monitorDB) {
		DatabaseClass.monitorDB = monitorDB;
	}
	
}