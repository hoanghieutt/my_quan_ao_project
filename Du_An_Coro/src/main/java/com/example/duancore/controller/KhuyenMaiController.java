package com.example.duancore.controller;


import com.example.duancore.entity.KhuyenMai;
import com.example.duancore.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository repository;

    String kwd = "";
    @RequestMapping("/KM/index")
    public String hienThiKM(@RequestParam(defaultValue = "0")Integer pageNum,
                            Model model){

        List<KhuyenMai> soTrangKM = repository.findActive("%"+kwd+"%");
        for(KhuyenMai k: soTrangKM){

            Date ngayKetThuc = doiVeNgay(k.getNgayketthuc());
            Date hienTai = doiVeNgay(String.valueOf(LocalDate.now()));

            if (ngayKetThuc.compareTo(hienTai)<0){
                k.setTrangthai(0);
                repository.save(k);
            }

        }

        Integer kiemTraTrang = 5;

        if (pageNum<0){
            pageNum=0;
        }

        Integer soTrang = soTrangKM.size();

        if(pageNum>soTrang/kiemTraTrang){
            pageNum=soTrang/kiemTraTrang;
        }

        Pageable pageable = PageRequest.of(pageNum, kiemTraTrang);
        Page<KhuyenMai> listKM = repository.findByKwd("%"+kwd+"%", pageable);
        model.addAttribute("kmpage", listKM);

        List<KhuyenMai> daXoa = repository.findDeleted();
        model.addAttribute("kmX", daXoa);
        return "vietNH/khuyen-mai/indexKM";
    }

    private Date doiVeNgay(String ngayketthuc) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        //yyyy-mm-dd
        String nam = String.valueOf(ngayketthuc.charAt(0))+
                String.valueOf(ngayketthuc.charAt(1))+
                String.valueOf(ngayketthuc.charAt(2))+
                String.valueOf(ngayketthuc.charAt(3));

        String thang = String.valueOf(ngayketthuc.charAt(5))+
                String.valueOf(ngayketthuc.charAt(6));

        String ngay = String.valueOf(ngayketthuc.charAt(8))+
                String.valueOf(ngayketthuc.charAt(9));

        Date date = new Date();
        try {
            date = format.parse(ngay+"/"+thang+"/"+nam);
        }catch (Exception e){
            e.printStackTrace();
        }

        return date;
    }

    @PostMapping("/KM/timKW")
    public String timKM(@RequestParam(defaultValue = "")String tukhoa){
        kwd = tukhoa.trim();
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/themKM")
    public String formThem(@ModelAttribute("fkm")KhuyenMai object,
                           Model model){
        return "vietNH/khuyen-mai/formKM";
    }

    @PostMapping("/KM/save")
    public String themKM( @ModelAttribute("fkm")KhuyenMai khuyenMai,
                         Model model){
        if(khuyenMai.getMakm()==null){
            khuyenMai.setNgaytao(String.valueOf(LocalDate.now()));
        }
        khuyenMai.setNgaysua(String.valueOf(LocalDate.now()));
        khuyenMai.setTrangthai(1);
        repository.save(khuyenMai);
        kwd = "";
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/suaKM/{id}")
    public String formSua(@ModelAttribute("fkm")KhuyenMai object,
                           @PathVariable("id") Integer id,
                           Model model){
        KhuyenMai km = repository.findById(id).get();
        model.addAttribute("fkm",km);
        return "vietNH/khuyen-mai/formKM";
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
