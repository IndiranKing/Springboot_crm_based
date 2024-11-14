package com.example.zoho_crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.zoho_crm.entity.Lead;
import com.example.zoho_crm.repository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {
	@Autowired
	private LeadRepository leadRepo;
	@Override
	public void saveLeadService(Lead lead) {
		
		leadRepo.save(lead);
	}
	@Override
	public List<Lead> listAllData(Lead lead) {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}
	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
	}
	@Override
	public Lead updateOneLead(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}	

}
