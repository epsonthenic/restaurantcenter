package com.restaurantcenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
public class AppUserViewController {

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
