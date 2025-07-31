package com.example.TodoManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TodoManager.repository.PersonalRepository;

@Controller
public class IndexController {

	@Autowired
	PersonalRepository pelrepo;

	@GetMapping("/")
	public String Test() {

		System.out.println(pelrepo.count());
		return "index";
	}
}
