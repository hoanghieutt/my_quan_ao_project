package com.demo.controller;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import com.demo.service.KhachHangService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class KhachHangController {

    @Autowired
    KhachHangService service;

    @Data
    public static class SearchForm {
        String keyword = "";
        Long mahang;
        String mathe = "";
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai(){
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @ModelAttribute("dsGioiTinh")
    public  Map<Boolean, String> getDsGioiTinh(){
        Map<Boolean, String> dsGioiTinh = new HashMap<>();
        dsGioiTinh.put(false, "Nữ");
        dsGioiTinh.put(true, "Nam");
        return dsGioiTinh;
    }

    @ModelAttribute("dsThe")
    public List<TheThanhVien> getDsThe(){
        return service.getDsThe();
    }

    @ModelAttribute("dsHangKH")
    public List<HangKhachHang> getDsHangKH(){
        return service.getDsHangKH();
    }

    @RequestMapping("/khachhang/index")
    public String index(Model model, @RequestParam(defaultValue="0")int p,
        @ModelAttribute("searchForm") SearchForm searchForm)
    {
        System.out.println("searchForm="+ searchForm);
        Pageable pageable = PageRequest.of(p, 5);
        Page<KhachHang> page = service.search(
            searchForm.keyword, searchForm.mahang, searchForm.mathe, pageable
        );

        model.addAttribute("khachhang", new KhachHang());
        model.addAttribute("page", page);
        return "khachhang/index";
    }

    @RequestMapping("/khachhang/sort")
    public String sort(Model model, @RequestParam(defaultValue="0")int p,
       @ModelAttribute("searchForm") SearchForm searchForm)
    {
        Sort sort = Sort.by(Sort.Direction.ASC, "tenkhachhang");

        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<KhachHang> page = service.search(
            searchForm.keyword, searchForm.mahang, searchForm.mathe, pageable
        );

        model.addAttribute("khachhang", new KhachHang());
        model.addAttribute("page", page);
        return "khachhang/index";
    }

    @GetMapping("/khachhang/view-update/{maKH}")
    public String viewUpdate(@PathVariable Long maKH, Model model){
        KhachHang khachhang = service.getByMaKH(maKH);
        model.addAttribute("khachhang", khachhang);
        return "khachhang/update";
    }

    @GetMapping("/khachhang/detail/{maKH}")
    public String detail(@PathVariable Long maKH, Model model){
        KhachHang khachhang = service.getByMaKH(maKH);
        model.addAttribute("khachhang", khachhang);
        return "khachhang/detail";
    }

    boolean validateSdt(String sdt) {
        sdt = sdt.trim();
        if(sdt.isEmpty()) return false;
        if(sdt.charAt(0) != '0') return false;
        return sdt.length() == 10;
    }

    @PostMapping("/khachhang/add")
    public String add(Model model,
          @Valid @ModelAttribute("khachhang") KhachHang khachhang,
          BindingResult bindingResult)
    {
        boolean hasErrors = bindingResult.hasErrors();

        if(!validateSdt(khachhang.getSodienthoai()))
        {
            model.addAttribute("sdtError", "SĐT không hợp lệ");
            hasErrors = true;
        }

        if(khachhang.getHangkhachhang().getMahang() == null){
            model.addAttribute("mahangError", "Hạng khách hàng không được bỏ trống");
            hasErrors = true;
        }

        if(khachhang.getThethanhvien().getMathe().isEmpty()){
            model.addAttribute("matheError", "Thẻ thành viên không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "khachhang/index";
        }

        service.save(khachhang);
        service.saveThe(khachhang, khachhang.getThethanhvien().getMathe());
        return "redirect:/khachhang/index";
    }

    @PostMapping("/khachhang/update/{maKH}")
    public String update(@PathVariable Long maKH,
         Model model,
         @Valid @ModelAttribute("khachhang") KhachHang khachhang,
         BindingResult bindingResult)
    {

        boolean hasErrors = bindingResult.hasErrors();

        if(!validateSdt(khachhang.getSodienthoai()))
        {
            model.addAttribute("sdtError", "SĐT không hợp lệ");
            hasErrors = true;
        }

        if(khachhang.getHangkhachhang().getMahang() == null){
            model.addAttribute("mahangError", "Hạng khách hàng không được bỏ trống");
            hasErrors = true;
        }

        if(hasErrors){
            model.addAttribute("searchForm", new SearchForm());
            model.addAttribute("message", "Một số trường đang có lỗi");
            return "khachhang/update";
        }

        System.out.println("ten=" + khachhang.getTenkhachhang());
        System.out.println("sdt=" + khachhang.getSodienthoai());
        // ....

        KhachHang khachhangdb  = service.getByMaKH(maKH);
        if(khachhangdb != null){
            khachhangdb.setTenkhachhang(khachhang.getTenkhachhang());
            khachhangdb.setSodienthoai(khachhang.getSodienthoai());
            khachhangdb.setGioitinh(khachhang.getGioitinh());
            khachhangdb.setSinhnhat(khachhang.getSinhnhat());
            khachhangdb.setHangkhachhang(khachhang.getHangkhachhang());
            service.save(khachhangdb);
        }

        return "redirect:/khachhang/index";
    }

    @RequestMapping("/khachhang/remove/{maKH}")
    public String delete(@PathVariable Long maKH){
        service.deleteByMaKH(maKH);
        return "redirect:/khachhang/index";
    }
}
