package com.app.Service;

import com.app.Model.Buyer;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

//    public void sendRegistrationEmail(Buyer buyer){
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setFrom("revproshop@gmail.com");
//        message.setTo(buyer.getEmail());
//        message.setText("hello" + buyer.getName());
//        message.setSubject("welcome to revshop");
//
//        mailSender.send(message);
//    }

    public void sendRegistrationEmail(Buyer buyer) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(message, true);

        mimeMessageHelper.setFrom("revshoptest@gmail.com");
        mimeMessageHelper.setTo(buyer.getEmail());
        mimeMessageHelper.setText("hello");
        mimeMessageHelper.setSubject("test");

        mailSender.send(message);
    }


}
