package com.uploader.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uploader.dao.DBConnector;

@Configuration
public class DefaultConfiguration {

	@Bean
	public DBConnector getDBConnection() {
		return new DBConnector();
	}
	
}
