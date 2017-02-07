package lawrence.shuttle.rest;

import lawrence.shuttle.to.Route;
import lawrence.shuttle.data.RouteRepository;

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

@RequestMapping("/route")
@RestController
public class RouteController {
	
	@Autowired
	RouteRepository routeRepo;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getroute")
	public Route getRoute(@RequestParam("routeid") String routeid) {
		return routeRepo.findByRouteid(routeid);
	}

}
