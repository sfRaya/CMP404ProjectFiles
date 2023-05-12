package com.example.User;

import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applogic.Admin;
import com.example.applogic.Farmer;
import com.example.applogic.User;
import com.example.services.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	private AdminService adminService = new AdminService();
	
	// Retrieve all users in system 
	@GetMapping
    public List<User> getAllUsers() {
        return adminService.getAllUsers();
    }
	
	// Retrieve user by username
	@GetMapping(path="/{username}")
    public User getUserByUsername(@PathVariable("username") String username) {
        return adminService.getUserByUsername(username);
    }
	
	// Add users to system
	@PostMapping(path="")
	public Admin addAdmin(@RequestBody Admin admin) {
		if(admin.getRole().equals("admin")) {return adminService.addAdmin(new Admin(admin.getUsername()));}
		return null;
	}
	
	@PostMapping(path="/farmer")
	public Farmer addFarmer(@RequestBody Farmer farmer) {
		if(farmer.getRole().equals("farmer")) {return adminService.addFarmer(new Farmer(farmer.getUsername()));}
		return null;
	}
	
	// Update users in system
	@PutMapping(path="")
	public Admin updateAdmin(@RequestBody Admin admin) {
		if(admin.getRole().equals("farmer")) {return adminService.updateAdmin(admin);}
		return null;
    }
	
	@PutMapping(path="/farmer")
	public Farmer updateFarmer(@RequestBody Farmer farmer) {
		if(farmer.getRole().equals("farmer")) {return adminService.updateFarmer(farmer);}
		return null;
    }
	
	// Remove users from system
	@DeleteMapping("/{username}")
	public String removeUser(@PathVariable("username") String username)
	{
		return adminService.removeUser(username);
	}
}
