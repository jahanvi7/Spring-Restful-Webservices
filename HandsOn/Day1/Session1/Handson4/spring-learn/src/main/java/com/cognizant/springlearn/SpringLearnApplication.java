package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public void displayCountry() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country", Country.class);
		LOGGER.debug("Country : {} ", country.toString());
		LOGGER.info("END");
	}
	
	public void displayDate() {
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		String dateAsString = "31/12/2018";
		try {
			System.out.println(format.parse(dateAsString));
			LOGGER.info(dateAsString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("END");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		SpringLearnApplication s = new SpringLearnApplication();
		s.displayDate();
		s.displayCountry();
	}

}
