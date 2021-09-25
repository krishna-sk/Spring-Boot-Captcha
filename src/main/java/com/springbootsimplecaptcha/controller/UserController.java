package com.springbootsimplecaptcha.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootsimplecaptcha.entity.User;
import com.springbootsimplecaptcha.service.UserService;
import com.springbootsimplecaptcha.util.CaptchaUtil;

import cn.apiclub.captcha.Captcha;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	private void setUpCaptcha(User user) {
		Captcha captcha = CaptchaUtil.createCaptcha(250, 80);
		user.setHidden(captcha.getAnswer());
		user.setCaptcha(""); // User entered value in the form
		user.setImage(CaptchaUtil.encodeBase64(captcha));
	}

	@GetMapping("/register")
	public String showRegistrationPage(Model model) {
		User user = new User();
		setUpCaptcha(user);
		model.addAttribute("user", user);
		return "UserRegister";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute User user, Model model) {

		if (user.getCaptcha().equals(user.getHidden())) {
			userService.createUser(user);
			model.addAttribute("message", "User Created");
		} else {
			setUpCaptcha(user);
			model.addAttribute("user", user);
		}
		return "UserRegister";
	}

	@GetMapping("/all")
	public String showAll(Model model) {

		List<User> allUsers = userService.getAllUsers();

		model.addAttribute("list", allUsers);

		return "UserData";
	}

}
