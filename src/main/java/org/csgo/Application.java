package org.csgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {


	public static void main(String[] args) throws Exception{
		SpringApplication.run(Application.class, args);
		System.out.println("Hello World");
	}

}
