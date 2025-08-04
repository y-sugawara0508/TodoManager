package com.example.TodoManager.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.TodoManager.repository.TaskRepository;

		@Controller
public class TasklistController {
		
		@Autowired
		TaskRepository repository;
		
		private boolean backmanager = false;
}
