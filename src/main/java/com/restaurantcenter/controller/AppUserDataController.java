package com.restaurantcenter.controller;

import com.restaurantcenter.service.AppUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Dashboard")
public class AppUserDataController {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/getall")
    public ResponseEntity<String> getUserId(){
        return appUserService.getUserId();
    }

}
