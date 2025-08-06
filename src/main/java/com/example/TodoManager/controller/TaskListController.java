
package com.example.TodoManager.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TodoManager.bean.TaskBean;
import com.example.TodoManager.entity.Task;
import com.example.TodoManager.form.TaskForm;
import com.example.TodoManager.repository.TaskRepository;

@Controller
public class TaskListController {
	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/list")
	public String pagengTest(@RequestParam(value = "TaskName", required = false) String TaskName,
			@RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
			@RequestParam(value = "sortStr", required = false) String sortStr, Model model) {

		if (sortStr == null || !sortStr.contains("_")) {
			sortStr = "taskId_ASC";
		}

		// 文頭から"_"より前の文字列をidとして取得
		String sortId = sortStr.substring(0, sortStr.indexOf("_")); // taskId,createDate
		System.out.println(sortId);

		// 文末から"_"より後の文字列をdirとして取得
		String sortDir = sortStr.substring(sortStr.indexOf("_") + 1); //ASC DESC
		System.out.println(sortDir);

		// ソート評価値を設定
		Pageable pageable = PageRequest.of(
				pageNum, pageSize, sortDir.equals("ASC") ? Sort.by(sortId).ascending() : Sort.by(sortId).descending());

		// ソート実行結果を取得
		Page<Task> pages = taskRepository.findAll(pageable);
		
		//beanに詰め替える
		List<TaskBean> taskbeans = new ArrayList<>();
		int displayNo = pageNum * pageSize + 1;
		for (Task task : pages.getContent()) {
			TaskBean bean = new TaskBean();
			bean.setTaskId(task.getTaskId());
			bean.setTaskName(task.getTaskName());
			bean.setTaskContents(task.getTaskContents());
			bean.setDeadlineDate(task.getDeadlineDate()); // ← ここが重要
			bean.setCreateDate(task.getCreateDate()); // ← ここが重要
			bean.setDeleteFlag(task.getDeleteFlag());
			bean.setCompleteFlag(task.getCompleteFlag());
			bean.setArchiveFlag(task.getArchiveFlag());
			bean.setImportanceId(task.getImportanceId());
			bean.setPersonalId(task.getPersonalId());
			bean.setDisplayNo(displayNo++);
			taskbeans.add(bean);
		}

		model.addAttribute("tasks", taskbeans);
		model.addAttribute("sortStr", sortStr);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("tasks", pages.getContent());
		return "taskList";

		//http://localhost:4444/TodoManager/list?pageNum=0&pageSize=10&sortStr=taskId_DESC
	}

	//タスク一覧表示画面から詳細表示画面に遷移するメソッド(完成)
	@GetMapping("/taskDetail/{taskId}")
	public String showTaskDetail(@PathVariable Integer taskId, TaskBean bean, Task task, Model model) {
		//表示に必要な情報をentityから取得
		task = taskRepository.getReferenceById(taskId);
		LocalDate date = (LocalDate) task.getDeadlineDate().toLocalDate();
		LocalTime deadlineTime = (LocalTime) task.getDeadlineDate().toLocalTime();
		//取得した情報をbeanに保存
		BeanUtils.copyProperties(task, bean, "createDate", "deleteFlag", "archiveFlag");
		bean.setDate(date);
		bean.setDeadlineTime(deadlineTime);
		model.addAttribute("task", bean);
		return "/taskDetail";
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
		form.setDeadlineTime(deadlineTime);
		model.addAttribute("task", form);
		return "task/update/taskUpdateInput";
	}

}
