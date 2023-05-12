package com.example.db;
import com.example.applogic.Admin;
import com.example.applogic.Farmer;

import java.util.HashMap;
import java.util.Map;

public class DatabaseClass {
	private static Map<String,Admin> adminsDB = new HashMap<>() {{put("defaultAdmin", new Admin("defaultAdmin"));}};       // <username, user object> - List of all admins created in the system
	private static Map<String,Farmer> farmersDB = new HashMap<>() {{put("defaultFarmer", new Farmer("defaultFarmer"));}};  // <username, user object> - List of all farmers created in the system
	

	public static Map<String,Admin> getAdminsDB() {
		return adminsDB;
	}

	public static void setAdminsDB(Map<String,Admin> adminsDB) {
		DatabaseClass.adminsDB = adminsDB;
	}

	public static Map<String,Farmer> getFarmersDB() {
		return farmersDB;
	}

	public static void setFarmersDB(Map<String,Farmer> farmersDB) {
		DatabaseClass.farmersDB = farmersDB;
	}


}
