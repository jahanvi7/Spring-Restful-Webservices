package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> list = (List<Country>) context.getBean("countryList");
		Country required = null;

		for (Country country : list) {
			if (country.getCode().equalsIgnoreCase(code)) {
				required = country;
			}
		}
		if (required == null) {
			throw new CountryNotFoundException();
		}
		LOGGER.info("End");
		return null;
	}

}
