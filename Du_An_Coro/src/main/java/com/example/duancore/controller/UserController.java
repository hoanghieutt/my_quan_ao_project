package com.example.duancore.controller;

import com.example.duancore.entity.SanPham;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.example.duancore.entity.User;
import com.example.duancore.repository.UserRepository;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping(value = "/User")
public class UserController {

    @Autowired
    ServletContext context;

    @Autowired
    private UserRepository userRepository;

    //Todo code list

    @GetMapping("list")
    public String listShowUser(Model model){

        List<User> userList = userRepository.findAll();

        model.addAttribute("user", userList);
        return "user/list";

    }

    @GetMapping("create")
    public String createUset(Model model){

        model.addAttribute("user", new User());
        return "user/create";
//         Đường dẫn trả về

    }

    //    Todo code create

    @PostMapping("create")
    public String saveUser(Model model,
                           @Valid
                           @ModelAttribute("user") User user,
                           BindingResult result,
                           RedirectAttributes attributes
    ){

        if(result.hasErrors()){

            return "user/create";

        }

        userRepository.save(user);

        attributes.addFlashAttribute("message","Create new categorty was successfully");
        return "redirect:/User/list";

    }




}