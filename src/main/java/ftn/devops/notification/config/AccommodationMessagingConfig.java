package ftn.devops.notification.config;

import ftn.devops.notification.util.constants.AccommodationMessagingConstants;
import ftn.devops.notification.util.constants.AccommodationMessagingConstants.Exchange;
import ftn.devops.notification.util.constants.AccommodationMessagingConstants.RoutingKey;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class AccommodationMessagingConfig {

    @Bean
    TopicExchange accommodationExchange() {
        return new TopicExchange(Exchange.ACCOMMODATION);
    }

    @Bean
    public Queue accommodationRatedQueue() {
        return new Queue(AccommodationMessagingConstants.Queue.ACCOMMODATION_RATED);
    }

    @Bean
    public Queue reservationStatusUpdateQueue() {
        return new Queue(AccommodationMessagingConstants.Queue.RESERVATION_STATUS_UPDATE);
    }

    @Bean
    Binding accommodationRatedBinding() {
        return BindingBuilder.bind(accommodationRatedQueue())
            .to(accommodationExchange())
            .with(RoutingKey.ACCOMMODATION_RATED);
    }

    @Bean
    Binding reservationStatusUpdateBinding() {
        return BindingBuilder.bind(reservationStatusUpdateQueue())
            .to(accommodationExchange())
            .with(RoutingKey.RESERVATION_STATUS_UPDATE);
    }
}
