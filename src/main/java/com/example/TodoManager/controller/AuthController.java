package com.example.TodoManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TodoManager.entity.Personal;
import com.example.TodoManager.form.LoginForm;
import com.example.TodoManager.repository.PersonalRepository;

import ch.qos.logback.core.model.Model;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {

	@Autowired
	PersonalRepository personalRepository;

	@Autowired
	HttpSession session;

	/**
	 * ログイン画面を表示するメソッド
	 * "/"GETリクエストを受け取ることで実行
	 * 
	 * @param loginForm ログイン入力情報格納オブジェクト
	 * @return ビュー名："login"
	 */
	@GetMapping("/")
	public String showLoginForm(@ModelAttribute LoginForm loginForm) {

		// セッションの初期化(放棄)
		session.invalidate();

		// ビューを返す
		return "login";
	}

	/**
	 * ログイン処理を行うメソッド
	 * "/login"POSTリクエストを受け取ることで実行
	 * 
	 * @param loginForm ログイン入力情報格納オブジェクト
	 * @param result 入力チェック結果格納オブジェクト
	 * @param model 情報格納オブジェクト
	 * @return
	 */
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, HttpSession session,
			Model model) {

		// 入力チェック結果を確認
		if (result.hasErrors()) {

			// 入力エラーがある場合は、ログイン画面を再表示（エラー表示を行う）
			return "login";
		}

		// アドレスを取得
		String address = loginForm.getAddress();

		// パスワードを取得
		String personalPass = loginForm.getPersonalPass();

		// 受け取った情報からユーザーを検索
		// FIX: アドレスもパスワードも一意制約がない為2つ以上のデータが見つかってしまう状態。
		Personal personal = personalRepository.findByAddressAndPersonalPass(address, personalPass);

		//該当するユーザー情報が存在するかどうか		
		if (personal != null) {
			// 存在する場合、メニュー画面にリダイレクトを行う
			return "redirect:/menu";

		} else {
			// 存在しない場合、ログイン画面を再表示（エラー表示を行う）
			return "login";
		}
	}

	/**
	 * ログアウト処理を行うメソッド
	 * "/logout"GETリクエストを受け取ることで実行
	 * 
	 * @return ログイン画面にリダイレクト
	 */
	@GetMapping("/logout")
	public String logout() {

		//セッションの破棄
		session.invalidate();

		// ログイン画面にリダイレクトを行う
		return "redirect:/";

	}
}
