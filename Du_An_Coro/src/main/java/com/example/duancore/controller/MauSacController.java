package com.example.duancore.controller;

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

@Controller
public class MauSacController {
    @Autowired
    private MauSacService mauSacService;
    @GetMapping("/mau-sac/hien-thi")
    public String hienthi(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, @ModelAttribute("ms") MauSac ms, Model model) {
        Page<MauSac> page = mauSacService.findPage(pageNo,3);
        model.addAttribute("list",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("list",mauSacService.getAll());
        return "/mauSac/hienThi";
    }
    @GetMapping("/mau-sac/view-add")
    public String viewadd(@ModelAttribute("ms") MauSac ms, Model model) {
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
        MauSac ms = mauSacService.detail(id);
        model.addAttribute("ms",ms);
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
}
