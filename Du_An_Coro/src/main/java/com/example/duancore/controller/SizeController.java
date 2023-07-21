package com.example.duancore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping(value = "Size")
public class SizeController {

     @GetMapping("list")
     public String listShow(){

         return "Size/hienThi";

     }
@GetMapping("/size/hien-thi")
    public String hienthi(){
         return "";
}



}
