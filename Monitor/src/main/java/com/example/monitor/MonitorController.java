package com.example.monitor;

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
import com.example.services.MonitorService;

@RestController
@RequestMapping("/farmer/{username}")
public class MonitorController {
	
	private MonitorService monitorService = new MonitorService();
	
	@GetMapping(path="/monitor")  //or 'monitor' but again i don't want to use verbs
    public String monitorStart(@RequestBody Crop c){
        return monitorService.monitor(c);
    }
	//monitor
	@GetMapping(path="/monitor/{cropID}/status")  //or 'monitor' but again i don't want to use verbs
    public Crop MonitorReadings(@PathVariable("cropID")int cropID){
        return monitorService.MonitorReadings(cropID);
    }
}