package lawrence.shuttle.rest;

import lawrence.shuttle.to.User;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

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

@RequestMapping("/user")
@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepo;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/passengers")
	public List<User> getPassengers() {
		return userRepo.findAllByRole("0");
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/drivers")
	public List<User> getDrivers() {
		return userRepo.findAllByRole("1");
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/changerole")
	public int changeRole(@RequestParam("userid") String userid) {
		User user = userRepo.findByUserid(userid);
		if (user != null) {
			if (user.getRole().equals("1")) {
				user.setRole("0");
			}
			else if (user.getRole().equals("0")) {
				user.setRole("1");
			}
			userRepo.saveAndFlush(user);
			return 0;
		}
		else return -1;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public int createNewUser(@RequestBody String user) {
		User newUser = new User();
		JSONObject obj = new JSONObject(user);
		if (userRepo.findByEmail(obj.getString("email")) != null) return 0;
		newUser.setName(obj.getString("name"));
		newUser.setPassword(obj.getString("password"));
		newUser.setEmail(obj.getString("email"));
		newUser.setPhonenumber(String.valueOf(obj.getInt("phonenumber")));
		newUser.setRole(obj.getString("role"));
		userRepo.saveAndFlush(newUser);
		return 1;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/checkuser")
	public String checkUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userRepo.findByEmailAndPassword(email, password);
		JSONObject userInfo = new JSONObject();
		if (user == null) {
			userInfo.put("userid", "");
			userInfo.put("role", "");
			userInfo.put("name", "");
			return userInfo.toString();
		}
		userInfo.put("userid", user.getUserid());
		userInfo.put("role", user.getRole());
		userInfo.put("name", user.getName());
		return userInfo.toString();
	}
	

}
