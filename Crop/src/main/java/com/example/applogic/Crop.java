package com.example.applogic;
import java.util.Random;

import com.example.db.DatabaseClass;

public class Crop {
	
	private int cropID;
	private String cropName, plantMethod;
	private double nir, reflectedGreen, redLight, cvi, ng;
	private boolean healthy;
	
	public Crop(String cropName) {
		super();
		this.cropID = DatabaseClass.getCropsDB().size() + 1;
		
		this.cropName = cropName;
		this.plantMethod = DatabaseClass.getCropsList().get(cropName);
		
		Random random = new Random();
		this.nir = random.nextInt(100);
		this.reflectedGreen = random.nextInt(100);
		this.redLight = random.nextInt(100);
		this.cvi = random.nextInt(100);
		this.ng = random.nextInt(100);
		
	}

	public int getCropID() {
		return cropID;
	}

	public void setCropID(int cropID) {
		this.cropID = cropID;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getPlantMethod() {
		return plantMethod;
	}

	public void setPlantMethod(String plantMethod) {
		this.plantMethod = plantMethod;
	}

	public double getNir() {
		return nir;
	}

	public void setNir(double nir) {
		this.nir = nir;
	}

	public double getReflectedGreen() {
		return reflectedGreen;
	}

	public void setReflectedGreen(double reflectedGreen) {
		this.reflectedGreen = reflectedGreen;
	}

	public double getRedLight() {
		return redLight;
	}

	public void setRedLight(double redLight) {
		this.redLight = redLight;
	}

	public double getCvi() {
		return cvi;
	}

	public void setCvi(double cvi) {
		this.cvi = cvi;
	}

	public double getNg() {
		return ng;
	}

	public void setNg(double ng) {
		this.ng = ng;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	public void calculateCropHealth() {
		if((nir + reflectedGreen + redLight + cvi + ng)>250) {healthy = true;}
		else {healthy = false;}
	}
	
}
