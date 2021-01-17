package org.addresses.controllers;

import org.addresses.models.Changes;
import org.addresses.models.Email;
import org.addresses.repositories.ChengesRepository;
import org.addresses.repositories.EmailRepository;
import org.addresses.services.EmailService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    private final ChengesRepository chengesRepository;
    private final EmailRepository emailRepository;
    private final EmailService emailService;

    public Receiver(ChengesRepository chengesRepository, EmailRepository emailRepository, EmailService emailService) {
        this.chengesRepository = chengesRepository;
        this.emailRepository = emailRepository;
        this.emailService = emailService;
    }

    @JmsListener(destination = "changebox", containerFactory = "myFactory")
    public void receiveChange(Changes change) {
        chengesRepository.save(change);
    }

    @JmsListener(destination = "emailbox", containerFactory = "myFactory")
    public void receiveEmail(Email email) {
        emailService.sendSimpleEmail(email);
        emailRepository.save(email);
    }
}
