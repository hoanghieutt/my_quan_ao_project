package com.example.duancore.controller;

import com.example.duancore.entity.Size;
import com.example.duancore.service.SizeService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class SizeController {
    @Autowired
    private SizeService sizeService;

    @GetMapping("/size/hien-thi")
    public String hienthi(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, @ModelAttribute("sz") Size size, Model model) {
        Page<Size> page = sizeService.findPage(pageNo,3);
        model.addAttribute("list",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        model.addAttribute("list",sizeService.getAll());
        return "/Size/hienThi";
    }
    @GetMapping("/size/view-add")
    public String viewadd(@ModelAttribute("sz") Size sz, Model model) {
        return "/Size/add";
    }
    @PostMapping("/size/add")
    public String add(@Valid @ModelAttribute("sz") Size sz, BindingResult result, Model model) {
        if(result.hasErrors()){
            return "/Size/add";
        }
        sizeService.add(sz);
        return "redirect:/size/hien-thi";
    }
    @GetMapping("/size/delete/{id}")
    public String delete(@PathVariable("id") String id){
        sizeService.delete(id);
        return "redirect:/size/hien-thi";
    }
    @GetMapping("/size/detail/{id}")
    public String detail(@PathVariable("id") String id,Model model){
        Size sz = sizeService.detail(id);
        model.addAttribute("sz",sz);
        model.addAttribute("list",sizeService.getAll());
        return "/Size/hienThi";
    }
    @GetMapping("/size/view-update/{id}")
    public String viewupdate(@PathVariable("id") String id, Model model){
        Size sz = sizeService.detail(id);
        model.addAttribute("sz",sz);
        return "/Size/view-update";
    }
    @PostMapping("/size/update/{id}")
    public String update(@Valid @PathVariable("id") Size size, @ModelAttribute("sz") Size szz, BindingResult result , Model model) {
        if (result.hasErrors()) {
            return "/Size/view-update";
        } else {
            size.setMaSize(szz.getMaSize());
            size.setSize(szz.getSize());
            size.setSoLuong(szz.getSoLuong());
            size.setNgaySua(szz.getNgaySua());
            size.setTrangThai(szz.getTrangThai());
            sizeService.update(size);
            return "redirect:/size/hien-thi";
        }

    }
}
