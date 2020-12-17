package com.codehub.pf.team4;

import com.codehub.pf.team4.configuration.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class SpringBootAppDemoApplicationTests {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootAppDemoApplicationTests.class);
	List<String> passwordsToBeHased = Arrays.asList("123456789");

	@Autowired
	private SecurityConfig securityConfig;

	@Test
	public void contextLoads() {
		passwordsToBeHased.forEach(password ->
				LOGGER.info("Hash value of password " + password + " is : " + securityConfig.passwordEncoder().encode(password)));

	}

}
