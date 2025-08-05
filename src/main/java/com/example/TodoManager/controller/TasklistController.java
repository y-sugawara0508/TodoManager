package com.example.TodoManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TodoManager.repository.TaskRepository;

@Controller
public class TasklistController {

	@Autowired
	TaskRepository repository;
	
	private boolean backmanager = false;
	
	@RequestMapping("/list/desc") public String showEmpNameListDesc(Model model) { 
		model.addAttribute("task", repository.findAllByOrderByCreateDateDesc()); 
		return "/list";
		
	}
	/**
	 * 検索結果の表示
	 * 
	 * @author 岡村
	 * @param TaskName タスク名検索の値の格納
	 * @param model スコープの値の送信
	 * @return タスク一覧画面
	 * @see Task
	 */
	@RequestMapping(path="/list/TaskName",method = RequestMethod.GET)
	public String showTaskNameLike(@RequestParam String TaskName, Model model) {
		model.addAttribute("Task",repository.findByTaskNameContaining());
		return "list/list";
		
		}	
	
}
