package com.example.zoho_crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.zoho_crm.entity.Lead;
import com.example.zoho_crm.restcontroller.LeadRestController;
import com.example.zoho_crm.services.LeadService;
import com.example.zoho_crm.util.ZohoEmail;

@Controller
public class LeadController {
	
	@Autowired
	private ZohoEmail zohoEmail;
	
	@Autowired
	private LeadService leadServ;
	
	// http://localhost:8080/view
	@RequestMapping("/view")
	public String view() {
		return "view";
	}
	
	//action = savelead like servlet
	@RequestMapping("/savelead")
	public String savelead(Lead lead) {
		leadServ.saveLeadService(lead);
		zohoEmail.zohoEmailSend(lead.getEmail(), "Welcome", "Thank you for car bokking");
		return "view";
	}
	
	//http:localhost:8080/listall
	@RequestMapping("/listall")
	public String listall(Lead lead,Model model) {
		List<Lead> leads = leadServ.listAllData(lead);
		model.addAttribute("leads",leads);
		return "listAll";
	}
	//deletelead
	@RequestMapping("/deletelead")
	public String deletelead(@RequestParam("id") long id,Model model,Lead lead) {
		leadServ.deleteOneLead(id);
		List<Lead> leads = leadServ.listAllData(lead);
		model.addAttribute("leads",leads);
		return "listAll";
	}
	
	//updatelead
	@RequestMapping("/updatelead")
	public String updatelead(@RequestParam("id") long id,ModelMap model) {
			Lead lead = leadServ.updateOneLead(id);
			model.addAttribute("lead", lead);
			return "lead_update";
	}
	
	@RequestMapping("/updateonelead")
	public String updateonelead(Lead lead,Model model){
		leadServ.saveLeadService(lead);
			
		List<Lead> leads = leadServ.listAllData(lead);
		model.addAttribute("leads",leads);
		return "listAll";
	}
}



