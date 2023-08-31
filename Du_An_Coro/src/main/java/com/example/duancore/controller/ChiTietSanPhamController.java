package com.example.duancore.controller;


import com.example.duancore.entity.*;
import com.example.duancore.repository.*;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "chiTietSanPham")
public class ChiTietSanPhamController {

    @Autowired
    ServletContext context;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private SizeRepository sizeRepository;

    @Autowired
    private ChatLieuRepository chatLieuRepository;

    @Autowired
    private MonTheThaoRepository monTheThaoRepository;

    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;


    //Todo code list chi tiết sản phẩm

    @GetMapping("listSanPhamChiTiet")
    public String listSanPham(Model model){


        List<ChiTietSanPham> ctsp = chiTietSanPhamRepository.findAll();
        System.out.println(ctsp.size());
        model.addAttribute("ctsp", ctsp);


        return "BanHang/listChiTietSanPham";

    }



    //Todo create chi tiết sản phẩm

    @GetMapping("createSanPham")
    public String createSanPham(Model model){

        model.addAttribute("sanpham", new ChiTietSanPham());

        List<SanPham> lstSP = sanPhamRepository.findAll();
        model.addAttribute("lstSP", lstSP);

        List<MauSac> lstMS = mauSacRepository.findAll();
        model.addAttribute("lstMS", lstMS);

        List<Size> lstSize = sizeRepository.findAll();
        model.addAttribute("lstSize", lstSize);

        List<ChatLieu> lstCL = chatLieuRepository.findAll();
        model.addAttribute("lstCL", lstCL);

        List<MonTheThao> lstMTT = monTheThaoRepository.findAll();
        model.addAttribute("lstMTT", lstMTT);

        List<LoaiSanPham> lstLSP = loaiSanPhamRepository.findAll();
        model.addAttribute("lstLSP", lstLSP);


        return "BanHang/create";

    }

    @PostMapping("createSanPham")
    public String showViewCreate(Model model,
                                 @ModelAttribute("sanpham") ChiTietSanPham chiTietSanPham,
                                 BindingResult result,
                                 RedirectAttributes attributes,
                                 @RequestParam("imageProduct") MultipartFile file){

      if(result.hasErrors()){

          System.out.println("Lỗi dữ liệu");
          return "BanHang/create";

      }

        String fileOriginal = file.getOriginalFilename();
        String fileDest = context.getRealPath("/upload/" +  fileOriginal);
        System.out.println(fileDest);

        try {
            file.transferTo(new File(fileDest));
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        chiTietSanPham.setImage(fileOriginal);
        chiTietSanPhamRepository.save(chiTietSanPham);


        attributes.addFlashAttribute("message","Create new product was successfully");
        return "redirect:/chiTietSanPham/listSanPhamChiTiet";

    }


    //Todo code detail chi tiết sản phẩm

    @GetMapping("/detailChiTietSanPham/{mactsp}")
    public String detailCTSanPham(@PathVariable String mactsp, Model model){

        model.addAttribute("sanpham", chiTietSanPhamRepository.findById(mactsp).orElse(null));

        return "BanHang/detail";

    }


    //Todo code update chi tiết sản phẩm


    //Todo code

}
