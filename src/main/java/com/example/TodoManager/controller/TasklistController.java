package com.example.TodoManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TodoManager.repository.TaskRepository;

@Controller
public class TasklistController {

	@Autowired
	TaskRepository repository;
	
	private boolean backmanager = false;
	
	@RequestMapping("/list/desc") public String showEmpNameListDesc(Model model) { 
		model.addAttribute("task", repository.findAllByOrderByCreateDateDesc()); 
		return "list/list";
		
	}
	
}
