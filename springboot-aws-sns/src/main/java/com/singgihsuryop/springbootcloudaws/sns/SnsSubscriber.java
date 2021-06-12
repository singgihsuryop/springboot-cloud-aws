package com.singgihsuryop.springbootcloudaws.sns;

import org.springframework.cloud.aws.messaging.endpoint.NotificationStatus;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationSubscriptionMapping;
import org.springframework.cloud.aws.messaging.endpoint.annotation.NotificationUnsubscribeConfirmationMapping;
import org.springframework.stereotype.Component;

@Component
public class SnsSubscriber {

	@NotificationSubscriptionMapping
	public void handleSubscriptionMessage(NotificationStatus notificationStatus) {
		notificationStatus.confirmSubscription();
	}
	
	@NotificationUnsubscribeConfirmationMapping
	public void handleUnsubscribeMessage(NotificationStatus notificationStatus) {
		notificationStatus.confirmSubscription();
	}
	
	public void handleNotificationMessage(String subject, String message) {
		
	}
}
