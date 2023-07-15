package com.example.duancore.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class homController {


    @RequestMapping("")
    public String homeShow(){

        return "home";

    }

}
