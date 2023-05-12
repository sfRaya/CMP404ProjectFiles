package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import com.example.applogic.Crop;
import com.example.db.DatabaseClass;

public class MonitorService {
	
	private Map<Integer,Crop> monitorDB;
	
	public MonitorService() {
		super();
		monitorDB = DatabaseClass.getMonitorDB();
		
	}
	
	public String monitor(Crop crop) {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			 @Override
	            public void run() {
				 System.out.print("Plant monitored!");
				 crop.monitorReading();
				 monitorDB.put(crop.getCropID(), crop);
	            }
		},  0, 10*1000);
		
		return "Monitoring...";
		
	}
	
	
	public Crop MonitorReadings(int cropID) {
			
				Crop c = monitorDB.get(cropID);
				
				Boolean status = false;
				
				
				if (c.getCvi()>100 && c.getNg()>100) {
					status = true;
				}
				else {
					status = false;
				}
				
				c.setHealthy(status);

				return c;			}
			
	}
	