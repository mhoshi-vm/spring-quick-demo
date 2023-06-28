package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;

@Testcontainers
@SpringBootTest
class DemoApplicationTests {

	@Container
	static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:14");

	@DynamicPropertySource
	static void addPostgres(DynamicPropertyRegistry dynamicPropertyRegistry){
		dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}


	@Autowired
	DemoRepository demoRepository;

	@Autowired
	DemoController demoController;

	@Test
	void contextLoads() {
	}

	@Test
	void demoTest(){
		DemoEntity demoEntity = new DemoEntity();
		demoEntity.setDemoValue("hoge");
		demoRepository.save(demoEntity);

		Assertions.assertEquals(demoController.getAll().size(), 1);
		Assertions.assertEquals(demoController.getAll().get(0).getDemoValue(), "hoge");
	}


}
