package com.example.User;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applogic.Farmer;
import com.example.services.FarmerService;

@RestController
@RequestMapping("/farmer/{username}")
public class FarmerController {
	
	private FarmerService farmerService = new FarmerService();
	
	@GetMapping()
    public List<Integer> getAllFarmIDs(@PathVariable("username") String username) {
        return farmerService.getAllFarmIDs(username);
    }
	
	@PostMapping("/{farmID}")
    public Farmer addFarmIDs(@PathVariable("username") String username, @PathVariable("farmID") int farmID  ) {
        return farmerService.addFarmID(username, farmID);
    }
	
	
	@DeleteMapping("/{farmID}")
	public String removeFarm(@PathVariable("username") String username, @PathVariable("farmID") int farmID)
	{
		return farmerService.deleteFarmID(username, farmID);
	}
	
	@GetMapping("/plantedIDs")
	public List<Integer> getAllPlantedFarmIDs(@PathVariable("username") String username) {
	        return farmerService.getAllPlantedFarmIDs(username);
	    }
		

	@PostMapping("/plantedIDs/{farmID}")
	public Farmer addPlantedFarmIDs(@PathVariable("username") String username, @PathVariable("farmID") int farmID  ) {
	        return farmerService.addPlantedFarmID(username, farmID);
	}
		
		
	@DeleteMapping("/planted/{farmID}")
	public String removePlantedFarm(@PathVariable("username") String username, @PathVariable("farmID") int farmID)
		{
			return farmerService.deletePlantedFarmID(username, farmID);
		}
	
	
}