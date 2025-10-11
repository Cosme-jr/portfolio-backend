package com.cosme.portfolio_backend.service;

import com.cosme.portfolio_backend.model.ContactRequest;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}") // Pega o email do application.properties
    private String fromEmail;

    public void sendContactEmail(ContactRequest request){
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromEmail);// Define o remetente
            helper.setTo("seu.email@exemplo.com"); // substitua pelo seu email de destino
            helper.setSubject("New Contact Request from " + request.getName());
            helper.setText("Email: " + request.getEmail() + "\n\nMessage:\n" + request.getMessage());
            mailSender.send(message);
        } catch (Exception e) {
            throw new  RuntimeException("Failed to send email" + e.getMessage());
        }
    }
}
