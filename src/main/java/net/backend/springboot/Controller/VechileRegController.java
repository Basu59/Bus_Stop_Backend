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


import net.backend.springboot.Repository.VechileRegRepository;
import net.backend.springboot.ResourceNotFoundException.ResourceNotFoundException;
import net.backend.springboot.model.VechileReg;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/bus")
public class VechileRegController {
	
	
	@Autowired
	private VechileRegRepository vechRepository;
	
	
	@GetMapping("/addvech")
	public List<VechileReg> getAllVech(){
		return vechRepository.findAll();
		
		}
	// create rest api
		@PostMapping("/addvech")
		public VechileReg createVech(@RequestBody  VechileReg vh) {
			return vechRepository.save(vh);
			}
		@GetMapping("/addvech/{id}")
		public ResponseEntity<VechileReg>getVechById(@PathVariable Long id) {
			VechileReg vh = vechRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
			return ResponseEntity.ok(vh);
		}
		
		//upadating 
		
		@PutMapping("/addvech/{id}")
		public ResponseEntity<VechileReg> updateVechile(@PathVariable Long id, @RequestBody VechileReg vechdetails){
			VechileReg vh= vechRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
			
			vh.setBusno(vechdetails.getBusno());		
			vh.setVechileno(vechdetails.getVechileno());
			vh.setBrand(vechdetails.getBrand());
			vh.setModelno(vechdetails.getModelno());
			
		       VechileReg updateVechile  =  vechRepository.save(vh);
		        return ResponseEntity.ok(updateVechile);
	
}
		// Delete rest api
		@DeleteMapping("/addvech/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteVech(@PathVariable Long id){
			VechileReg vh= vechRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
			
			vechRepository.delete(vh);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}		

}
