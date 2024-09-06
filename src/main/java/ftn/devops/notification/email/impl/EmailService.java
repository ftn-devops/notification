package ftn.devops.notification.email.impl;

import ftn.devops.notification.email.IEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements IEmailService {

    private final JavaMailSender mailSender;

    @Value("${devops.email.username}")
    private String from;

    @Override
    public void sendEmail(String to, String subject, String body) {
        var message = new SimpleMailMessage();

        message.setFrom(from);
        message.setSubject(subject);
        message.setText(body);
        message.setTo(to);

        mailSender.send(message);
    }
}
