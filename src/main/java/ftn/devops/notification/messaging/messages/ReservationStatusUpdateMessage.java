package ftn.devops.notification.messaging.messages;

public class ReservationStatusUpdateMessage extends BaseMessage{

    String recipientEmail;

    String accommodationName;

    String reservationStatus;
}
