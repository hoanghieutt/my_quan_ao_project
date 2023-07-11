package com.demo.controller;

import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import com.demo.service.PhieuGiamGiaService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class PhieuGiamGiaController {
    @Autowired
    PhieuGiamGiaService service;

    @Data
    public static class SearchForm {
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fromDate;

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date toDate;

        Long maKhachHang;
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai(){
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @ModelAttribute("dsKhachHang")
    public List<KhachHang> getDsKhachHang(){
        return service.getDsKhachHang();
    }

    @RequestMapping("/phieugiamgia/index")
    public String index(Model model, @RequestParam(defaultValue="0")int p,
          @ModelAttribute("searchForm") SearchForm searchForm)
    {
        System.out.println("searchForm="+ searchForm);
        Pageable pageable = PageRequest.of(p, 5);
        Page<PhieuGiamGia> page = service.search(
            searchForm.fromDate, searchForm.toDate, searchForm.maKhachHang, pageable
        );

        model.addAttribute("phieugiamgia", new PhieuGiamGia());
        model.addAttribute("page", page);
        return "phieugiamgia/index";
    }

    @RequestMapping("/phieugiamgia/sort")
    public String sort(Model model, @RequestParam(defaultValue="0")int p,
           @ModelAttribute("searchForm") SearchForm searchForm) {

        // Sap xep theo nhieu truong

        Sort sort = Sort.by(
            new Sort.Order(Sort.Direction.ASC, "ngaybatdau"),
            new Sort.Order(Sort.Direction.ASC, "tenphieu")
        );
        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<PhieuGiamGia> page = service.search(
                searchForm.fromDate, searchForm.toDate, searchForm.maKhachHang, pageable
        );

        model.addAttribute("phieugiamgia", new PhieuGiamGia());
        model.addAttribute("page", page);
        return "phieugiamgia/index";
    }

    @GetMapping("/phieugiamgia/view-update/{maphieu}")
    public String viewUpdate(@PathVariable String maphieu, Model model){
        PhieuGiamGia phieugiamgia = service.getByMaPhieu(maphieu);
        model.addAttribute("phieugiamgia", phieugiamgia);
        return "phieugiamgia/update";
    }

    @GetMapping("/phieugiamgia/detail/{maphieu}")
    public String detail(@PathVariable String maphieu, Model model){
        PhieuGiamGia phieugiamgia = service.getByMaPhieu(maphieu);
        model.addAttribute("phieugiamgia", phieugiamgia);
        return "phieugiamgia/detail";
    }

    @PostMapping("/phieugiamgia/add")
    public String add(Model model,
          @Valid @ModelAttribute("phieugiamgia") PhieuGiamGia phieugiamgia,
          BindingResult bindingResult){

        boolean hasErrors = bindingResult.hasErrors();

        if(phieugiamgia.getNgaybatdau() != null && phieugiamgia.getNgayketthuc() != null &&
            phieugiamgia.getNgaybatdau().getTime() > phieugiamgia.getNgayketthuc().getTime()
        ) {
            model.addAttribute("dateError", "Ngày bắt đầu phải trước ngày kết thúc");
            hasErrors = true;
        }

        if(phieugiamgia.getMaphieu().trim().isEmpty()){
            model.addAttribute("maPhieuError", "Mã phiếu không được bỏ trống");
            hasErrors = true;
        }

        if(service.getByMaPhieu(phieugiamgia.getMaphieu()) != null){
            model.addAttribute("maPhieuError", "Mã phiếu đã tồn tại");
            hasErrors = true;
        }

        if(phieugiamgia.getNguoisohuu().getMakhachhang() == null) {
            model.addAttribute("maKHError", "Khách hàng không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "phieugiamgia/index";
        }

        service.save(phieugiamgia);
        return "redirect:/phieugiamgia/index";
    }

    @PostMapping("/phieugiamgia/update/{maphieu}")
    public String update(@PathVariable String maphieu,
         Model model,
        @Valid @ModelAttribute("phieugiamgia") PhieuGiamGia phieugiamgia,
         BindingResult bindingResult){

        boolean hasErrors = bindingResult.hasErrors();

        if(phieugiamgia.getNgaybatdau() != null && phieugiamgia.getNgayketthuc() != null &&
                phieugiamgia.getNgaybatdau().getTime() > phieugiamgia.getNgayketthuc().getTime()
        ) {
            model.addAttribute("dateError", "Ngày bắt đầu phải trước ngày kết thúc");
            hasErrors = true;
        }

        if(phieugiamgia.getNguoisohuu().getMakhachhang() == null) {
            model.addAttribute("maKHError", "Khách hàng không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "phieugiamgia/update";
        }

        System.out.println("ten=" + phieugiamgia.getTenphieu());
        System.out.println("gia tri giam=" + phieugiamgia.getGiatrigiam());
        // ....

        PhieuGiamGia phieugiamgiadb  = service.getByMaPhieu(maphieu);
        if(phieugiamgiadb != null){
            phieugiamgiadb.setTenphieu(phieugiamgia.getTenphieu());
            phieugiamgiadb.setGiatrigiam(phieugiamgia.getGiatrigiam());
            phieugiamgiadb.setGiatrigiamtoida(phieugiamgia.getGiatrigiamtoida());
            phieugiamgiadb.setNgaybatdau(phieugiamgia.getNgaybatdau());
            phieugiamgiadb.setNgayketthuc(phieugiamgia.getNgayketthuc());
            phieugiamgiadb.setNguoisohuu(phieugiamgia.getNguoisohuu());
            service.save(phieugiamgiadb);
        }

        return "redirect:/phieugiamgia/index";
    }

    @RequestMapping("/phieugiamgia/remove/{maphieu}")
    public String delete(@PathVariable String maphieu){
        service.deleteByMaPhieu(maphieu);
        return "redirect:/phieugiamgia/index";
    }
}
