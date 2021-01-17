package org.addresses.services;

import org.addresses.models.Email;
import org.addresses.models.EmailAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    private final JavaMailSender sender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.sender = mailSender;
    }

    public void sendSimpleEmail(Email email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EmailAddress.TO_EMAIL);
        message.setSubject(email.getHeading());
        message.setText(email.getBody());
        sender.send(message);
    }

}
