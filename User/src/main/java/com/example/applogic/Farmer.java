package com.example.applogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Farmer extends User {	
	private List<Integer> farmIDs = new ArrayList<>(); 		     // <farmID> - Farms created by the user, not necessarily planted farms
	private List<Integer> PlantedFarmIDs = new ArrayList<>(); 		     // <farmID> 
	
	
	public Farmer(String username) {
		super(username, "farmer");
	}
	
    @JsonCreator
    public Farmer(@JsonProperty("username") String username,  @JsonProperty("role") String role,
    			  @JsonProperty("farms") List<Integer> farmIDs,  @JsonProperty("plantedfarms") List<Integer> pfarmIDs) {
    	super(username, role);
    	this.farmIDs = farmIDs;
    	this.PlantedFarmIDs = pfarmIDs;
    }

	public List<Integer> getFarmIDs() {
		return farmIDs;
	}

	public void setFarmsIDs(List<Integer> farms) {
		this.farmIDs = farms;
	}
	
	public List<Integer> getPlantedFarmIDs() {
		return PlantedFarmIDs;
	}

	public void setPlantedFarmsIDs(List<Integer> farms) {
		this.PlantedFarmIDs = farms;
	}

}