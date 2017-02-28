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
		Route route = routeRepo.findByRouteid(routeid);
		if (route == null) return null;
		return route;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/changeassignment")
	public int assignRoute(@RequestParam("routeid") String routeid) {
		Route route = routeRepo.findByRouteid(routeid);
		if (route != null) {
			if (route.getAssigned().equals("0")) route.setAssigned("1");
			else if (route.getAssigned().equals("1")) route.setAssigned("0");
			routeRepo.saveAndFlush(route);
			return 1;
		}
		return 0;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/deleteroute")
	public int deleteRoute(@RequestParam("routeid") String routeid) {
		Route route = routeRepo.findByRouteid(routeid);
		if (route != null) {
			routeRepo.deleteRouteByRouteid(routeid);
			return 1;
		}
		else return 0;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getall") 
	public List<Route> findAllRoutes() {
		return routeRepo.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/getassigned")
	public Route getAssigned() {
		Route route = routeRepo.findRouteByAssigned(1);
		if (route == null) return null;
		return route;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public int createRoute(@RequestBody String route) {
		JSONObject routeObj = new JSONObject(route);
		Route newRoute = new Route();
		if (routeObj.getString("name").isEmpty() || routeObj.getString("stops").isEmpty()) return 0;
		newRoute.setName(routeObj.getString("name"));
		newRoute.setStops(routeObj.getString("stops"));
		newRoute.setDescription(routeObj.getString("description"));
		newRoute.setAssigned("0");
		routeRepo.saveAndFlush(newRoute);
		return 1;
	}
	

}
