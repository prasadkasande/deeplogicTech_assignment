package com.deeplogic_tech.timedotcom_stories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class TimedotcomStoriesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TimedotcomStoriesApplication.class, args);
	}

}
