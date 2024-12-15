package com.example.mvc5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mvc5.model.ModelData;
import com.example.mvc5.service.ModelData_Service;



@RestController
@RequestMapping("/api")
public class ModelData_Controller {
	
	@Autowired
	private ModelData_Service md_service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ModelData> getUserById(@PathVariable Long id){
		return ResponseEntity.ok(md_service.getUserById(id));
	}
	
	@GetMapping("/list_all_api")
	public List<ModelData> createJSONdata(ModelData lead){
		return md_service.list_allUser(lead);
	}
	
	@PostMapping("/save_api")
	public ModelData saveApi(@RequestBody ModelData lead) {
		return md_service.saveUser(lead);
	}
	
	@PutMapping("/update_api")
	public ModelData updateApi(@RequestBody ModelData lead) {
		return md_service.updateUser(lead);
	}
	
	@DeleteMapping("/delete_api/{id}")
	public void deleteByIdApi(@PathVariable("id") long id) {
		//leadrepo.deleteById(id);
		 md_service.userDeleteById(id);
	}

}
