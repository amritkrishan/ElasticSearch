package com.example.elasticsearch.retrievedata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class RetrieveDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetrieveDataApplication.class, args);
	}

}

