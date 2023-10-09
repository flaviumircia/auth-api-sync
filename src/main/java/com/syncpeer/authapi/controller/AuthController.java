package com.syncpeer.authapi.controller;


import com.syncpeer.authapi.model.LoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    @PostMapping("/")
    public void printBody(@RequestBody LoginModel requestBody){
        logger.debug(String.valueOf(requestBody));
        System.out.println(requestBody);
    }

}
