package com.jumia.test.phonevalidation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.jumia.test.phonevalidation.controller.CustomerController;
import com.jumia.test.phonevalidation.service.CustomerService;
import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PhoneValidationApplicationTests {

	@Autowired
	private CustomerController controller;
	@Autowired
	private CustomerService service;
	@Autowired
	private DataSource dataSource;

	@Test
	void contextLoads() {
		assertNotNull(controller);
		assertNotNull(service);
		assertNotNull(dataSource);
	}

}
