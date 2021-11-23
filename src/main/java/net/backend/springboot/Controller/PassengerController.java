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

import net.backend.springboot.Repository.PassengerRepository;
import net.backend.springboot.ResourceNotFoundException.ResourceNotFoundException;
import net.backend.springboot.model.Passenger;
//BusDetail
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus")
public class PassengerController {
	@Autowired
	private PassengerRepository passengerRepository;
	
	@GetMapping("/addpas")
	public List<Passenger> getAllPassenger(){
		return passengerRepository.findAll();
		
		}
	// create employee rest api
	@PostMapping("/addpas")
	public Passenger createPassenger(@RequestBody  Passenger passenger) {
		return passengerRepository.save(passenger);
		}
	@GetMapping("/addpas/{id}")
	public ResponseEntity<Passenger>getPassengerById(@PathVariable Long id) {
		Passenger passenger = passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(passenger);
	}
	// update rest api
	@PutMapping("/addpas/{id}")
	public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails){
		Passenger passenger= passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
		passenger.setFirstname(passengerDetails.getFirstname());
		passenger.setLastname(passengerDetails.getLastname());
		passenger.setEmailid(passengerDetails.getEmailid());
		passenger.setMobileno(passengerDetails.getMobileno());
		Passenger updatePassenger = passengerRepository.save(passenger);
		return ResponseEntity.ok(updatePassenger);
	
		
	}
	// Delete rest api
	@DeleteMapping("/addpas/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePassenger(@PathVariable Long id){
		Passenger passenger= passengerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		passengerRepository.delete(passenger);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
