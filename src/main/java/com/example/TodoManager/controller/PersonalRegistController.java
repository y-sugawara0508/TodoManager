
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
	PersonalRepository pelrepo;

	@Autowired
	HttpSession session;

	// ユーザ登録フォーム表示
	@GetMapping("/personalregistinput")
	public String showPersonalRegistForm(@ModelAttribute PersonalForm personalForm, Model model) {
		return "personalregistinput";
	}

	// 入力画面に戻る
	@PostMapping("/personalregistinput")
	public String backPersonalRegistForm(@ModelAttribute PersonalForm personalForm, Model model) {
		
		
		return "personalregistinput";
	}

	// 入力内容のチェック
	@PostMapping("/personalregistcheck")
	public String personalRegistCheck(@Valid @ModelAttribute PersonalForm personalForm, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "personalregistinput";
		}

		session.setAttribute("personalForm", personalForm);
		return "personalregistcheck";
	}

	@PostMapping("/personalregistcomplete")
	public String personalRegistComplete(Model model) throws IllegalAccessException, InvocationTargetException {
		PersonalForm personalForm = (PersonalForm) session.getAttribute("personalForm");
		if (personalForm == null) {
			return "redirect:/personalregistinput";
		}

		personalForm.setPersonalId(null); 
		Personal personal = new Personal();
		BeanUtils.copyProperties(personal, personalForm);

		pelrepo.save(personal);
		session.removeAttribute("personalForm");

		return "personalregistcomplete";
	}
}
