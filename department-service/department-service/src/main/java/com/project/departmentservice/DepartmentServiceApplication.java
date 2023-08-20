package com.project.departmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//@EnableEurekaClient//(this will enable department service as Eureka client)
public class DepartmentServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(DepartmentServiceApplication.class, args);
	}

}
