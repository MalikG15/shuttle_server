package lawrence.shuttle.rest;

import lawrence.shuttle.to.Clipboard;
import lawrence.shuttle.to.User;
import lawrence.shuttle.data.ClipboardRepository;
import lawrence.shuttle.data.UserRepository;

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
	
	@Autowired
	UserRepository userRepo;
	
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
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/status")
	public int passengerStatus(@RequestParam("userid") String userid) {
		Clipboard clip = clipRepo.findByUserid(userid);
		if (clip == null) return 0;
		return 1;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/get")
	public List<Clipboard> getClipboard() {
		return clipRepo.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getuserinfo", method = RequestMethod.POST)
	public String getUserInfo(@RequestBody String userInfo) {
		System.out.print(userInfo);
		List<JSONObject> users = new ArrayList<JSONObject>();
		JSONArray test = new JSONObject(userInfo).getJSONArray("users");
		
		for (int x = 0; x < test.length(); x++) {
			JSONObject temp = new JSONObject();
			User singleUser = userRepo.findByUserid(test.getJSONObject(x).getString("userid"));
			temp.put("name", singleUser.getName());
			temp.put("phonenumber", singleUser.getPhonenumber());
			users.add(temp);
		}
		
		System.out.println(new JSONObject().put("users", users).toString());
		return new JSONObject().put("users", users).toString();
	}

}
