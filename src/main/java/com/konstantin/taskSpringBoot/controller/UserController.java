package com.konstantin.taskSpringBoot.controller;


import com.konstantin.taskSpringBoot.model.User;
import com.konstantin.taskSpringBoot.service.UserServiceInt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.konstantin.taskSpringBoot.service.UserService;


@Controller
public class UserController {

    private final UserServiceInt userServiceInt;

    public UserController(UserServiceInt userServiceInt) {
        this.userServiceInt = userServiceInt;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userServiceInt.findAll());
        return "users";
    }

    @GetMapping(value = "users/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping(value = "users/add")
    public String addUser(@ModelAttribute("user") User user) {
        userServiceInt.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userServiceInt.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userServiceInt.saveUser(user);
        return "redirect:/";
    }

    @DeleteMapping("users/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        userServiceInt.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userServiceInt.findById(id));
        return "show";
    }


}
