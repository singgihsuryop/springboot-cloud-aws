package com.singgihsuryop.springbootcloudaws.s3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

@Configuration
public class S3Configuration {

	@Bean
	public TransferManager transferManager(AmazonS3 amazonS3) {
		return TransferManagerBuilder.standard()
                .withS3Client(amazonS3)
                .build();
	}
}
