package com.nttdata.bootcoinpurse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BootcoinPurseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcoinPurseApplication.class, args);
	}

}
