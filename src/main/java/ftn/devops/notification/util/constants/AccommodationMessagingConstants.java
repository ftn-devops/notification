package ftn.devops.notification.util.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AccommodationMessagingConstants {

    @UtilityClass
    public class Exchange {

        public static final String ACCOMMODATION = "accommodation";
    }

    @UtilityClass
    public class Queue {

        public static final String RESERVATION_STATUS_UPDATE =
            Exchange.ACCOMMODATION + "." + MessagingConstants.SERVICE_NAME + "-" + RoutingKey.RESERVATION_STATUS_UPDATE;

        public static final String ACCOMMODATION_RATED =
            Exchange.ACCOMMODATION + "." + MessagingConstants.SERVICE_NAME + "-" + RoutingKey.ACCOMMODATION_RATED;
    }

    @UtilityClass
    public class RoutingKey {

        public static final String RESERVATION_STATUS_UPDATE = "reservation-status-update";

        public static final String ACCOMMODATION_RATED = "accommodation-rated";
    }
}
