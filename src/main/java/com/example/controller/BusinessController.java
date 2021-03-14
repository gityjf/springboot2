package com.example.controller;

import com.example.annotation.AutoIdempotent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @GetMapping("get/token")
    @AutoIdempotent
    public Object getToken(){
        return "success";
    }
}
