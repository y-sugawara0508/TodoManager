
package com.example.TodoManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TodoManager.entity.Task;
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
	

 @Autowired
 TaskRepository taskRepository; 
 
 @GetMapping("/list")
 public String pagengTest(@RequestParam(value = "TaskName", required = false) String TaskName, 
		                  @RequestParam(value = "pageNum", defaultValue = "0") Integer pageNum, 
		                  @RequestParam(value = "pageSize",defaultValue = "10" )Integer pageSize, 
		                  @RequestParam(value = "sortStr", required = false)String sortStr, Model model) {
  
	 if (sortStr == null || !sortStr.contains("_")) {
	        sortStr = "taskId_ASC";
	    }
	 
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
  
  model.addAttribute("tasks", pages.getContent());
  return "taskList";
  
  //http://localhost:4444/TodoManager/list?pageNum=0&pageSize=10&sortStr=taskId_DESC
 }
}
 
 