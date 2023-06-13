package com.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	
	//sending simple mail
	@PostMapping("/sendmail")
	public String sendsimplemail(@RequestBody Email email) {
		System.out.println("done");
		String status = this.emailService.sendSimpleEmail(email);
		return status;
	}
	
	//sending mail with attachment
	@PostMapping("/sendmailwithAttachment")
	public String sendwithAttachment(@RequestBody Email email) {
		String status = this.emailService.sendEmailWithAttachment(email);
		return status;
	}
}
