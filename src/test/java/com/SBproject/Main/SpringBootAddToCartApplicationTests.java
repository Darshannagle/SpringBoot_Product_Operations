package com.SBproject.Main;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.SBproject.Main.controller.MainController;
import com.SBproject.Main.service.ProductService;

@SpringBootTest
class SpringBootAddToCartApplicationTests {

	@Autowired
	private MainController controller;
	@Autowired
	private ProductService service;

	@Test
	void contextLoads(ApplicationContext context) {

	}

}
