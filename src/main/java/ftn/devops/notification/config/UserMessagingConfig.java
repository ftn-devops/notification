package ftn.devops.notification.config;

import ftn.devops.notification.util.constants.UserMessagingConstants;
import ftn.devops.notification.util.constants.UserMessagingConstants.Exchange;
import ftn.devops.notification.util.constants.UserMessagingConstants.RoutingKey;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class UserMessagingConfig {

    @Bean
    TopicExchange userExchange() {
        return new TopicExchange(Exchange.USER);
    }

    @Bean
    public Queue userRatedQueue() {
        return new Queue(UserMessagingConstants.Queue.USER_RATED);
    }


    @Bean
    Binding userCreateBinding() {
        return BindingBuilder.bind(userRatedQueue())
            .to(userExchange())
            .with(RoutingKey.USER_RATED);
    }
}
