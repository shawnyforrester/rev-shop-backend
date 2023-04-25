package com.app.Service;

import com.app.Model.Buyer;
import com.app.Model.User;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendRegistrationEmail(Buyer buyer) throws MessagingException, UnsupportedEncodingException {

        String toAddress = buyer.getEmail();
        String fromAddress = "revshoptest@gmail.com";
        String senderName = "RevShop";
        String subject = "Thank you for registering to RevShop!";
        String content = "Dear " + buyer.getName() + ",<br>"
                + "Welcome to RevShop! <br> " +
                "To access your account, enter this temporary password:<br>" +
                buyer.getPassword() + "<br>"
                + "Thank you,<br>"
                + "RevShop.";


        MimeMessage message = mailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper
                = new MimeMessageHelper(message, true);

        mimeMessageHelper.setFrom(fromAddress, senderName);
        mimeMessageHelper.setTo(toAddress);
        mimeMessageHelper.setText(content);
        mimeMessageHelper.setSubject(subject);


        mimeMessageHelper.setText(content, true);

        mailSender.send(message);
    }


}
