package com.uploader.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.uploader.beans.ResultMetrics;

public class DBConnector {

String addOrder = "INSERT INTO TESTRESULT (BU, DEPT, PROJECTJIRAID, TOTAL, PASSED, FAILED, IGNORED, SKIPPED, DURATION, EXECUTIONDATE, QUALITYSUCCEED) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?);";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int addResult(ResultMetrics resultMetrics){
		return jdbcTemplate.update(addOrder, new Object[] { resultMetrics.getBu(),
				resultMetrics.getGroup(), 
				resultMetrics.getProjectJiraId(),
				resultMetrics.getTotal(),
				resultMetrics.getPassed(),
				resultMetrics.getFailed(),
				resultMetrics.getIgnored(),
				resultMetrics.getSkipped(),
				resultMetrics.getTotalDuration(),
				resultMetrics.getExecutionStartTime(),
				resultMetrics.isQualitySucceed()
			});
	}
	
}
