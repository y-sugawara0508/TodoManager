package com.example.TodoManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TodoManager.entity.Personal;
import com.example.TodoManager.form.LoginForm;
import com.example.TodoManager.repository.ImportanceRepository;
import com.example.TodoManager.repository.PersonalRepository;
import com.example.TodoManager.repository.TaskRepository;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	PersonalRepository pelrepo;

	@Autowired
	TaskRepository tasrepo;

	@Autowired
	ImportanceRepository imprepo;

	@Autowired
	HttpSession session;

	@GetMapping("/")
	public String showLoginForm(@ModelAttribute LoginForm loginForm) {

		session.invalidate();

		return "login";
	}

	@PostMapping("/login")
	public String login(@Valid@ModelAttribute LoginForm loginForm, BindingResult result, HttpSession session,Model model) {
		if(result.hasErrors()) {
			return "/login";
		}
		// ログインパスワードとかを受け取る
		String address = loginForm.getAddress();

		// 入力されたパスワードを取得
		String personalPass = loginForm.getPersonalPass();
		
		//メールアドレスとパスワードでDBを検索し、一致する社員情報を取得
		Personal personal = pelrepo.findByAddressAndPersonalPass(address, personalPass);

		//該当する社員情報が存在する場合(ログイン成功)		
		if (personal != null) {			
			return "redirect:/menu";

		} else {

			//個人情報が見つからない場合、エラーメッセージを表示してログイン画面に戻る
			//model.addAttribute("errMessage", "メールアドレスまたはパスワードが間違っています");
			return "login";
		}
	}

	@GetMapping("/menu")
	public String showMenu(Model model) {

		session.invalidate();

		return "menu";
	}
	
	/**
	 * ログアウト処理
	 * @return ログイン画面にリダイレクト
	 */
	@GetMapping("/logout")
 
	public String logout(HttpSession session) {
 
		//セッションの破棄
		session.invalidate();
 
		return "redirect:/";

	}


}
