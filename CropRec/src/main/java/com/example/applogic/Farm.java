package com.example.applogic;

import java.util.Random;


public class Farm {
	private int farmID;
	private double humidity, temperature, nitrogen, phosphorous, potassium, ph, rainfall;
	
	public Farm() {
		super();
	}

	public int getFarmID() {
		return farmID;
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTemperature() {
		return temperature;
	}

	public double getNitrogen() {
		return nitrogen;
	}

	public double getPhosphorous() {
		return phosphorous;
	}

	public double getPotassium() {
		return potassium;
	}

	public double getPh() {
		return ph;
	}

	public double getRainfall() {
		return rainfall;
	}

	public void setfarmID(int farmID) {
		this.farmID = farmID;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public void setNitrogen(double nitrogen) {
		this.nitrogen = nitrogen;
	}

	public void setPhosphorous(double phosphorous) {
		this.phosphorous = phosphorous;
	}

	public void setPotassium(double potassium) {
		this.potassium = potassium;
	}

	public void setPh(double ph) {
		this.ph = ph;
	}

	public void setRainfall(double rainfall) {
		this.rainfall = rainfall;
	}

}
