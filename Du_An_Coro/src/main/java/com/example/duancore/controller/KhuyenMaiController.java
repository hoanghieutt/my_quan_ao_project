package com.example.duancore.controller;


import com.example.duancore.entity.KhuyenMai;
import com.example.duancore.repository.KhuyenMaiRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    Double minVLs = 0.0;
    Double maxVLs = 100000000000000.0;

    Date startDs = doiVeNgay("1999-01-01");
    Date endDs = doiVeNgay("9999-12-20");

    @RequestMapping("/KM/index")
    public String hienThiKM(@RequestParam(defaultValue = "0")Integer pageNum,
                            Model model){

        List<KhuyenMai> soTrangKM = repository.findActive("%"+kwd+"%", minVLs, maxVLs, startDs, endDs);
        for(KhuyenMai k: soTrangKM){

            Date ngayKetThuc = k.getNgayketthuc();
            Date hienTai = doiVeNgay(String.valueOf(LocalDate.now()));

            if (ngayKetThuc.compareTo(hienTai)<0){
                k.setTrangthai(0);
                repository.save(k);
            }

        }

        Integer kiemTraTrang = 5;
        Integer soTrang = soTrangKM.size();

        if(pageNum>soTrang/kiemTraTrang){
            pageNum=soTrang/kiemTraTrang;
        }

        if (pageNum<0){
            pageNum=0;
        }

        Pageable pageable = PageRequest.of(pageNum, kiemTraTrang);
        Page<KhuyenMai> listKM = repository.findByKwd("%"+kwd+"%", minVLs, maxVLs, startDs, endDs, pageable);
        model.addAttribute("kmpage", listKM);

        return "vietNH/khuyen-mai/indexKM";
    }

    @RequestMapping("/KM/daxoa")
    public String bangDaXoa(Model model){
        List<KhuyenMai> daXoa = repository.findDeleted();
        model.addAttribute("kmX", daXoa);
        return "vietNH/khuyen-mai/daxoaKM";
    }

    @RequestMapping("/KM/return")
    public String trolai(){
        kwd = "";

        minVLs = 0.0;
        maxVLs = 100000000000000.0;

        startDs = doiVeNgay("1999-01-01");
        endDs = doiVeNgay("9999-12-20");
        return "redirect:/KM/index";
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
    public String timKM(@RequestParam(defaultValue = "")String tukhoa,
                        @RequestParam(defaultValue = "0.0")Double minVL,
                        @RequestParam(defaultValue = "100000000000000.0")Double maxVL,
                        @RequestParam(defaultValue = "1999-01-01")String startD,
                        @RequestParam(defaultValue = "9999-12-20")String endD){
        kwd = tukhoa.trim();
        minVLs = minVL;
        maxVLs = maxVL;
        startDs = doiVeNgay(startD);
        endDs = doiVeNgay(endD);
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/themKM")
    public String formThem(@ModelAttribute("fkm")KhuyenMai object,
                           Model model){
        return "vietNH/khuyen-mai/formKM";
    }

    @PostMapping("/KM/save")
    public String themKM(
            @Valid
            @ModelAttribute("fkm")KhuyenMai khuyenMai,
                         BindingResult result,
                         Model model){

        if(result.hasErrors()){
            if(null==khuyenMai.getNgayketthuc()){
                model.addAttribute("loiketthuc","Nhập ngày kết thúc");
            }

            if(null==khuyenMai.getNgaybatdau()){
                model.addAttribute("loibatdau","Nhập ngày bắt đầu");
            }

            return "vietNH/khuyen-mai/formKM";
        }

        Date batdau = khuyenMai.getNgaybatdau();
        Date ketthuc = khuyenMai.getNgayketthuc();

        if (ketthuc.compareTo(batdau)<0 ||
        khuyenMai.getGiamgia()<0){

            model.addAttribute("fkm", khuyenMai);

            if (ketthuc.compareTo(batdau)<0){
                model.addAttribute("loiketthuc","Ngày kết thúc phải trong hoặc sau ngày bắt đầu");
            }
            if (khuyenMai.getGiamgia()<0){
                model.addAttribute("loigiatri","Giá trị giảm không được là âm");
            }

            return "vietNH/khuyen-mai/formKM";
        }

        if(khuyenMai.getMakm()==null){
            khuyenMai.setNgaytao(String.valueOf(LocalDate.now()));
        }
        khuyenMai.setNgaysua(String.valueOf(LocalDate.now()));
        khuyenMai.setTrangthai(1);
        repository.save(khuyenMai);

         kwd = "";

         minVLs = 0.0;
         maxVLs = 100000000000000.0;

         startDs = doiVeNgay("1999-01-01");
         endDs = doiVeNgay("9999-12-20");
        return "redirect:/KM/index";
    }

    @RequestMapping("/KM/suaKM/{id}")
    public String formSua(@ModelAttribute("fkm")KhuyenMai object,
                           @PathVariable("id") Integer id,
                           Model model){
        KhuyenMai km = repository.findById(id).get();
        model.addAttribute("fkm",km);
         kwd = "";

         minVLs = 0.0;
         maxVLs = 100000000000000.0;

         startDs = doiVeNgay("1999-01-01");
         endDs = doiVeNgay("9999-12-20");
        return "vietNH/khuyen-mai/formKM";
    }


    @RequestMapping("/KM/xoaKM/{id}")
    public String xoaKM(@PathVariable("id") Integer id){
        KhuyenMai km = repository.findById(id).get();
        km.setNgaysua(String.valueOf(LocalDate.now()));
        km.setTrangthai(0);
        repository.save(km);

         kwd = "";

         minVLs = 0.0;
         maxVLs = 100000000000000.0;

         startDs = doiVeNgay("1999-01-01");
         endDs = doiVeNgay("9999-12-20");
        return "redirect:/KM/index";
    }
}
