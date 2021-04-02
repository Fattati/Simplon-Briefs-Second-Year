package com.reservationapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservationapp.model.User;
import com.reservationapp.model.UserCredential;
import com.reservationapp.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String home()
	{
		return "login";
	} 
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String login(Model model, UserCredential user, HttpSession httpSession) {
		User users = userService.login(user);
		if(user != null) {
			if (users.getRole().equals("user") && (users.getAccess() == 1)) {
				httpSession.setAttribute("logged", user);
				return "reservation";
			} 
			else if (users.getRole().equals("admin") && (users.getAccess() == 1)) {
				httpSession.setAttribute("logged", user);
				return "redirect:/admin/users";
			}
			else {
				return "home";
				}
			} 	
			else {
			model.addAttribute("erreur", "Incorrect Email or Password");
		}
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerUser(Model model, @RequestParam(name = "email") String email, @RequestParam(name = "name") String name , 
			@RequestParam(name = "password") String password) {
		User user = userService.findByEmail(email);
		if(user != null) {
			model.addAttribute("erreur", "Email already used");
		} else {
			try {
				User users = new User(name, email, password);
				userService.save(users);
				model.addAttribute("succes", "register done");
				return "login";
			} catch (Exception e) {
				model.addAttribute("erreur", e);
			}
		}
		System.out.println(user);
		return "register";
	}
	
	@RequestMapping(value = "/admin/users", method = RequestMethod.GET)
	public String getUsers(ModelMap model) {
		model.addAttribute("users", userService.getAllApprenantWithoutAccess());
		return "access-validation";
	}
	
	@RequestMapping(value = "/admin/users/validation", method = RequestMethod.POST, params = "Confirm")
	public String ConfirmRegister(User user) {
		user= userService.get(user.getUser_id());
		user.setAccess(1);
		userService.update(user);
		return "redirect:/admin/users/";
	}
	
	
}
