package com.example.duancore.controller;


import com.example.duancore.entity.ChatLieu;
import com.example.duancore.entity.MauSac;
import com.example.duancore.service.ChatLieuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ChatLieuController {
    @Autowired
    private ChatLieuService chatLieuService;

    @GetMapping("/chat-lieu/hien-thi")
    public String hienThiChatLieu(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, Model model) {
        Page<ChatLieu> page = chatLieuService.findPage(pageNo,3);
        model.addAttribute("chatLieu",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("cl", new ChatLieu());
        return "/chatlieu/chat";
    }


    @PostMapping("/chat-lieu/add")
    public String addChatLieu(@Valid @ModelAttribute("cl") ChatLieu chatLieu, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<ChatLieu> chatLieus = chatLieuService.getAllChatLieu();
            model.addAttribute("chatLieu", chatLieus);

            return "/chatlieu/chat";
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
        model.addAttribute("chatLieu", chatLieu);

        return "/chatlieu/chat-lieu-update";
    }

    @PostMapping("/chat-lieu/update")
    public String update(@ModelAttribute("cl") ChatLieu chatLieu, Model model) {
        chatLieuService.updateChatLieu(chatLieu);
        model.addAttribute("chatlieu", chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @PostMapping("/chat-lieu/sreach")
    public String sreach(@RequestParam(name = "page",defaultValue = "0") Integer pageNo,@RequestParam("ten") String ten,@RequestParam("trangThai") String trangThai, Model model) {
        Page<ChatLieu> page = chatLieuService.findPage(pageNo,3);
        model.addAttribute("ten", chatLieuService.sreach(ten,trangThai));
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("chatLieu",page.getContent());

        return "redirect:/chat-lieu/hien-thi";
    }

}