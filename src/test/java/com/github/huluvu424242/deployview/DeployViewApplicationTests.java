package com.github.huluvu424242.deployview;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DeployViewApplicationTests {

	@Test
	void contextLoads() {
		assertNotNull(new DeployViewApplication());
	}

}
