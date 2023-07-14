package com.example.assigment_shoes.controller;

import com.example.assigment_shoes.entity.KhuyenMai;
import com.example.assigment_shoes.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository repository;

    String kwd = "";
    @RequestMapping("/KM/index")
    public String hienThiKM(@RequestParam(defaultValue = "0")Integer pageNum,
                            Model model){
        Pageable pageable = PageRequest.of(pageNum, 5);
        Page<KhuyenMai> listKM = repository.findByKwd("%"+kwd+"%", pageable);
        model.addAttribute("kmpage", listKM);

        List<KhuyenMai> daXoa = repository.findDeleted();
        model.addAttribute("kmX", daXoa);
        return "vietNH/khuyen-mai/indexKM";
    }

    @PostMapping("/KM/timKW")
    public String timKM(@RequestParam(defaultValue = "")String tukhoa){
        kwd = tukhoa.trim();
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/themKM")
    public String formThem(@ModelAttribute("fkm")KhuyenMai object,
                           Model model){
        model.addAttribute("malenh", "create");
        return "vietNH/khuyen-mai/formKM";
    }

    @PostMapping("/KM/create")
    public String themKM(@ModelAttribute("fkm")KhuyenMai object,
                         Model model){
        object.setNgaytao(String.valueOf(LocalDate.now()));
        object.setNgaysua(String.valueOf(LocalDate.now()));
        object.setTrangthai(1);
        repository.save(object);
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/suaKM/{id}")
    public String formSua(@ModelAttribute("fkm")KhuyenMai object,
                           @PathVariable("id") Integer id,
                           Model model){
        KhuyenMai km = repository.findById(id).get();
        model.addAttribute("fkm",km);
        model.addAttribute("malenh", "update");
        return "vietNH/khuyen-mai/formKM";
    }

    @PostMapping("/KM/update")
    public String suaKM(@ModelAttribute("fkm")KhuyenMai object,
                         Model model){
        object.setNgaysua(String.valueOf(LocalDate.now()));
        object.setTrangthai(1);
        repository.save(object);
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/xoaKM/{id}")
    public String xoaKM(@PathVariable("id") Integer id){
        KhuyenMai km = repository.findById(id).get();
        km.setNgaysua(String.valueOf(LocalDate.now()));
        km.setTrangthai(0);
        repository.save(km);
        return "redirect:/KM/index";
    }
}
