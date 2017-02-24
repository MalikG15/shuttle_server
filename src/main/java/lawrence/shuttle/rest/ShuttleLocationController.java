package lawrence.shuttle.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import lawrence.shuttle.data.ShuttleLocationRepository;
import lawrence.shuttle.to.ShuttleLocation;

import org.json.*;

@RequestMapping("/shuttle")
@RestController
public class ShuttleLocationController {
	
	@Autowired
	ShuttleLocationRepository slr;

	@RequestMapping(value = "/sendlocation", method = RequestMethod.POST)
	public int saveLocation(@RequestBody String loc) {
		JSONObject locObj = new JSONObject(loc);
		System.out.println(locObj.toString());
		ShuttleLocation shuttle = slr.findBydriverid(locObj.getString("driverid"));
		if (shuttle == null && locObj.getString("driverid") != null) {
			shuttle = new ShuttleLocation();
			shuttle.setDriverid(locObj.getString("driverid"));
		} 
		else if (locObj.getString("driverid") == null) return -1;
		else if (locObj.getString("latitude").equals(shuttle.getLatitude()) && locObj.getString("longitude").equals(shuttle.getLongitude())) {
			return 0;
		}
		//shuttle.setDriverid(locObj.getString("driverid"));
		shuttle.setLatitude(locObj.getString("latitude"));
		shuttle.setLongitude(locObj.getString("longitude"));
		slr.saveAndFlush(shuttle);
		return 1;
	}
	
	@RequestMapping(value = "/get")
	public String getDriverLoc(@RequestParam("shuttleid") String shuttleid) {
		ShuttleLocation shuttleloc = slr.findByshuttleid(shuttleid);
		if (shuttleloc == null) return "";
		JSONObject shuttleinfo = new JSONObject();
		shuttleinfo.put("latitude", shuttleloc.getLatitude());
		shuttleinfo.put("longitude", shuttleloc.getLongitude());
		return shuttleinfo.toString();
	}
		
}
