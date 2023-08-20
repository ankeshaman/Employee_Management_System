package com.project.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient(no need to use if you are using spring 3 ,internally its present)
@EnableConfigServer
//by using "@EnableConfigServer" annotation this springboot project will act as a spring cloud config server
public class ConfigServerApplication {

	public static void main(String[] args) {

		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
