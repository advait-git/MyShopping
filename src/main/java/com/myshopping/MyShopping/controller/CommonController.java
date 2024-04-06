package com.myshopping.MyShopping.controller;

import com.myshopping.MyShopping.models.AppUser;
import com.myshopping.MyShopping.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") //common req
//as we want to save we use post methode


public class CommonController {

    @Autowired
    UserService userService;
    @PostMapping("/user/register")
    public String registerUser(@RequestBody AppUser appUser){
    userService.registerUser(appUser);
    return "User got successfully saved";
    }
}
