package com.example.duancore.controller;

import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.MauSac;
import com.example.duancore.entity.Size;
import com.example.duancore.service.MauSacService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;

@Controller
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @GetMapping("/mau-sac/hien-thi")
    public String hienthi(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, Model model) {
        Page<MauSac> page = mauSacService.findPage(pageNo,3);
        model.addAttribute("list",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        return "/mauSac/hienThi";
    }
    @GetMapping("/mau-sac/view-add")
    public String viewadd(@ModelAttribute("ms") MauSac ms, Model model) {
        Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
        ms.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
        return "/mauSac/add";
    }
    @PostMapping("/mau-sac/add")
    public String add(@Valid @ModelAttribute("ms") MauSac ms, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "/mauSac/add";
        }
        mauSacService.add(ms);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/delete/{id}")
    public String delete(@PathVariable("id") String id){
        mauSacService.delete(id);
        return "redirect:/mau-sac/hien-thi";
    }
    @GetMapping("/mau-sac/detail/{id}")
    public String detail(@PathVariable("id") String id,Model model){
        MauSac ms = mauSacService.detail(id);
        model.addAttribute("ms",ms);
        model.addAttribute("list",mauSacService.getAll());
        return "/mauSac/hienThi";
    }
    @GetMapping("/mau-sac/view-update/{id}")
    public String viewupdate(@PathVariable("id") String id, Model model){
        MauSac mss = mauSacService.detail(id);
        model.addAttribute("ms",mss);
        Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
        mss.setNgaySua(now); // Đặt ngày tạo là ngày hiện tại
        return "/mauSac/view-update";
    }
    @PostMapping("/mau-sac/update/{id}")
    public String update(@Valid @PathVariable("id") MauSac mauSac,@ModelAttribute("ms") MauSac mss,BindingResult result, Model model){
        if (result.hasErrors()) {
            return "/mauSac/view-update";
        } else {
            mauSac.setMaMS(mss.getMaMS());
            mauSac.setTen(mss.getTen());
            mauSac.setNgaySua(mss.getNgaySua());
            mauSac.setTrangThai(mss.getTrangThai());
            mauSacService.update(mauSac);
            return "redirect:/mau-sac/hien-thi";
        }
    }
    @PostMapping("/mau-sac/sreach")
    public String sreach(@RequestParam(name = "page",defaultValue = "0") Integer pageNo,@RequestParam("ten") String ten,@RequestParam("trangThai") String trangThai, Model model) {
        Page<MauSac> page = mauSacService.findPage(pageNo,3);
        model.addAttribute("ten", mauSacService.sreach(ten,trangThai));
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("list",page.getContent());

        return "/mauSac/hienThi";
    }
}
