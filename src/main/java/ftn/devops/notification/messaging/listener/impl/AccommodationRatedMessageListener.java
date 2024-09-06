package ftn.devops.notification.messaging.listener.impl;

import ftn.devops.notification.messaging.listener.IMessageListener;
import ftn.devops.notification.messaging.messages.AccommodationRatedMessage;
import ftn.devops.notification.util.constants.AccommodationMessagingConstants.Queue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccommodationRatedMessageListener implements IMessageListener<AccommodationRatedMessage> {

    @Override
    @RabbitListener(queues = Queue.RESERVATION_STATUS_UPDATE)
    public void receiveMessage(AccommodationRatedMessage message) {
        log.info("Received reservation status update message {}", message);

        // TODO create email message object from received rabbitmq message
        // TODO call email service send method
    }
}
