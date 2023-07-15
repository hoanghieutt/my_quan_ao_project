package com.example.duancore.controller;


import com.example.duancore.entity.HinhThucThanhToan;
import com.example.duancore.repository.HinhThucThanhToanRepository;
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
@RequestMapping("hinh-thuc-thanh-toan")
public class HinhThucThanhToanController {

    @Autowired
    @Qualifier("thanhToan")
    private HinhThucThanhToan vm;

    @Autowired
    private HinhThucThanhToanRepository repo;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("data", repo.findAll());
        Date min = Date.valueOf("2020-01-01");
        Date now = new Date(System.currentTimeMillis());

        // Thêm giá trị mặc định vào model
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", now);
        return "/thanh_toan/index";
    }


    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/hinh-thuc-thanh-toan/store");
        return "/thanh_toan/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") HinhThucThanhToan hinhThucThanhToan,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/thanh_toan/create";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            hinhThucThanhToan.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
            repo.save(hinhThucThanhToan);
        }
        return "redirect:/hinh-thuc-thanh-toan/hien-thi";
    }

    @GetMapping("delete/{maHTTT}")
    public String delete(@PathVariable("maHTTT") String ma){
        repo.deleteById(ma);
        return "redirect:/hinh-thuc-thanh-toan/hien-thi";
    }

    @GetMapping("edit/{maHTTT}")
    public String edit(@PathVariable("maHTTT") HinhThucThanhToan hinhThucThanhToan, Model model)
    {
        vm.setTenHTTT(hinhThucThanhToan.getTenHTTT());
        vm.setTrangThai(hinhThucThanhToan.getTrangThai());
        model.addAttribute("vm",vm);
        model.addAttribute("action","/hinh-thuc-thanh-toan/update/" + hinhThucThanhToan.getMaHTTT());
        return "/thanh_toan/update";
    }

    @PostMapping("update/{maHTTT}")
    public String update(@PathVariable("maHTTT") HinhThucThanhToan hinhThucThanhToan,
            @Valid @ModelAttribute("vm") HinhThucThanhToan vmm,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/thanh_toan/update";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            hinhThucThanhToan.setNgaySua(now); // Đặt ngày tạo là ngày hiện tại
            hinhThucThanhToan.setTenHTTT(vmm.getTenHTTT());
            hinhThucThanhToan.setTrangThai(vmm.getTrangThai());
            repo.save(hinhThucThanhToan);
        }
        return "redirect:/hinh-thuc-thanh-toan/hien-thi";
    }

    @PostMapping("search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam("min") Date min, @RequestParam("max") Date max, Model model) {
        List<HinhThucThanhToan> data = repo.findByKeywordAndDate("%" + keyword + "%", min, max);
        model.addAttribute("data", data);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", max);
        return "/thanh_toan/index";
    }

//    @GetMapping("searchByDate")
//    public String searchByDate(@Param("min") Date min, @Param("max") Date max, Model model){
//        List<HinhThucThanhToan> data = repo.findByMinMax(min,max);
//        model.addAttribute("data",data);
//        model.addAttribute("minDate", min);
//        model.addAttribute("maxDate", max);
//        return "/thanh_toan/index";
//    }
//
//    @GetMapping("searchByKeyword")
//    public String searchByKeyword(@Param("keyword") String keyword, Model model){
//        List<HinhThucThanhToan> data = repo.findByKeyWord("%"+keyword+"%");
//        model.addAttribute("data",data);
//        model.addAttribute("keyword", keyword);
//        return "/thanh_toan/index";
//    }
}
