package com.example.TodoManager.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TodoManager.entity.Task;
import com.example.TodoManager.form.TaskForm;
import com.example.TodoManager.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class TaskRegistContoller {
	
	@Autowired
	TaskRepository repository;
	
	/**
	 * 新規タスク登録入力画面遷移の為のメソッド
	 * @return 新規タスク登録入力画面のURL
	 */
	@RequestMapping("/task/regist/input")
	public String showTaskRegistForm(@ModelAttribute TaskForm form) {
		return "task/regist/input";
	}
	
	
	/**
	 * 新規タスク登録確認画面の為のメソッド
	 * @return 新規タスク登録確認画面のURL
	 */
	@PostMapping("/task/regist/check")
	public String taskRegistCheck(@Valid @ModelAttribute TaskForm form, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("ああ");
			System.out.println(result.hasErrors());
			return "task/regist/input";
		}else {
			
			Integer personalId = (Integer) session.getAttribute("personalId");
			form.setPersonalId(personalId);
			//TaskFormをリクエストスコープに保存
			model.addAttribute("taskForm",form);
			return "task/regist/check";
		}
		
	}
	
	/**
	 * 新規タスク登録完了画面の為のメソッド
	 * @return　新規タスク登録完了画面URL
	 */
	@PostMapping("/task/regist/complete")
	public String taskRegistComplete(TaskForm form) {
		Task task = new Task();
		task.setDeleteFlag(true);
		task.setCompleteFlag(true);
		task.setArchiveFlag(true);
		BeanUtils.copyProperties(form, task, "taskId");
		repository.save(task);
		return "task/regist/complete";
	}

}
