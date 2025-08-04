package com.example.TodoManager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class MenuController {

	/**
	 * メニュー画面を表示するメソッド
	 * "/menu"GETリクエストを受け取ることで実行
	 * @param model 情報格納用オブジェクト
	 * @return ビュー名
	 */
	@GetMapping("/menu")
	public String showMenu(Model model) {
		
		// メニュー画面を表示
		return "menu";
	}

}