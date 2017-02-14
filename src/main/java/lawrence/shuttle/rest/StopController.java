package lawrence.shuttle.rest;

import lawrence.shuttle.data.StopRepository;
import lawrence.shuttle.to.Stop;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import lawrence.shuttle.data.UserRepository;


import org.json.*;	

@RequestMapping("/stop")
@RestController
public class StopController {
	
	@Autowired
	StopRepository stopRepo;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getstoplocation")
	public String getStopId(@RequestParam("stopid") String stopid) {
		Stop stop = stopRepo.findByStopid(stopid);
		JSONObject loc = new JSONObject();
		loc.put("longitude", stop.getLongitude());
		loc.put("latitude", stop.getLatitude());
		loc.put("address", stop.getAddress());
		return loc.toString();
	}

}
