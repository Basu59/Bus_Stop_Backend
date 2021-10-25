package net.backend.springboot.Controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.backend.springboot.Repository.RouteRepository;
import net.backend.springboot.ResourceNotFoundException.ResourceNotFoundException;
import net.backend.springboot.model.Route;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus")
public class RouteController {

	@Autowired
	private RouteRepository routeRepository;
	
	
	//get
	@GetMapping("/addrou")
	public List<Route> getAllRoute(){
		return routeRepository.findAll();
		
		}
	// create employee rest api
	@PostMapping("/addrou")
	public Route createRoute(@RequestBody  Route rou) {
		return routeRepository.save(rou);
		}
	@GetMapping("/addrou/{id}")
	public ResponseEntity<Route>getRouteById(@PathVariable Long id) {
		Route rou = routeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(rou);	}
	// update rest api
	@PutMapping("/addrou/{id}")
	public ResponseEntity<Route> updateRoute(@PathVariable Long id, @RequestBody Route rouDetails){
		Route rou = routeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
		rou.setBusno(rouDetails.getBusno());		
		rou.setRouteno(rouDetails.getRouteno());		
		rou.setOrigin(rouDetails.getOrigin());		
		rou.setDestination(rouDetails.getDestination());		

	       Route updatedrou  =  routeRepository.save(rou);
	        return ResponseEntity.ok(updatedrou);
		
	}
	// Delete rest api
	@DeleteMapping("/addrou/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRoute(@PathVariable Long id){
		Route rou= routeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		routeRepository.delete(rou);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}