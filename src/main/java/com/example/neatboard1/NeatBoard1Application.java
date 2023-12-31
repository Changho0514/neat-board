package com.example.neatboard1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class NeatBoard1Application {

	public static void main(String[] args) {
		SpringApplication.run(NeatBoard1Application.class, args);
	}

}
