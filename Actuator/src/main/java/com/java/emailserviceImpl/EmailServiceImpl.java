package com.java.emailserviceImpl;
import org.springframework.beans.factory.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl 
{
	@Autowired 
	private JavaMailSender javaMailSender;
	 
    public String sendSimpleMail(int Statuscode)
    {
//    	String Status=Integer.toString(Statuscode);
        try
        {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom("birunesh@gmail.com");
            mailMessage.setTo("sivalingamp165@gmail.com");
            mailMessage.setSubject("Application Status Checking....!");
            mailMessage.setText(" http code status code is...!  "+Statuscode);
 
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...!";
        }
 
        catch (Exception e) 
        {
            return "Error while Sending Mail";
        }
    }

	
    
   
 

	
}
