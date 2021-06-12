package com.singgihsuryop.springbootcloudaws.sqs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sqs")
public class SqsEndpoint {
	
	private static final Logger LOG = LoggerFactory.getLogger(SqsEndpoint.class);
	
	private static final String QUEUE_NAME = "sqs-queue";
	
	@Autowired
	private QueueMessagingTemplate amazonSQS;
	
	@RequestMapping(value = "/sendToQueue", method = RequestMethod.GET)
	public String sendMessageToQueue(@RequestParam("message") String message) {
		amazonSQS.convertAndSend(QUEUE_NAME, message);
		
		return "Message sent to queue ".concat(QUEUE_NAME);
	}
	
	@SqsListener(QUEUE_NAME)
	public void messageReceiver(String message) {
		
		LOG.info("Listener {} is receiving a message: {}", QUEUE_NAME, message);
	}
	
}
