package com.example.duancore.controller;


import com.example.duancore.entity.LoaiSanPham;
import com.example.duancore.service.LoaiSanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class LoaiSanPhamController {
    @Autowired
    private LoaiSanPhamService  loaiSanPhamService;

    @GetMapping("/loai-san-pham/hien-thi")
    public String hienThiChatLieu(Model model) {
        List<LoaiSanPham> chatLieus = loaiSanPhamService.getAllLoaiSanPham();
        model.addAttribute("loaiSanPham", chatLieus);
        model.addAttribute("lsp", new LoaiSanPham());
        return "/loaisanpham/loai-san-pham";
    }

    @PostMapping("/loai-san-pham/add")
    public String addChatLieu(@Valid @ModelAttribute("lsp") LoaiSanPham loaiSanPham, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getAllLoaiSanPham();
            model.addAttribute("loaiSanPhams", loaiSanPhams);

            return "/zloaiSP/loai-san-pham";
        }
        loaiSanPhamService.addLoaiSanPham(loaiSanPham);
        return "redirect:/loai-san-pham/hien-thi";
    }

    @GetMapping("/loai-san-pham/delete/{id}")
    public String deleteLoaiSP(@PathVariable("id") String id) {
        loaiSanPhamService.deleteLoaiSanPham(id);
        return "redirect:/loai-san-pham/hien-thi";
    }

    @GetMapping("/loai-san-pham/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") String id) {


        LoaiSanPham loaiSanPham = loaiSanPhamService.detailLoaiSanPham(id);
        model.addAttribute("loaiSanPhams", loaiSanPham);

        return "/loai-san-pham/loai-san-pham-update";
    }

    @PostMapping("/loai-san-pham/update")
    public String update(@ModelAttribute LoaiSanPham loaiSanPham, Model model) {
        loaiSanPhamService.updateLoaiSanPham(loaiSanPham);
        model.addAttribute("loaiSanPhams", loaiSanPham);
        return "redirect:/loai-san-pham/hien-thi";
    }
}
