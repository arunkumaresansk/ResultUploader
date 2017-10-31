package com.uploader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.uploader.beans.Feedback;
import com.uploader.beans.ResultMetrics;
import com.uploader.dao.DBConnector;

@RestController
@RequestMapping(value = "/uploader")
public class UploadController {

	@Autowired
	DBConnector dbConnector;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Feedback> postPriorities(@RequestBody ResultMetrics resultMetris) {
		Feedback feedback;
		boolean isOperationSuccess = false;
		if (dbConnector.addResult(resultMetris) == 1) {
			feedback = new Feedback("operationSuccess", "Result posted successfully.");
			isOperationSuccess = true;
		} else {
			feedback = new Feedback("operationFailed", "Unable to persist the result.");
		}
		ResponseEntity<Feedback> responseEntity = new ResponseEntity<Feedback>(feedback,
				isOperationSuccess ? HttpStatus.OK : HttpStatus.UNPROCESSABLE_ENTITY);
		return responseEntity;
	}

}
