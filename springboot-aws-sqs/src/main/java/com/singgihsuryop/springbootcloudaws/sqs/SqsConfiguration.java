package com.singgihsuryop.springbootcloudaws.sqs;

import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.sqs.AmazonSQSAsync;

@Configuration
public class SqsConfiguration {

	@Bean
	public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQS) {
		return new QueueMessagingTemplate(amazonSQS);
	}

}


//@Bean
//public QueueMessagingTemplate queueMessagingTemplate(AmazonSQS amazonSqs, ResourceIdResolver resourceIdResolver)
//Optionally a ResourceIdResolver implementation can be passed to the QueueMessagingTemplate constructor to resolve resources by logical name when running inside a CloudFormation stack{
//  return new QueueMessagingTemplate(amazonSqs, resourceIdResolver);
//}