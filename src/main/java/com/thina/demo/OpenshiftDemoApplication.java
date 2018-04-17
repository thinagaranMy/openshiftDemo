package com.thina.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OpenshiftDemoApplication {
	
	private Logger log = LoggerFactory.getLogger(OpenshiftDemoApplication.class);

	@Autowired
	private ProductDAO productDAO;
	
	public static void main(String[] args) {
		SpringApplication.run(OpenshiftDemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner loadData() {
		return (args) -> {
			log.info("Creating new products - milk and coffee");
			productDAO.save(new Product("9123456789101", "milk"));
			productDAO.save(new Product("9123456789102", "coffee"));
			
			log.info("Extracting inforamtion from the db");
			for (Product product : productDAO.findAll()) {
				log.info(product.toString());
			}
		
		};

	}
}
