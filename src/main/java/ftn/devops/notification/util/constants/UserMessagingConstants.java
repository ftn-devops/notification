package ftn.devops.notification.util.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMessagingConstants {

    @UtilityClass
    public class Exchange {

        public static final String USER = "user";
    }

    @UtilityClass
    public class Queue {

        public static final String USER_RATED =
            Exchange.USER + "." + MessagingConstants.SERVICE_NAME + "-" + RoutingKey.USER_RATED;
    }

    @UtilityClass
    public class RoutingKey {

        public static final String USER_RATED = "rate";
    }
}
