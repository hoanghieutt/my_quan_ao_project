package com.example.duancore.controller;

import com.example.duancore.entity.ChiTietSanPham;
import com.example.duancore.entity.KhachHang;
import com.example.duancore.entity.LoaiSanPham;
import com.example.duancore.entity.MonTheThao;
import com.example.duancore.repository.ChatLieuRepository;
import com.example.duancore.repository.ChiTietSanPhamRepository;
import com.example.duancore.repository.KhachHangRepository;
import com.example.duancore.repository.LoaiSanPhamRepository;
import com.example.duancore.repository.MauSacRepository;
import com.example.duancore.repository.MonTheThaoRepository;
import com.example.duancore.repository.SanPhamRepository;
import com.example.duancore.repository.SizeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;

@Controller
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    @Qualifier("ctsp")
    private ChiTietSanPham vm;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private MonTheThaoRepository monTheThaoRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @GetMapping("hien-thi")
    public String hienThi(Model model) {
        model.addAttribute("data", chiTietSanPhamRepository.findAll());

//        Date min = Date.valueOf("2020-01-01");
//        Date now = new Date(System.currentTimeMillis());
//
//        // Thêm giá trị mặc định vào model
//        model.addAttribute("minDate", min);
//        model.addAttribute("maxDate", now);
        return "/ctsp/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("vm", vm);
        model.addAttribute("action", "/chi-tiet-san-pham/store");
        model.addAttribute("listMTT", monTheThaoRepository.findAll());
        model.addAttribute("listChatLieu", chatLieuRepository.findAll());
        model.addAttribute("listMauSac", mauSacRepository.findAll());
        model.addAttribute("listLoaiSP", loaiSanPhamRepository.findAll());
        model.addAttribute("listSanPham", sanPhamRepository.findAll());
        model.addAttribute("listSize", sizeRepository.findAll());
        return "/ctsp/create";

    }

    @PostMapping("store")
    public String store(
            @Valid @ModelAttribute("vm") ChiTietSanPham chiTietSanPham, Model model,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "/ctsp/create";
        }
        String maCTSP = chiTietSanPham.getMaCTSP();

        if(chiTietSanPhamRepository.findByMaCTSP(maCTSP) != null){
            model.addAttribute("massageMaTrung", "Không được trùng mã");

            return "/ctsp/create";
        }
        if(chiTietSanPham.getChatLieu()==null){
            model.addAttribute("validateNull", "Không được để trống");
            return "/ctsp/create";
        }
        else {
            Date now = new Date(System.currentTimeMillis()); // Lấy ngày hiện tại
            chiTietSanPham.setNgayTao(now); // Đặt ngày tạo là ngày hiện tại
           chiTietSanPhamRepository.save(chiTietSanPham);
        }
        return "redirect:/chi-tiet-san-pham/hien-thi";
    }

}
