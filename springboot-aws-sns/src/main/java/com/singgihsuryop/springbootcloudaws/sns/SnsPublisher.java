package com.singgihsuryop.springbootcloudaws.sns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.sns.AmazonSNS;

@RestController("/sns")
public class SnsPublisher {

private static final Logger LOG = LoggerFactory.getLogger(SnsPublisher.class);
	
	private static final String TOPIC_NAME = "sns-topic";
	
	private AmazonSNS amazonSNS;
	
	@RequestMapping(value="/sendToTopic", method=RequestMethod.GET)
	public String sendMessageToTopic(@RequestParam("message") String message) {
		amazonSNS.publish(TOPIC_NAME, message);
		return "Message sent to topic ".concat(TOPIC_NAME);
	}
	
}
