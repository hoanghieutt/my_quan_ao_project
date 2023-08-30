package com.example.duancore.controller;

import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.Size;
import com.example.duancore.service.SizeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Controller

public class SizeController {
    @Autowired
    private SizeService sizeService;

    @GetMapping("/size/hien-thi")
    public String hienthi(@RequestParam(name = "page",defaultValue = "0") Integer pageNo, Model model) {
        Page<Size> page = sizeService.findPage(pageNo,3);
        model.addAttribute("list",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        return "/Size/hienThi";
    }
    @GetMapping("/size/view-add")
    public String viewadd(@ModelAttribute("sz") Size sz, Model model) {
        Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
        sz.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
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
        Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
        sz.setNgaySua(now); // Đặt ngày tạo là ngày hiện tại
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

    @GetMapping("/size/search")
    public String serachBetwwenAge(@RequestParam("tuoiMin") Optional<Integer> min,
                                   @RequestParam("tuoiMax") Optional<Integer> max,
                                   @RequestParam(name = "page") Optional<Integer> pageNo,
                                   Model model){
        Pageable pageable = PageRequest.of(pageNo.orElse(0),5);
        Integer tuoiMin = min.orElse(Integer.MIN_VALUE);
        Integer tuoiMax = max.orElse(Integer.MAX_VALUE);
        Page<Size> page = sizeService.searchBetwwenSize(tuoiMin,tuoiMax,pageable);
        model.addAttribute("list",page);
        model.addAttribute("list",page.getContent());
        model.addAttribute("currentPage",page.getNumber());
        model.addAttribute("totalPages",page.getTotalPages());
        return "/Size/hienThi";
    }
}
