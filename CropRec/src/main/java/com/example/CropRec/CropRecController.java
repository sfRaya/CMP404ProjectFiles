package com.example.CropRec;

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
import com.example.services.CropRecService;

@RestController
@RequestMapping("/farmer/{username}")
public class CropRecController {
	
	private CropRecService CropRecService = new CropRecService();
	
	//you have to call get farm and getcropslist and feed them to this function in the body
	@PostMapping("/predict")
    public String predictCrops(@RequestBody Farm farm) {
    	return CropRecService.predictCrop(farm);
    }
	
}