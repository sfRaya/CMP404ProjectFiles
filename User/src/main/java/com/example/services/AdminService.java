package com.example.services;
import com.example.applogic.Admin;
import com.example.applogic.Farmer;
import com.example.applogic.User;
import com.example.db.DatabaseClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AdminService {
	private Map<String,Admin> adminsDB;
	private Map<String,Farmer> farmersDB;

	public AdminService() {		
		adminsDB = DatabaseClass.getAdminsDB();
		farmersDB = DatabaseClass.getFarmersDB();
	}
	
	// Retrieve list of all users
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>();
		for (User a: adminsDB.values()) {allUsers.add(a);}
		for (User f: farmersDB.values()) {allUsers.add(f);}

		return allUsers;
	}
	
	// Retrieve a specific user by username
	public User getUserByUsername(String username) {
		if (adminsDB.get(username) != null) {return adminsDB.get(username);};
		if (farmersDB.get(username) != null) {return farmersDB.get(username);};

		return null;
	}
	
	// Add an admin to the system
	public Admin addAdmin(Admin newAdmin) {
		if(adminsDB.containsKey(newAdmin.getUsername())) {return null;}
		
		adminsDB.put(newAdmin.getUsername(), newAdmin);
		return newAdmin;
	}
	
	// Add a farmer to the system
	public Farmer addFarmer(Farmer newFarmer) {
		if(farmersDB.containsKey(newFarmer.getUsername())) {return null;}

		farmersDB.put(newFarmer.getUsername(), newFarmer);
		return newFarmer;
	}
	
	// Update admin information
	public Admin updateAdmin(Admin newAdmin) {		
		if(newAdmin.getRole().equals("admin") && adminsDB.containsKey(newAdmin.getUsername())) {
			adminsDB.put(newAdmin.getUsername(), newAdmin);
			return newAdmin;
		}
		
		return null;
	}
	
	// Update farmer information
	public Farmer updateFarmer(Farmer newFarmer) {		
		if(newFarmer.getRole().equals("farmer") && farmersDB.containsKey(newFarmer.getUsername())) {
			farmersDB.put(newFarmer.getUsername(), newFarmer);
			return newFarmer;
		}
		
		return null;
	}
	
	// Remove a user from the system
	public String removeUser(String username) {
		
		if(adminsDB.containsKey(username)) {
			adminsDB.remove(username);
			return "Admin removed successfully";
		}
		if(farmersDB.containsKey(username)) {
			farmersDB.remove(username);
			return "Farmer removed successfully";
		}

		return "Error...User not found";
	}
}
