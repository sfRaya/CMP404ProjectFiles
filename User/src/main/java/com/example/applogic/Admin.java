package com.example.applogic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Admin extends User {

	public Admin(String username) {
		super(username, "admin");
	}
	
    @JsonCreator
    public Admin(@JsonProperty("username") String username,  @JsonProperty("role") String role) {
    	super(username, role);
    }
}