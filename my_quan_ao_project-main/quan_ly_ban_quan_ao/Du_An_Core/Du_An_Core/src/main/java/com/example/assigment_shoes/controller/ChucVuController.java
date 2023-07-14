package com.example.assigment_shoes.controller;

import com.example.assigment_shoes.entity.ChucVu;
import com.example.assigment_shoes.entity.HinhThucThanhToan;
import com.example.assigment_shoes.repository.ChucVuRepository;
import com.example.assigment_shoes.repository.HinhThucThanhToanRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {

    @Autowired
    @Qualifier("cVu")
    private ChucVu cv;

    @Autowired
    private ChucVuRepository repo;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("data", repo.findAll());
        Date min = Date.valueOf("2020-01-01");
        Date now = new Date(System.currentTimeMillis());

        // Thêm giá trị mặc định vào model
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", now);
        return "/chuc_vu/index";
    }


    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("cv", cv);
        model.addAttribute("action", "/chuc-vu/store");
        return "/chuc_vu/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("cv") ChucVu chucVu,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/chuc_vu/create";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            chucVu.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
            repo.save(chucVu);
        }
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("delete/{maCV}")
    public String delete(@PathVariable("maCV") String ma){
        repo.deleteById(ma);
        return "redirect:/chuc-vu/hien-thi";
    }

    @GetMapping("edit/{maCV}")
    public String edit(@PathVariable("maCV") ChucVu chucVu, Model model)
    {
        cv.setTenCV(chucVu.getTenCV());
        cv.setTrangThai(chucVu.getTrangThai());
        model.addAttribute("cv",cv);
        model.addAttribute("action","/chuc-vu/update/" + chucVu.getMaCV());
        return "/chuc_vu/update";
    }

    @PostMapping("update/{maCV}")
    public String update(@PathVariable("maCV") ChucVu chucVu,
                         @Valid @ModelAttribute("cv") ChucVu cvv,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/chuc_vu/update";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            chucVu.setNgaySua(now); // Đặt ngày tạo là ngày hiện tại
            chucVu.setTenCV(cvv.getTenCV());
            chucVu.setTrangThai(cvv.getTrangThai());
            repo.save(chucVu);
        }
        return "redirect:/chuc-vu/hien-thi";
    }

    @PostMapping("search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam("min") Date min, @RequestParam("max") Date max, Model model) {
        List<ChucVu> data = repo.findByKeywordAndDate("%" + keyword + "%", min, max);
        model.addAttribute("data", data);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", max);
        return "/chuc_vu/index";
    }

}
