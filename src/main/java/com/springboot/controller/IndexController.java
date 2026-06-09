package com.springboot.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class IndexController {
	
	@GetMapping("/")
	public String showHomePage() {
		return "index";
	}
	@GetMapping("/form")
	public String showMajorPage() {
		return "create-major";
	}


	
}
