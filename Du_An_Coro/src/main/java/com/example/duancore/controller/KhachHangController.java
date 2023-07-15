package com.example.duancore.controller;

import com.example.duancore.entity.KhachHang;
import com.example.duancore.repository.KhachHangRepository;
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
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    @Qualifier("khachHang")
    private KhachHang vm;

    @Autowired
    private KhachHangRepository repo;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("data", repo.findAll());
        Date min = Date.valueOf("2020-01-01");
        Date now = new Date(System.currentTimeMillis());

        // Thêm giá trị mặc định vào model
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", now);
        return "/khach_hang/index";
    }

    

    @GetMapping("create")
    public String create(Model model)
    {
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/khach-hang/store");
        return "/khach_hang/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") KhachHang khachHang,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/khach_hang/create";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            khachHang.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
            repo.save(khachHang);
        }
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("delete/{maKH}")
    public String delete(@PathVariable("maKH") String ma){
        repo.deleteById(ma);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("edit/{maKH}")
    public String edit(@PathVariable("maKH") KhachHang khachHang, Model model)
    {
        vm.setTenKH(khachHang.getTenKH());
        vm.setNgaySinh(khachHang.getNgaySinh());
        vm.setGioiTinh(khachHang.getGioiTinh());
        vm.setSoDienThoai(khachHang.getSoDienThoai());
        vm.setDiaChi(khachHang.getDiaChi());
        vm.setTrangThai(khachHang.getTrangThai());
        model.addAttribute("vm",vm);
        model.addAttribute("action","/khach-hang/update/" + khachHang.getMaKH());
        return "/khach_hang/update";
    }

    @PostMapping("update/{maKH}")
    public String update(@PathVariable("maKH") KhachHang khachHang,
                         @Valid @ModelAttribute("vm") KhachHang vmm,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/khach_hang/update";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            khachHang.setNgaySua(now); // Đặt ngày tạo là ngày hiện tại
            khachHang.setTenKH(vmm.getTenKH());
            khachHang.setNgaySinh(vmm.getNgaySinh());
            khachHang.setGioiTinh(vmm.getGioiTinh());
            khachHang.setSoDienThoai(vmm.getSoDienThoai());
            khachHang.setDiaChi(vmm.getDiaChi());
            khachHang.setTrangThai(vmm.getTrangThai());
            repo.save(khachHang);
        }
        return "redirect:/khach-hang/hien-thi";
    }

    @PostMapping("search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam("min") Date min, @RequestParam("max") Date max, Model model) {
        List<KhachHang> data = repo.findByKeywordAndDate("%" + keyword + "%", min, max);
        model.addAttribute("data", data);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", max);
        return "/khach_hang/index";
    }
}
