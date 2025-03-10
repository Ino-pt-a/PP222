package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("users", users);
        return "users/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("user", new User());
        return "users/add";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "users/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable long id, @ModelAttribute User user) {
        user.setId(id);
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
