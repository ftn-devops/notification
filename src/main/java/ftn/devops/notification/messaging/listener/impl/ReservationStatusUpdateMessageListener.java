package ftn.devops.notification.messaging.listener.impl;

import ftn.devops.notification.email.IEmailService;
import ftn.devops.notification.messaging.listener.IMessageListener;
import ftn.devops.notification.messaging.messages.ReservationStatusUpdateMessage;
import ftn.devops.notification.util.constants.AccommodationMessagingConstants.Queue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReservationStatusUpdateMessageListener implements IMessageListener<ReservationStatusUpdateMessage> {

    private static final String EMAIL_MESSAGE_FORMAT = "Your reservation in %s has been updated. \n Status: %s.";

    private static final String EMAIL_SUBJECT = "Your reservation has been updated.";

    private final IEmailService emailService;

    @Override
    @RabbitListener(queues = Queue.RESERVATION_STATUS_UPDATE)
    public void receiveMessage(ReservationStatusUpdateMessage message) {
        log.info("Received reservation status update message {}", message);

        var emailText = String.format(EMAIL_MESSAGE_FORMAT, message.getAccommodationName(),
            message.getReservationStatus());

        emailService.sendEmail(message.getRecipientEmail(), EMAIL_SUBJECT, emailText);
    }
}
