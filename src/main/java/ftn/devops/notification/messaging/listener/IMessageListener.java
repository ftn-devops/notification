package ftn.devops.notification.messaging.listener;

import ftn.devops.notification.messaging.messages.BaseMessage;

public interface IMessageListener<T extends BaseMessage> {

    void receiveMessage(T message);
}
