package userlogin.service;

import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;


public class PasscodeMailService {
	
	 
	public void sendEmail() throws MessagingException
	   
	{
		
		 String from="dmurugesan67@gmail.com";
		 String password ="******";
		 String to="dmurugesan67@gmail.com";
		 String sub = "test";
		 String msg="How r u?";
		  Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
                    "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          //get Session   
          Session session = Session.getDefaultInstance(props,    
           new javax.mail.Authenticator() {    
           protected PasswordAuthentication getPasswordAuthentication() {    
           return new PasswordAuthentication(from,password);  
           }    
          });    
         
          try {    
           MimeMessage message = new MimeMessage(session);    
           message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
           message.setSubject(sub);    
           message.setText(msg);      
           Transport.send(message);    
           System.out.println("message sent successfully");    
          } catch (MessagingException e) {throw new RuntimeException(e);}    
             
    }  

    }
	
	

