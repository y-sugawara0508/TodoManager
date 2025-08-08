package com.example.TodoManager.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TodoManager.bean.TaskBean;
import com.example.TodoManager.entity.Task;
import com.example.TodoManager.form.TaskForm;
import com.example.TodoManager.repository.TaskRepository;

@Controller
public class TaskUpdateController {

	@Autowired
	TaskRepository taskRepository;
	
	

	//タスク一覧表示画面から詳細表示画面に遷移するメソッド(完成)
	@GetMapping("/taskDetail/{taskId}")
	public String showTaskDetail(@PathVariable Integer taskId, TaskBean bean, Task task, Model model) {
		//表示に必要な情報をentityから取得
		task = taskRepository.getReferenceById(taskId);
		LocalDate date = (LocalDate) task.getDeadlineDate().toLocalDate();
		LocalTime deadlineTime = (LocalTime) task.getDeadlineDate().toLocalTime();
		//取得した情報をbeanに保存
		BeanUtils.copyProperties(task, bean, "createDate", "deleteFlag", "archiveFlag");
		LocalDateTime deadlineDate = LocalDateTime.of(date, deadlineTime);
		bean.setDeadlineDate(deadlineDate);
		model.addAttribute("task", bean);
		return "/taskDetail";
	}

	//詳細表示画面から一覧表示画面に戻るメソッド
	@PostMapping("/backToTaskList")
	public String backTaskList() {
		return "redirect:/list";
	}

	//詳細表示画面から編集入力画面に遷移する、かつ、編集入力画面で初期値を用意しておくメソッド
	@GetMapping("/taskUpdateInput/{taskId}")
	public String showTaskUpdateInput(@PathVariable Integer taskId, TaskForm form, Task task, Model model) {
		//表示に必要な情報をentityから取得
		task = taskRepository.getReferenceById(taskId);
		LocalDate date = (LocalDate) task.getDeadlineDate().toLocalDate();
		LocalTime deadlineTime = (LocalTime) task.getDeadlineDate().toLocalTime();
		//取得した情報をformに保存
		BeanUtils.copyProperties(task, form, "createDate", "deleteFlag", "archiveFlag");
		form.setDate(date);
		model.addAttribute("task", form);
		//deadlineDateをHH:mm形式に指定した状態でリクエストスコープに保存
		form.setDeadlineTime(deadlineTime);
		model.addAttribute("deadlineTime", deadlineTime.format(DateTimeFormatter.ofPattern("HH:mm")));
		return "task/update/taskUpdateInput";
	}

	//タスク編集入力画面からタスク詳細表示画面に戻るメソッド
	@GetMapping("/backToTaskList/{taskId}")
	public String backTaskDetail(@PathVariable Integer taskId, TaskBean bean, Task task, Model model) {
		//表示に必要な情報をentityから取得
		task = taskRepository.getReferenceById(taskId);
		LocalDate date = (LocalDate) task.getDeadlineDate().toLocalDate();
		LocalTime deadlineTime = (LocalTime) task.getDeadlineDate().toLocalTime();
		//取得した情報をbeanに保存
		BeanUtils.copyProperties(task, bean, "createDate", "deleteFlag", "archiveFlag");
		LocalDateTime deadlineDate = LocalDateTime.of(date, deadlineTime);
		bean.setDeadlineDate(deadlineDate);
		model.addAttribute("task", bean);
		return "/taskDetail";
	}

	//タスク編集入力画面から完了画面に遷移するメソッド
	@PostMapping("/taskUpdateComplete")
	public String taskUpdateComplete(TaskForm form,Task task, Model model) {
		
		
	    // DBから既存タスクを取得
	    task = taskRepository.findById(form.getTaskId())
	            .orElseThrow(() -> new IllegalArgumentException("Invalid task ID"));
	    
	    

		//入力されたdateとdeadlineTimeを、LocalDateTime型でまとめてformに保存
		LocalDate date = (LocalDate) form.getDate();
		LocalTime deadlineTime = (LocalTime)form.getDeadlineTime();
		LocalDateTime deadlineDate = LocalDateTime.of(date, deadlineTime);
		form.setDeadlineDate(deadlineDate);	
		//formの中身を保存()
		BeanUtils.copyProperties(form, task,"deleteFlag","archiveFlag","completeFlag");
		System.out.println(task.getDeadlineDate());
		taskRepository.save(task);
		//タスク詳細画面に戻るリンクのためにTaskIdをリクエストスコープに保存
		model.addAttribute("taskId", form.getTaskId());
		return "/task/update/taskUpdateComplete";
	}

}
