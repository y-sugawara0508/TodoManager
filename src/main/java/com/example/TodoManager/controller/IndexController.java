package com.example.TodoManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.TodoManager.entity.Importance;
import com.example.TodoManager.entity.Personal;
import com.example.TodoManager.entity.Task;
import com.example.TodoManager.repository.ImportanceRepository;
import com.example.TodoManager.repository.PersonalRepository;
import com.example.TodoManager.repository.TaskRepository;

@Controller
public class IndexController {

	@Autowired
	PersonalRepository pelrepo;

	@Autowired
	TaskRepository tasrepo;
	
	@Autowired
	ImportanceRepository imprepo;
	
	@GetMapping("/")
	public String Test() {
		
		System.out.println(pelrepo.count());

		List<Personal> pers = pelrepo.findAll();
		for(Personal per : pers) {
			System.out.print(per.getPersonalId() + ",");
			System.out.print(per.getPersonalName() + ",");
			System.out.print(per.getAddress() + ",");
			System.out.print(per.getPersonalPass() + ",");
			System.out.println(per.getBirthday());
		}
		
		List<Task> tasks = tasrepo.findAll();
		for(Task task : tasks) System.out.println(task.getTaskName());
		
		List<Importance> imps = imprepo.findAll();
		for(Importance imp : imps) System.out.println(imp.getImportanceName());
		
		return "index";
	}
}