package com.example.TodoManager.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	@GetMapping("/task/regist/input")
	public String showTaskRegist(@ModelAttribute TaskForm form, HttpSession session, Model model) {
		Integer personalId = (Integer) session.getAttribute("personalId");
		session.setAttribute("taskform", form);
		return "task/regist/input";
	}
	/** 
	 * @param model リクエストスコープ
	 * @param task登録フォーム
	 * @return タスク登録画面に遷移　
	 */
	@PostMapping("/regist/reverse")
	public String registReverse(TaskForm form,Model model) {
		model.addAttribute("taskForm", form);
		return "task/regist/input";
	}
	
	/**
	 * 新規タスク登録確認画面の為のメソッドの入力チェックなし
	 * @param form
	 * @param model
	 * @param session
	 * @return
	 */
	@PostMapping("/task/regist/check")
	public String taskRegistCheck(@Valid @ModelAttribute TaskForm form, BindingResult result, Model model,
			HttpSession session) {

		if (result.hasErrors()) {
			return "task/regist/input";
		}
		TaskForm sessionForm = (TaskForm) session.getAttribute("taskForm");
		form.setCreateDate(new Date());
		//LocalDate + LocalTime = LocalDateTimeに変換
		LocalDate date = form.getDate();
		LocalTime deadlineTime = form.getDeadlineTime();
		LocalDateTime deadlineDate = LocalDateTime.of(date, deadlineTime);
		form.setDeadlineDate(deadlineDate);
		//personalIDをセット
		Integer personalId = (Integer) session.getAttribute("personalId");
		form.setPersonalId(personalId);

		//確認画面にフォームを渡す
		model.addAttribute("taskForm", form);
		return "task/regist/check";
	}

	/**
	 * 新規タスク登録完了画面の為のメソッド
	 * @return　新規タスク登録完了画面URL
	 * @param form
	 * @param model
	 * @param session
	 */
	@PostMapping("/task/regist/complete")
	public String taskRegistComplete(TaskForm form,Model model) {
		Task task = new Task();
		BeanUtils.copyProperties(form,task);
		task.setDeleteFlag(false);
		task.setCompleteFlag(false);
		task.setArchiveFlag(false);
		task =repository.save(task);
		return "task/regist/complete";
	}
}