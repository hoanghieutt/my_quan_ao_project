package com.example.duancore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "hoaDon")
public class hoaDonController {

    @GetMapping("list")
    public String listShow(){

         return "hoaDonChiTiet/list";

    }

}
