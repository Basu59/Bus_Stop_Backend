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

import net.backend.springboot.Repository.SchRepository;
import net.backend.springboot.ResourceNotFoundException.ResourceNotFoundException;
import net.backend.springboot.model.Sche;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus")
public class ScheduleController {

	@Autowired
	private SchRepository schRepository;
	
	
	//get
	@GetMapping("/addsch")
	public List<Sche> getAllSchedule(){
		return schRepository.findAll();
		
		}
	// create rest api
	@PostMapping("/addsch")
	public Sche createSche(@RequestBody  Sche sche) {
		return schRepository.save(sche);
		}
	@GetMapping("/addsch/{id}")
	public ResponseEntity<Sche>getScheduleById(@PathVariable Long id) {
		Sche sche = schRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(sche);
	}
	// update rest api
	@PutMapping("/addsch/{id}")
	public ResponseEntity<Sche> updateSchedule(@PathVariable Long id, @RequestBody Sche scheDetails){
		Sche sche= schRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
		sche.setBusno(scheDetails.getBusno());		
		sche.setAritime(scheDetails.getAritime());		
		sche.setDeptime(scheDetails.getDeptime());		

	       Sche updatedsche  =  schRepository.save(sche);
	        return ResponseEntity.ok(updatedsche);
		
	}
	// Delete rest api
	@DeleteMapping("/addsch/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSchedule(@PathVariable Long id){
		Sche sche= schRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		schRepository.delete(sche);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
}