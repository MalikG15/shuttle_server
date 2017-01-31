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

	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/coordinates")
	public ShuttleLocation getShuttleCoordinates(@RequestParam("shuttleid") String shuttleid) {
		ShuttleLocation shuttle = slr.findLattitudeAndLongitudeByshuttleid(shuttleid);
		return shuttle;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getit", method = RequestMethod.POST)
	public void postShuttleCoordinates(@RequestBody String coordinates) {
		System.out.println(coordinates);
		ShuttleLocation newLoc = new ShuttleLocation();
		JSONObject obj = new JSONObject(coordinates);
		newLoc.setShuttleid(obj.getString("shuttleid"));
		newLoc.setLongitude(obj.getInt("longitude"));
		newLoc.setLattitude(obj.getInt("latitude"));
		newLoc.setId(4);
		slr.saveAndFlush(newLoc);
	}
		
}
