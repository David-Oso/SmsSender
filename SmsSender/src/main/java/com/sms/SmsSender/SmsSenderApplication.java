package com.sms.SmsSender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SmsSenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsSenderApplication.class, args);
	log.info("::::::::::::::::::::APPLICATION STARTED SUCCESSFULLY::::::::::::::::::::");
	}

}
