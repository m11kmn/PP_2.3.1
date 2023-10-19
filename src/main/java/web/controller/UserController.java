package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import web.models.User;
import web.services.UsersService;

@Controller
@RequestMapping("/users") // users - это начальная страница
public class UserController {
	@Autowired
	private UsersService usersService;

	@GetMapping()
	public String index(Model model) {
		model.addAttribute("users", usersService.findAll());
		return "/users";
	}

	@GetMapping("/new")
	public String createUser(Model model) {
		model.addAttribute("user", new User());
		return "/new";
	}

	@PostMapping()
	public String createdUser(@ModelAttribute("user") User user) {
		usersService.save(user);
		return "redirect:/users";
	}

	@PostMapping ("/delete")
	public String deleteUser(@RequestParam("id") long id) {
		usersService.delete(id);
		return "redirect:/users";
	}

	@GetMapping("/edit")
	public String editUser(@RequestParam("id") long id, Model model) {
		model.addAttribute("user", usersService.findOne(id));
		return "/edit";
	}

	@PostMapping ("/edit")
	public String editedUser(@ModelAttribute("user") User user, @RequestParam("id") long id) {
		usersService.update(id, user);
		return "redirect:/users";
	}
}