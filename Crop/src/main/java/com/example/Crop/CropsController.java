package com.example.Crop;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.applogic.Crop;
import com.example.services.CropsService;

@RestController
@RequestMapping("/farmer/{username}/crops")
public class CropsController {
	
	private CropsService cropsService = new CropsService();
	
	@GetMapping("/{farmID}")
    public Crop getCrop(@PathVariable("farmID") int farmID) {
        return cropsService.getCrop(farmID);
    }
	
	@PostMapping("/{farmID}/{cropname}")
    public Crop addFarm(@PathVariable("farmID") int farmID,@PathVariable("cropname") String cropname) {
    	return cropsService.addPlantedCrop(farmID, cropname);
    }
	
	@DeleteMapping("/{farmID}")
	public String removeFarm( @PathVariable("farmID") int farmID)
	{
		return cropsService.deletePlantedCrop(farmID);
	}
	
}