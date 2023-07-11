package com.demo.controller;

import com.demo.entity.DiaChi;
import com.demo.entity.PhieuGiaoHang;
import com.demo.service.PhieuGiaoHangService;
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
public class PhieuGiaoHangController {
    @Autowired
    PhieuGiaoHangService service;

    @Data
    public static class SearchForm {
        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date fromDate;

        @DateTimeFormat(pattern = "dd/MM/yyyy")
        Date toDate;

        UUID maDiachi;
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai(){
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @ModelAttribute("dsDiachi")
    public List<DiaChi> getDsDiachi(){
        return service.getDsDiachi();
    }

    @RequestMapping("/phieugiaohang/index")
    public String index(Model model, @RequestParam(defaultValue="0")int p,
        @ModelAttribute("searchForm") SearchForm searchForm)
    {
        System.out.println("searchForm="+ searchForm);
        Pageable pageable = PageRequest.of(p, 5);
        Page<PhieuGiaoHang> page = service.search(
            searchForm.fromDate, searchForm.toDate, searchForm.maDiachi, pageable
        );

        model.addAttribute("phieugiaohang", new PhieuGiaoHang());
        model.addAttribute("page", page);
        return "phieugiaohang/index";
    }

    @RequestMapping("/phieugiaohang/sort")
    public String sort(Model model, @RequestParam(defaultValue="0")int p,
       @ModelAttribute("searchForm") SearchForm searchForm) {
        Sort sort = Sort.by(Sort.Direction.ASC, "ngaygiao");
        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<PhieuGiaoHang> page = service.search(
            searchForm.fromDate, searchForm.toDate, searchForm.maDiachi, pageable
        );

        model.addAttribute("phieugiaohang", new PhieuGiaoHang());
        model.addAttribute("page", page);
        return "phieugiaohang/index";
    }

    @GetMapping("/phieugiaohang/view-update/{maphieu}")
    public String viewUpdate(@PathVariable UUID maphieu, Model model){
        PhieuGiaoHang phieugiaohang = service.getByMaPhieu(maphieu);
        model.addAttribute("phieugiaohang", phieugiaohang);
        return "phieugiaohang/update";
    }

    @GetMapping("/phieugiaohang/detail/{maphieu}")
    public String detail(@PathVariable UUID maphieu, Model model){
        PhieuGiaoHang phieugiaohang = service.getByMaPhieu(maphieu);
        model.addAttribute("phieugiaohang", phieugiaohang);
        return "phieugiaohang/detail";
    }

    boolean validateSdt(String sdt) {
        sdt = sdt.trim();
        if(sdt.isEmpty()) return false;
        if(sdt.charAt(0) != '0') return false;
        return sdt.length() == 10;
    }

    @PostMapping("/phieugiaohang/add")
    public String add(Model model,
          @Valid @ModelAttribute("phieugiaohang") PhieuGiaoHang phieugiaohang,
          BindingResult bindingResult)
    {

        boolean hasErrors = bindingResult.hasErrors();

        if(!validateSdt(phieugiaohang.getSdtnhan())){
            model.addAttribute("sdtNhanError", "Số điện thoại không hợp lệ");
        }

        if(phieugiaohang.getDiachigiao().getMadiachi() == null) {
            model.addAttribute("maDiachiError", "Địa chỉ không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "phieugiaohang/index";
        }

        service.save(phieugiaohang);
        return "redirect:/phieugiaohang/index";
    }

    @PostMapping("/phieugiaohang/update/{maphieu}")
    public String update(@PathVariable UUID maphieu,
         Model model,
         @Valid @ModelAttribute("phieugiaohang") PhieuGiaoHang phieugiaohang,
         BindingResult bindingResult)
    {

        boolean hasErrors = bindingResult.hasErrors();

        if(!validateSdt(phieugiaohang.getSdtnhan())){
            model.addAttribute("sdtNhanError", "Số điện thoại không hợp lệ");
        }

        if(phieugiaohang.getDiachigiao().getMadiachi() == null) {
            model.addAttribute("maDiachiError", "Địa chỉ không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "phieugiaohang/update";
        }

        System.out.println("nguoi nhan=" + phieugiaohang.getNguoinhan());
        System.out.println("sdt nhan=" + phieugiaohang.getSdtnhan());
        // ....

        PhieuGiaoHang phieugiaohangdb  = service.getByMaPhieu(maphieu);
        if(phieugiaohangdb != null){
            phieugiaohangdb.setNguoinhan(phieugiaohang.getNguoinhan());
            phieugiaohangdb.setSdtnhan(phieugiaohang.getSdtnhan());
            phieugiaohangdb.setNgaygiao(phieugiaohang.getNgaygiao());
            phieugiaohangdb.setDiachigiao(phieugiaohang.getDiachigiao());
            service.save(phieugiaohangdb);
        }

        return "redirect:/phieugiaohang/index";
    }

    @RequestMapping("/phieugiaohang/remove/{maphieu}")
    public String delete(@PathVariable UUID maphieu){
        service.deleteByMaPhieu(maphieu);
        return "redirect:/phieugiaohang/index";
    }
}
