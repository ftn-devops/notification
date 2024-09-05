package ftn.devops.notification;

import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
@AllArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public void sendMailBookingRequest(String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("host@booking.com");
        message.setTo(to);
        message.setSubject(String.format("Accomodation Booking Request"));
        message.setText(text);

        mailSender.send(message);
    }

    public String generateBookingRequestText(String start, String end, String customerId, String accomodationId) {

        return String.format("New Booking Request: \n" +
                "start: %s\n" +
                "end: %s\n" +
                "customer id: %s\n" +
                "accomodation id: %s\n", start, end, customerId, accomodationId);
    }

}
