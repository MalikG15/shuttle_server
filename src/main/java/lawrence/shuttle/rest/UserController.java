package lawrence.shuttle.rest;

import lawrence.shuttle.to.User;

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
	@RequestMapping(value = "/newuser", method = RequestMethod.POST)
	public int createNewUser(@RequestBody String user) {
		User newUser = new User();
		JSONObject obj = new JSONObject(user);
		if (userRepo.findByEmail(obj.getString("email")) != null) return 0;
		newUser.setName(obj.getString("name"));
		newUser.setPassword(obj.getString("password"));
		newUser.setEmail(obj.getString("email"));
		newUser.setPhonenumber(obj.getString("phonenumber"));
		newUser.setRole(obj.getString("role"));
		userRepo.saveAndFlush(newUser);
		return 1;
	}
	
	@ResponseBody
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/checkuser")
	public List<String> checkUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		List<String> info = new ArrayList<String>();
		User user = userRepo.findByEmailAndPassword(email, password);
		info.add(user.getUserid());
		info.add(user.getRole());
		return info;
	}
	
	

}
