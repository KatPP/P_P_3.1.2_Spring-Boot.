package com.konstantin.taskSpringBoot.controller;


import com.konstantin.taskSpringBoot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.konstantin.taskSpringBoot.service.UserService;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String welcome() {
        return "redirect:/users";
    }

    @GetMapping(value = "users")
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.findAll());
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
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping(value = "users/edit/{id}")
    public String editUser(ModelMap model, @PathVariable("id") Long id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping(value = "users/edit")
    public String edit(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("users/delete")
    public String deleteUserById(@RequestParam("id") Long id) {
        userService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("users/{id}")
    public String show(@PathVariable("id") Long id, ModelMap modelMap) {
        modelMap.addAttribute("user", userService.findById(id));
        return "show";
    }


}
