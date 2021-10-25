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

import net.backend.springboot.Repository.BusDetailsRepository;
import net.backend.springboot.ResourceNotFoundException.ResourceNotFoundException;
import net.backend.springboot.model.BusDetails;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus")
public class BusDetailsController {
	@Autowired
	private BusDetailsRepository busDetailsRepository;
	
	@GetMapping("/addbusd")
	public List<BusDetails> getAllDetails(){
		return busDetailsRepository.findAll();
		
		}
	// create employee rest api
	@PostMapping("/addbusd")
	public BusDetails createDetails(@RequestBody  BusDetails busDetails) {
		return busDetailsRepository.save(busDetails);
		}
	@GetMapping("/addbusd/{id}")
	public ResponseEntity<BusDetails>getDetailsById(@PathVariable Long id) {
		BusDetails busDetails = busDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(busDetails);
	}
	// update rest api
	@PutMapping("/addbusd/{id}")
	public ResponseEntity<BusDetails> updateDetails(@PathVariable Long id, @RequestBody BusDetails details){
		BusDetails busDetails= busDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
		busDetails.setBusno(details.getBusno());
		busDetails.setDrivername(details.getDrivername());
		busDetails.setMobileno(details.getMobileno());
		BusDetails updateDetails = busDetailsRepository.save(busDetails);
		return ResponseEntity.ok(updateDetails);
	
		
	}
	// Delete rest api
	@DeleteMapping("/addbusd/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteDetails(@PathVariable Long id){
		BusDetails busDetails= busDetailsRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		busDetailsRepository.delete(busDetails);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
	
