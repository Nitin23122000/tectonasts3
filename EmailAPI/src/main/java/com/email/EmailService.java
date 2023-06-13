package com.email;

import org.springframework.stereotype.Service;


public interface EmailService {

	
	//method to send the simple mail
	String sendSimpleEmail(Email emaildetails);
	
	//method to send the mail with attachment
	String sendEmailWithAttachment(Email emaildetails);
	
	
	
}
