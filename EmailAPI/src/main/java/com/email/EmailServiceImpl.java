package com.email;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String sender;
	
	
	public String sendSimpleEmail(Email email) {
			
		try {
			
			
			//creating a simple mail message
			SimpleMailMessage simplemailmessage=new SimpleMailMessage();
			
			//setting up necessary details
			simplemailmessage.setFrom(sender);
			System.out.println("from set");
			simplemailmessage.setTo(email.getRecipient());
			simplemailmessage.setText(email.getMessage());
			simplemailmessage.setSubject(email.getSubject());
			System.out.println("properties setted");
			//sending the mail
			System.out.println("sending mail");
			javaMailSender.send(simplemailmessage);
			System.out.println("sent");
			return "Mail Sent Successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	
	//method 2
	//sending mail with attachment

	@Override
	public String sendEmailWithAttachment(Email email) {
		
		//creating a mimemessage
		MimeMessage mimemessage=javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		
		try {
			//setting multipart as true for attachment to be send
			
			mimeMessageHelper=new MimeMessageHelper(mimemessage,true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(email.getRecipient());
			mimeMessageHelper.setText(email.getMessage());
			mimeMessageHelper.setSubject(email.getSubject());
			
			
			//adding the attachment
			
			FileSystemResource file=new FileSystemResource(new File(email.getAttachment()));
			
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			
			//sending the mail
			
			javaMailSender.send(mimemessage);
			return "Mail sent successfully";
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error while sending the mail";
		}
		
	
	}

}
