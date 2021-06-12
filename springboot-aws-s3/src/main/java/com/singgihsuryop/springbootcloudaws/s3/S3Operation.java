package com.singgihsuryop.springbootcloudaws.s3;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.transfer.TransferManager;

@RestController("/s3")
public class S3Operation {

	@Autowired
	TransferManager transferManager;
	
	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String downloadFiles(@RequestParam("bucketName") String bucketName) {
		transferManager.download(bucketName, "filename", new File(""));
		return "";
	}

	@RequestMapping(value="/search",method=RequestMethod.GET)
	public String searchFiles(@RequestParam("bucketName") String bucketName) {
		
		return "";
	}

	@RequestMapping(value="/upload",method=RequestMethod.GET)
	public String uploadFiles(@RequestParam("bucketName") String bucketName) {
		transferManager.upload(bucketName, "filename", new File(""));
		return "";
	}
	
}
