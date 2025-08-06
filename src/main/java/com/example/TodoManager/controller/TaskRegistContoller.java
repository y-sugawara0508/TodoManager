package com.example.TodoManager.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.TodoManager.entity.Task;
import com.example.TodoManager.form.TaskForm;
import com.example.TodoManager.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

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
	 
	@PostMapping("/task/regist/check")
	public String taskRegistCheck(@Valid @ModelAttribute TaskForm form, BindingResult result, Model model, HttpSession session) {
		if(result.hasErrors()) {
			
			System.out.println(result.getErrorCount());
			
			System.out.println("no");
			System.out.println(result.hasErrors());
			return "task/regist/input";
		}else {
			System.out.println("ok");
			Integer personalId = (Integer) session.getAttribute("personalId");
			form.setPersonalId(personalId);
			//TaskFormをリクエストスコープに保存
			model.addAttribute("taskForm",form);
			return "task/regist/check";
		}
		
	}
	*/

	/**
	 * 新規タスク登録確認画面の為のメソッドの入力チェックなし
	 * @param form
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/task/regist/check")
	public String taskRegistCheck(@ModelAttribute TaskForm form, Model model, HttpSession session) {
		session.setAttribute("date", form.getDate());
		session.setAttribute("deadlinetime", form.getDeadlineTime());

		LocalDate date = (LocalDate) session.getAttribute("date");
		LocalTime deadlinetime = (LocalTime) session.getAttribute("deadlinetime");

		System.out.println(LocalDateTime.of(date, deadlinetime));
		LocalDateTime deadlineDate = LocalDateTime.of(date, deadlinetime);
		form.setDeadlineDate(deadlineDate);

		Integer personalId = (Integer) session.getAttribute("personalId");
		form.setPersonalId(personalId);
		model.addAttribute("taskForm", form);
		return "task/regist/check";
	}

	/**
	 * 新規タスク登録完了画面の為のメソッド
	 * @return　新規タスク登録完了画面URL
	 */
	@PostMapping("/task/regist/complete")
	public String taskRegistComplete(TaskForm form) {
		System.out.println(form.getDeadlineDate());
		Task task = new Task();
		task.setDeleteFlag(false);
		task.setCompleteFlag(false);
		task.setArchiveFlag(false);
		BeanUtils.copyProperties(form, task, "taskId");
		repository.save(task);
		return "task/regist/complete";
	}

}
