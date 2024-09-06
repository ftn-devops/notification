package ftn.devops.notification.messaging.listener.impl;

import ftn.devops.notification.email.IEmailService;
import ftn.devops.notification.messaging.listener.IMessageListener;
import ftn.devops.notification.messaging.messages.UserRatedMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ftn.devops.notification.util.constants.UserMessagingConstants.Queue;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRatedMessageListener implements IMessageListener<UserRatedMessage> {

    private static final String EMAIL_MESSAGE_FORMAT = "Your hospitality has been graded. \n Grade: %s.";

    private static final String EMAIL_SUBJECT = "Your hospitality has been graded.";

    private final IEmailService emailService;

    @Override
    @RabbitListener(queues = Queue.USER_RATED)
    public void receiveMessage(UserRatedMessage message) {
        log.info("Received user rated message {}", message);

        var emailText = String.format(EMAIL_MESSAGE_FORMAT, message.getRating());

        emailService.sendEmail(message.getRecipientEmail(), EMAIL_SUBJECT, emailText);
    }
}
