package ftn.devops.notification.messaging.listener.impl;

import ftn.devops.notification.email.IEmailService;
import ftn.devops.notification.messaging.listener.IMessageListener;
import ftn.devops.notification.messaging.messages.AccommodationRatedMessage;
import ftn.devops.notification.util.constants.AccommodationMessagingConstants.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccommodationRatedMessageListener implements IMessageListener<AccommodationRatedMessage> {

    private static final String EMAIL_MESSAGE_FORMAT = "Your accommodation %s has been graded. \n Grade: %s.";

    private static final String EMAIL_SUBJECT = "Your accommodation has been graded.";
    
    private final IEmailService emailService;
    
    @Override
    @RabbitListener(queues = Queue.ACCOMMODATION_RATED)
    public void receiveMessage(AccommodationRatedMessage message) {
        log.info("Received reservation status update message {}", message);

        var emailText = String.format(EMAIL_MESSAGE_FORMAT, message.getAccommodationName(), message.getRating());

        emailService.sendEmail(message.getRecipientEmail(), EMAIL_SUBJECT, emailText);
    }
}
