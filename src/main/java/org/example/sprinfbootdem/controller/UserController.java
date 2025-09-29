package org.example.sprinfbootdem.controller;

import org.example.sprinfbootdem.model.User;
import org.example.sprinfbootdem.service.UserService;
import org.example.sprinfbootdem.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {  // инжект через интерфейс
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
       return "user-update";
    }

    @PostMapping("user-update")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }
}
