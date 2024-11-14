package com.example.zoho_crm.services;

import java.util.List;

import com.example.zoho_crm.entity.Lead;


public interface LeadService {
	public void saveLeadService(Lead lead);
	public List<Lead> listAllData(Lead lead);
	public void deleteOneLead(long id);
	public Lead updateOneLead(long id);

}


