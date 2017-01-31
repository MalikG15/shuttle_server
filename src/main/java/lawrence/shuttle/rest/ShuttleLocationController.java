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

@RequestMapping("/shuttle")
@RestController
public class ShuttleLocationController {
	
	@Autowired
	ShuttleLocationRepository slr;

	@ResponseBody
	@RequestMapping(value = "/coordinates")
	public String getShuttleCoordinates(@RequestParam("shuttleid") String shuttleid) {
		//return String.valueOf(slr.findLattitudeByShuttleId(shuttleid)) + String.valueOf(slr.findLongitudeByShuttleId(shuttleid));
		return "";
	}
		
}
