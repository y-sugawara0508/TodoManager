
package com.example.TodoManager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TodoManager.bean.TaskBean;
import com.example.TodoManager.entity.Task;
import com.example.TodoManager.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class TaskListController {

	@Autowired
	TaskRepository taskRepository;

	@GetMapping("/list")
 public String pagengTest(@RequestParam(value = "TaskName", required = false) String TaskName, 
		                  @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum, 
		                  @RequestParam(value = "pageSize",defaultValue = "10" )Integer pageSize, 
		                  @RequestParam(value = "sortStr", required = false)String sortStr, HttpSession session, Model model) {
  
	 if (sortStr == null || !sortStr.contains("_")) {
	     sortStr =(String) session.getAttribute("sortStr");
	     if(sortStr == null) {
		 sortStr = "taskId_ASC";
	    }
	 }
	 
	 session.setAttribute("sortStr",sortStr);
	 
  // 文頭から"_"より前の文字列をidとして取得
  String sortId = sortStr.substring(0,sortStr.indexOf("_")); // taskId,createDate
  System.out.println(sortId);
  
  // 文末から"_"より後の文字列をdirとして取得
  String sortDir = sortStr.substring(sortStr.indexOf("_")+1); //ASC DESC
  System.out.println(sortDir);
  
  // ソート評価値を設定
  Pageable pageable = PageRequest.of(
    pageNum,pageSize,sortDir.equals("ASC") ? Sort.by(sortId).ascending() : Sort.by(sortId).descending()); 
 
  // ソート実行結果を取得
  Page<Task> pages = taskRepository.findAll(pageable);
  
  // beanに詰め替える
  List<TaskBean> taskbeans = new ArrayList<>();
  int displayNo = pageNum * pageSize + 1;
  for (Task task : pages.getContent()) {
	    TaskBean bean = new TaskBean();
	    bean.setTaskId(task.getTaskId());
	    bean.setTaskName(task.getTaskName());
	    bean.setTaskContents(task.getTaskContents());
	    bean.setDeadlineDate(task.getDeadlineDate());    // ← ここが重要
	    bean.setCreateDate(task.getCreateDate());        // ← ここが重要
	    bean.setDeleteFlag(task.getDeleteFlag());
	    bean.setCompleteFlag(task.getCompleteFlag());
	    bean.setArchiveFlag(task.getArchiveFlag());
	    bean.setImportanceId(task.getImportanceId());
	    bean.setPersonalId(task.getPersonalId());
	    bean.setDisplayNo(displayNo ++);
	    taskbeans.add(bean);
	}
 
  model.addAttribute("tasks" ,taskbeans);
  model.addAttribute("sortStr",sortStr);
  model.addAttribute("pageNum", pageNum);
  model.addAttribute("pageSize", pageSize);
  
  return "taskList";
  
  
  
  //http://localhost:4444/TodoManager/list?pageNum=0&pageSize=10&sortStr=taskId_DESC
 }
}
