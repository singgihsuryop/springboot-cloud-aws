package com.singgihsuryop.springbootcloudaws.sns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.context.config.annotation.EnableContextInstanceData;

@SpringBootApplication
public class SpringbootAwsCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsCloudApplication.class, args);
	}

}
