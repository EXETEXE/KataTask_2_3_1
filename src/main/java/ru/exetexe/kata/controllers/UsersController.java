package ru.exetexe.kata.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.exetexe.kata.models.User;
import ru.exetexe.kata.services.UsersService;

import javax.validation.Valid;


@Controller
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }


    @GetMapping("/")
    public String users(@ModelAttribute("user") User user, Model model, Long id) {


        model.addAttribute("users", usersService.findAll());

        model.addAttribute("user", new User());


        return "users";
    }


    @PostMapping
    public String addUser(@ModelAttribute("user") @Valid User user) {

        usersService.save(user);

        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {

        usersService.delete(id);

        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, User user) {

        usersService.update(id, user);
        return "redirect:/";
    }


}
