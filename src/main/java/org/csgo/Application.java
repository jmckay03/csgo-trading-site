package org.csgo;


import org.csgo.service.SteamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;


@SpringBootApplication
@Configuration
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception{
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		context.getBean(SteamService.class).steamCacheInventory();

	}

}
