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
import net.backend.springboot.Repository.StopRepository;
import net.backend.springboot.ResourceNotFoundException.ResourceNotFoundException;
import net.backend.springboot.model.Stop;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus")
public class StopContoller {
	@Autowired
	private StopRepository stopRepository;
	
	
	@GetMapping("/addstop")
	public List<Stop> getAllStop(){
		return stopRepository.findAll();
		
		}
	// create rest api
		@PostMapping("/addstop")
		public Stop createSche(@RequestBody  Stop st) {
			return stopRepository.save(st);
			}
		@GetMapping("/addstop/{id}")
		public ResponseEntity<Stop>getScheduleById(@PathVariable Long id) {
			Stop st = stopRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
			return ResponseEntity.ok(st);
		}
		
		//upadating 
		
		@PutMapping("/addstop/{id}")
		public ResponseEntity<Stop> updateSchedule(@PathVariable Long id, @RequestBody Stop stopdetails){
			Stop st= stopRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
			
			st.setBusno(stopdetails.getBusno());		
			st.setOrigin(stopdetails.getOrigin());		
			st.setDestination(stopdetails.getDestination());		

		       Stop updatedstop  =  stopRepository.save(st);
		        return ResponseEntity.ok(updatedstop);
	
}
		// Delete rest api
		@DeleteMapping("/addstop/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteStop(@PathVariable Long id){
			Stop st= stopRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
			
			stopRepository.delete(st);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}		
}
