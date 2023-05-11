package com.example.Farm;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applogic.Farm;
import com.example.services.FarmService;

@RestController
@RequestMapping("/farmer/{username}/farms")
public class FarmController {
	
	private FarmService farmService = new FarmService();
	
	@GetMapping()
    public List<Farm> getAllFarms(@PathVariable("username") String username) {
        return farmService.getAllFarms(username);
    }
	
	@GetMapping("/planted")
    public List<Farm> getAllPlantedFarms(@PathVariable("username") String username) {
        return farmService.getAllPlantedFarms(username);
    }
	
	@GetMapping("/{farmID}")
    public Farm getFarm(@PathVariable("username") String username, @PathVariable("farmID") int farmID) {
        return farmService.getFarm(farmID);
    }
	
	@PostMapping
    public Farm addFarm(@PathVariable("username") String username) {
    	return farmService.addFarm(username);
    }
	
	@PostMapping("/planted/{farmID}")
    public List<Farm> addPlantedFarm(@PathVariable("username") String username, @PathVariable("farmID") int farmID) {
    	return farmService.addPlantedFarm(username, farmID);
    }
	
	
	@DeleteMapping("/{farmID}")
	public String removeFarm(@PathVariable("username") String username, @PathVariable("farmID") int farmID)
	{
		return farmService.deleteFarm(username, farmID);
	}
	
	@DeleteMapping("/planted/{farmID}")
	public String removePlantedFarm(@PathVariable("username") String username, @PathVariable("farmID") int farmID)
	{
		return farmService.deletePlantedFarm(username, farmID);
	}
	
	
}