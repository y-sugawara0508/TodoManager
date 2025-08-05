
package com.example.TodoManager.controller;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TodoManager.entity.Personal;
import com.example.TodoManager.form.PersonalForm;
import com.example.TodoManager.repository.PersonalRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PersonalRegistController {

	@Autowired
	PersonalRepository personalRepository;

	@Autowired
	HttpSession session;

	/**
	* 新規ユーザ登録画面を表示するメソッド
	* "/personalregistinput" GETリクエストを受け取ることで実行
	*
	* @param personalForm ユーザ登録入力情報格納オブジェクト
	* @param model        情報格納オブジェクト
	* @return ビュー名 "personalregistinput"
	*/
	@GetMapping("/personalregistinput")
	public String showPersonalRegistForm(@ModelAttribute PersonalForm personalForm, Model model) {
		model.addAttribute("personalForm", personalForm);
		return "personalregistinput";
	}

	/**
	 * 新規ユーザ登録画面に戻るためのメソッド
	 * "/personalregistinput" POSTリクエストを受け取ることで実行
	 *
	 * @param personalForm ユーザ登録入力情報格納オブジェクト
	 * @param model        情報格納オブジェクト
	 * @return ビュー名 "personalregistinput"
	 */
	@PostMapping("/personalregistinput")
	public String backPersonalRegistForm(@ModelAttribute PersonalForm personalForm, Model model) {

		model.addAttribute("personalForm", personalForm);
		return "personalregistinput";
	}

	/**
	 * 入力されたユーザ登録情報のバリデーションを行い、問題なければ確認画面を表示するメソッド
	 * "/personalregistcheck" POSTリクエストを受け取ることで実行
	 *
	 * @param personalForm ユーザ登録入力情報格納オブジェクト
	 * @param result       バリデーション結果格納オブジェクト
	 * @param model        情報格納オブジェクト
	 * @return 入力にエラーがある場合のビュー名 "personalregistinput"、エラーがない場合のビュー名 "personalregistcheck"
	 */
	@PostMapping("/personalregistcheck")
	public String personalRegistCheck(@Valid @ModelAttribute PersonalForm personalForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "personalregistinput";
		}

		session.setAttribute("personalForm", personalForm);
		model.addAttribute("personalForm", personalForm);
		return "personalregistcheck";
	}

	/**
	* ユーザ登録を完了し、登録情報をデータベースに保存するメソッド
	* "/personalregistcomplete" POSTリクエストを受け取ることで実行
	*
	* @param model 情報格納オブジェクト
	* @return 登録完了の場合のビュー名 "personalregistcomplete"、または新規ユーザ登録画面へのリダイレクト
	* @throws IllegalAccessException    プロパティコピー時のアクセス例外
	* @throws InvocationTargetException プロパティコピー時の例外
	*/
	@PostMapping("/personalregistcomplete")
	public String personalRegistComplete(Model model) throws IllegalAccessException, InvocationTargetException {
		PersonalForm personalForm = (PersonalForm) session.getAttribute("personalForm");
		if (personalForm == null) {
			return "redirect:/personalregistinput";
		}

		personalForm.setPersonalId(null);
		Personal personal = new Personal();
		BeanUtils.copyProperties(personal, personalForm);

		personalRepository.save(personal);
		session.removeAttribute("personalForm");

		return "personalregistcomplete";
	}
}
