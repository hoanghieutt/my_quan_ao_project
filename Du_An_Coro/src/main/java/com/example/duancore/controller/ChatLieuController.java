package com.example.duancore.controller;



import com.example.duancore.entity.ChatLieu;
import com.example.duancore.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ChatLieuController {
    @Autowired
    private ChatLieuService chatLieuService;

    @GetMapping("/chat-lieu/hien-thi")
    public String hienThiChatLieu(Model model) {
        List<ChatLieu> chatLieus = chatLieuService.getAllChatLieu();
        model.addAttribute("chatLieu", chatLieus);
        model.addAttribute("cl", new ChatLieu());
        return "/chatlieu/chat";
    }


    @PostMapping("/chat-lieu/add")
    public String addChatLieu(@Valid @ModelAttribute("cl") ChatLieu chatLieu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ChatLieu> chatLieus = chatLieuService.getAllChatLieu();
            model.addAttribute("chatlieu", chatLieus);

            return "/chatlieu/chat-lieu";
        }
        chatLieuService.addChatLieu(chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("/chat-lieu/delete/{id}")
    public String deleteChatLieu(@PathVariable("id") String id) {
        chatLieuService.deleteChatLieu(id);
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("/chat-lieu/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") String id) {


        ChatLieu chatLieu = chatLieuService.detailChatLieu(id);
        model.addAttribute("chatlieu", chatLieu);

        return "/chatlieu/chat-lieu-update";
    }

    @PostMapping("/chat-lieu/update")
    public String update(@ModelAttribute ChatLieu chatLieu, Model model) {
        chatLieuService.updateChatLieu(chatLieu);
        model.addAttribute("chatlieu", chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }
}