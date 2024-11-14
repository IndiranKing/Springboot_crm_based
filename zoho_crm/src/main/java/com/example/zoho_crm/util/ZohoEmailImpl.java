package com.example.zoho_crm.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class ZohoEmailImpl implements ZohoEmail {

	@Autowired
	private JavaMailSender sender;
	
	@Override
	public void zohoEmailSend(String to, String sub, String text) {
		SimpleMailMessage sim=new SimpleMailMessage();
		sim.setTo(to);
		sim.setSubject(sub);
		sim.setText(text);
		
		sender.send(sim);
	}

}
