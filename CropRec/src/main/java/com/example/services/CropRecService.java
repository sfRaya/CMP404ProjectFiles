package com.example.services;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.example.applogic.Farm;
public class CropRecService {
	public CropRecService() {
		super();}

	
	// Predict crop
	@SuppressWarnings("unlikely-arg-type")
	public String predictCrop(Farm farm) {
		System.out.print(String.format("Farm %d recieved, predicting...", farm.getFarmID()) );
		Random random = new Random();
		Map<String, String> cropsList = new HashMap<>();
        cropsList.put("Mango", "Plant Mango");
        cropsList.put("Strawberry", "Plant Strawberry");
        cropsList.put("Wheat", "Plant Wheat");
        
        int index = random.nextInt(cropsList.size());
  		//hypothetical ML model
		return (String) cropsList.keySet().toArray()[index];
	}
	
}