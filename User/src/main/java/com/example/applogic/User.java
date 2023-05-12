package com.example.applogic;

public abstract class User {
	protected String username;
	protected String role;
    
	public User(String username, String role) {
		this.username = username;
	    this.role = role;    
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}