package com.example.zoho_crm.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.zoho_crm.entity.Lead;
import com.example.zoho_crm.repository.LeadRepository;

@RestController
public class LeadRestController {
	
	@Autowired
	private LeadRepository LeadRep;
	
	//http://localhost:8080/list_all_api
	@GetMapping("/list_all_api")
	public List<Lead> createJSONdata(Lead lead){
		List<Lead> leads = LeadRep.findAll();
		return leads;
	}
	
	@PostMapping("/save_api") //http://localhost:8080/save_api
	public void saveApi(@RequestBody Lead lead) {
		LeadRep.save(lead);
	}
	
	@PutMapping("/update_api") //http://localhost:8080/update_api
	public void updateApi(@RequestBody Lead lead) {
		LeadRep.save(lead);
	}
	
	//http://localhost:8080/delete_api/2
	@DeleteMapping("/delete_api/{id}") 
	public void deleteApi(@PathVariable("id") long id) {
		LeadRep.deleteById(id);
	}
}
