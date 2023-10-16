package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImpl;


import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;
import web.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("users", userService.getListUsers());
		return "/index";
	}

	@GetMapping("/index/new")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "/new";
	}

	@PostMapping("/index")
	public String createdUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/index";
	}

	@PostMapping ("/index/delete")
	public String deleteUser(@RequestParam("id") int id) {
		userService.removeUserById(id);
		return "redirect:/index";
	}

	@GetMapping("/index/edit")
	public String editUser(@RequestParam("id") int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "/edit";
	}

	@PostMapping ("/index/edit")
	public String editedUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
		userService.updateUser(id, user);
		return "redirect:/index";
	}
}