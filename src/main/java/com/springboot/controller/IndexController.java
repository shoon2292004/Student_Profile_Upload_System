package com.springboot.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String showIndex(Model m) {
		m.addAttribute("message", "Springboot");
		m.addAttribute("today",LocalDate.now());
		m.addAttribute("today_date",new java.util.Date());
		return "index";
	}

	@GetMapping("/users_list")
	public String showUsers(Model m) {
		List<String> users = new ArrayList<>();
		users.add("Su Su");
		users.add("Mg Mg");
		users.add("Ag Ag");

		m.addAttribute("users_list", users);
		return "users_list";

	}
}
