package ftn.devops.notification.messaging.listener.impl;

import ftn.devops.notification.messaging.listener.IMessageListener;
import ftn.devops.notification.messaging.messages.UserRatedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ftn.devops.notification.util.constants.UserMessagingConstants.Queue;

@Slf4j
@Service
public class UserRatedMessageListener implements IMessageListener<UserRatedMessage> {

    @Override
    @RabbitListener(queues = Queue.USER_RATED)
    public void receiveMessage(UserRatedMessage message) {
        log.info("Received user rated message {}", message);

        // TODO create email message object from received rabbitmq message
        // TODO call email service send method
    }
}
