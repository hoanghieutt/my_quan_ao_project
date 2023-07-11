package com.demo.controller;

import com.demo.entity.*;
import com.demo.service.HoaDonService;
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
import java.util.*;

@Controller
public class HoaDonController {
    @Autowired
    HoaDonService service;

    @Data
    public static class SearchForm {
        UUID maphieu;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fromDate;
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date toDate;
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai(){
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @ModelAttribute("dsPhieu")
    public List<PhieuGiaoHang> getDsPhieu(){
        return service.getDsPhieu();
    }

    @ModelAttribute("dsKhachHang")
    public List<KhachHang> getDsKhachHang(){
        return service.getDsKhachHang();
    }

    @RequestMapping("/hoadon/index")
    public String index(Model model, @RequestParam(defaultValue="0")int p,
        @ModelAttribute("searchForm") SearchForm searchForm)
    {
        System.out.println("searchForm="+ searchForm);
        Pageable pageable = PageRequest.of(p, 5);
        Page<HoaDon> page = service.search(
            searchForm.maphieu, searchForm.fromDate, searchForm.toDate, pageable
        );

        model.addAttribute("hoadon", new HoaDon());
        model.addAttribute("page", page);
        return "hoadon/index";
    }

    @RequestMapping("/hoadon/sort")
    public String sort(Model model, @RequestParam(defaultValue="0")int p,
           @ModelAttribute("searchForm") SearchForm searchForm)
    {
        Sort sort = Sort.by(Sort.Direction.ASC, "ngaylap");

        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<HoaDon> page = service.search(
                searchForm.maphieu, searchForm.fromDate, searchForm.toDate, pageable
        );

        model.addAttribute("hoadon", new HoaDon());
        model.addAttribute("page", page);
        return "hoadon/index";
    }

    @GetMapping("/hoadon/view-update/{mahoadon}")
    public String viewUpdate(@PathVariable Long mahoadon, Model model){
        HoaDon hoadon = service.getByMahoadon(mahoadon);
        model.addAttribute("hoadon", hoadon);
        return "hoadon/update";
    }

    @GetMapping("/hoadon/detail/{mahoadon}")
    public String detail(@PathVariable Long mahoadon, Model model){
        HoaDon hoadon = service.getByMahoadon(mahoadon);
        model.addAttribute("hoadon", hoadon);
        return "hoadon/detail";
    }

    @PostMapping("/hoadon/add")
    public String add(Model model,
        @Valid @ModelAttribute("hoadon") HoaDon hoadon,
          BindingResult bindingResult)
    {
        boolean hasErrors = bindingResult.hasErrors();

        if(hoadon.getNguoimua().getMakhachhang() == null){
            model.addAttribute("nguoimuaError", "Người mua không được bỏ trống");
            hasErrors = true;
        }

        if(hoadon.getPhieugiaohang().getMaphieugiao() == null){
            model.addAttribute("maphieuError", "Phiếu giao hàng không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "hoadon/index";
        }

        service.save(hoadon);
        service.savePhieu(hoadon, hoadon.getPhieugiaohang().getMaphieugiao());
        return "redirect:/hoadon/index";
    }

    @PostMapping("/hoadon/update/{mahoadon}")
    public String update(@PathVariable Long mahoadon,
         Model model,
         @Valid @ModelAttribute("hoadon") HoaDon hoadon,
         BindingResult bindingResult)
    {

        boolean hasErrors = bindingResult.hasErrors();

        if(hoadon.getNguoimua().getMakhachhang() == null){
            model.addAttribute("nguoimuaError", "Người mua không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "hoadon/update";
        }

        System.out.println("nguoilap=" + hoadon.getNguoilap());
        System.out.println("ghichu=" + hoadon.getGhichu());
        // ....

        HoaDon hoadondb  = service.getByMahoadon(mahoadon);
        if(hoadondb != null){
            hoadondb.setNguoilap(hoadon.getNguoilap());
            hoadondb.setNguoimua(hoadon.getNguoimua());
            hoadondb.setGhichu(hoadon.getGhichu());
            service.save(hoadondb);
        }

        return "redirect:/hoadon/index";
    }

    @RequestMapping("/hoadon/remove/{mahoadon}")
    public String delete(@PathVariable Long mahoadon){
        service.deleteByMahoadon(mahoadon);
        return "redirect:/hoadon/index";
    }
}
