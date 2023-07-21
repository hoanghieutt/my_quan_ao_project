package com.example.duancore.controller;

import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.Users;
import com.example.duancore.repository.ChucVuRepository;
import com.example.duancore.repository.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("Users")
public class UsersController {
    @Autowired
    @Qualifier("users")
    private Users us;

    @Autowired
    private UsersRepository repo;

    @Autowired
    private ChucVuRepository chucVuRepository;

    @GetMapping("hien-thi")
    public String hienThi(Model model){
        model.addAttribute("data", repo.findAll());
        Date min = Date.valueOf("2020-01-01");
        Date now = new Date(System.currentTimeMillis());

        // Thêm giá trị mặc định vào model
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", now);
        return "/Users/list";
    }



    @GetMapping("create")
    public String create(Model model)
    {
        ArrayList<ChucVu> listcv = (ArrayList<ChucVu>) chucVuRepository.findAll();
        model.addAttribute("cv",listcv);
        model.addAttribute("us", us);
        model.addAttribute("action", "/Users/store");
        return "/Users/create";
    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("us") Users users,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/Users/create";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            users.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
            repo.save(users);
        }
        return "redirect:/Users/hien-thi";
    }

    @GetMapping("delete/{maNV}")
    public String delete(@PathVariable("maNV") String ma){
        repo.deleteById(ma);
        return "redirect:/Users/hien-thi";
    }

    @GetMapping("edit/{maNV}")
    public String edit(@PathVariable("maNV") Users users, Model model)
    {

        us.setTenNV(users.getTenNV());
        us.setMaCV(users.getMaCV());
        us.setNgaySinh(users.getNgaySinh());
        us.setGioiTinh(users.getGioiTinh());
        us.setSoDienThoai(users.getSoDienThoai());
        us.setDiaChi(users.getDiaChi());
        us.setTrangThai(users.getTrangThai());
        us.setEmail(users.getEmail());
        us.setRole(users.getRole());
        ArrayList<ChucVu> listcv = (ArrayList<ChucVu>) chucVuRepository.findAll();
        model.addAttribute("cv",listcv);
        model.addAttribute("us",us);
        model.addAttribute("action","/Users/update/" + users.getMaNV());
        return "/Users/update";
    }

    @PostMapping("update/{maNV}")
    public String update(@PathVariable("maNV") Users users,
                         @Valid @ModelAttribute("us") Users vmm,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/Users/update";
        } else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            users.setNgaySua(now); // Đặt ngày tạo là ngày hiện tại
            users.setTenNV(vmm.getTenNV());
            users.setNgaySinh(vmm.getNgaySinh());
            users.setGioiTinh(vmm.getGioiTinh());
            users.setSoDienThoai(vmm.getSoDienThoai());
            users.setDiaChi(vmm.getDiaChi());
            users.setTrangThai(vmm.getTrangThai());
            users.setEmail(vmm.getEmail());
            users.setRole(vmm.getRole());
            repo.save(users);
        }
        return "redirect:/Users/hien-thi";
    }

    @PostMapping("search")
    public String search(@RequestParam("keyword") String keyword, @RequestParam("min") Date min, @RequestParam("max") Date max, Model model) {
        List<Users> data = repo.findByKeywordAndDate("%" + keyword + "%", min, max);
        model.addAttribute("data", data);
        model.addAttribute("keyword", keyword);
        model.addAttribute("minDate", min);
        model.addAttribute("maxDate", max);
        return "/Users/list";
    }
}
