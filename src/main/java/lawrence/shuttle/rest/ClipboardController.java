package lawrence.shuttle.rest;

import lawrence.shuttle.to.Clipboard;
import lawrence.shuttle.data.ClipboardRepository;

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


import org.json.*;	

@RequestMapping("/clipboard")
@RestController
public class ClipboardController {
	
	@Autowired
	ClipboardRepository clipRepo;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/checkin", method = RequestMethod.POST)
	public int checkIn(@RequestBody String checkinUser) {
		JSONObject obj = new JSONObject(checkinUser);
		Clipboard clip = new Clipboard();
		if (clipRepo.findByUserid(obj.getString("userid")) != null) return 0;
		clip.setUserid(obj.getString("userid"));
		clip.setLatitude(obj.getString("latitude"));
		clip.setLongitude(obj.getString("longitude"));
		clip.setClipboardsessionid(obj.getString("clipboardsessionid"));
		clipRepo.saveAndFlush(clip);
		return 1;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/checkout")
	public int checkOut(@RequestParam("userid") String userid) {
		Clipboard clip = clipRepo.findByUserid(userid);
		if (clip == null) return -1;
		clipRepo.deleteUsersByUserid(userid);
		return 0;
	}
	

}
