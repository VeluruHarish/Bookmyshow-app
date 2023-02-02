package com.hm.Capstoneproject.gmail.Repository;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;

import com.hm.Capstoneproject.gmail.model.Booking;
import com.hm.Capstoneproject.gmail.model.EmailDetails;
import com.hm.Capstoneproject.gmail.model.User;
import com.netflix.discovery.converters.Auto;


@Service
public  class EmailServiceImpl implements EmailService {
	
	private EmailDetails userDetails;
	
	 @Autowired private JavaMailSender javaMailSender;
	
	   @Value("${spring.mail.username}") private String sender;

	@Override
	public String sendSimpleMail(EmailDetails details) {
		
		
		 try {
			 
	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();
	            System.out.println("done");
	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(details.getRecipient());
	            mailMessage.setText(details.getMsgBody());
	            mailMessage.setSubject(details.getSubject());
	           
	            javaMailSender.send(mailMessage);
	            System.out.println("mail");
	            return "Mail Sent Successfully...";
	        }
	 
	        catch (Exception e) {
	            return "Error while Sending Mail";
	        }
	    }
	public void Email(User user) {
		 EmailDetails details2 = new EmailDetails();
		 details2.setRecipient(user.getEmail());
		 userDetails=details2;
		 System.out.println(details2);
	}
	public void Ticket(Booking booking) {
	    EmailDetails details1 = new EmailDetails();
		String bodymsg = "Hi!....Thanks for choosing"+booking.getMultiplexName()+" Your booking is Successfull with booking Id"+booking.getId()+"with Seat No's"+booking.getBookedSeatNos()+"for the movie"
				+booking.getMovieName()+"in the screen"+booking.getScreenName()+"for the show"+booking.getShowtime()+"Enjoy the Show😎....for more multiplexdetails"+booking.getMultiplexAddress();
	 details1.setMsgBody(bodymsg);
	 details1.setSubject("Movie Ticket Booking Confirmation");
	 details1.setRecipient("veluruharish4503@gmail.com");
		sendSimpleMail(details1);
		System.out.println(details1);
		
	}
}
