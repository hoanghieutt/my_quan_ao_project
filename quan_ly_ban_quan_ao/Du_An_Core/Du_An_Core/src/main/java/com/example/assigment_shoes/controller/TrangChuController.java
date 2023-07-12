package com.example.assigment_shoes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrangChuController {


    @RequestMapping(value = "home")
    public String home(){

        return "TrangChu/Home";

    }


}
