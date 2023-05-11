package com.example.services;

import java.util.Map;
import java.util.Random;

import com.example.applogic.Farm;
public class CropRecService {
	
	public CropRecService() {
		super();}

	
	// Predict crop
	@SuppressWarnings("unlikely-arg-type")
	public String predictCrop(Farm farm, Map<String,String> cropsList) {
		System.out.print(String.format("Farm %d recieved, predicting...", farm.getFarmID()) );
		Random random = new Random();
		
		//hypothetical ML model
		return cropsList.get(random.nextInt(cropsList.size()));
	}
	
}