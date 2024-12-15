package com.example.mvc5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mvc5.model.ModelData;
import com.example.mvc5.repository.ModelData_Repo;
@Service
public class ModelData_Service {

	@Autowired
	private ModelData_Repo md_repo;
	
	// collection of data get
	public List<ModelData> list_allUser(ModelData data) {
		List<ModelData> modeldata = md_repo.findAll();
		for(ModelData m : modeldata) {
			m.setEmail(maskEmail(m.getEmail()));
			m.setPhone(maskNumber(m.getPhone()));
		}
		return modeldata;
	}
	// single data get 
	public ModelData getUserById(Long id) {
		ModelData user = md_repo.findById(id).orElse(null);
		if(user != null) {
			user.setEmail(maskEmail(user.getEmail()));
			user.setPhone(maskNumber(user.getPhone()));
		}
		return user;
	}
	
	public ModelData saveUser(ModelData lead) {
		return md_repo.save(lead);
	}
	public ModelData updateUser(ModelData lead) {
		return md_repo.save(lead);
	}
	public void userDeleteById(Long id) {
		md_repo.deleteById(id);
	}
	
	// maskEmail id
	private String maskEmail(String email) {
		int atIndex = email.indexOf("@");
		if (atIndex>1) {
			return email.charAt(0) + "***" +email.substring(atIndex-1);
		}
		return email;
	}
	//maskPhone no
	private String maskNumber(String phone) {
		return phone.replaceAll("\\d(?=\\d{4})", "*");
	}
}
