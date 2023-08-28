package com.example.duancore.controller.BanHang;

import com.example.duancore.entity.HoaDon;
import com.example.duancore.repository.HoaDonRepository;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/HoaDon")
public class HoaDonController {


    @Autowired
    ServletContext context;

    @Autowired
    private HoaDonRepository hoaDonRepository;

    //Todo code list hóa đơn
    @GetMapping("listHoaDon")
    public String listHoaDon(Model model){

        List<HoaDon> hoaDons = hoaDonRepository.findAll();
        System.out.println(hoaDons.size());
        model.addAttribute("hoaDons", hoaDons);
        return "hoaDon/list";

    }

    //Todo code create hoa đơn
    @GetMapping("create")
    public String createHoaDon(Model model){

        model.addAttribute("hoaDons", new HoaDon());
        return "hoaDon/create";

    }

    @PostMapping("create")
    public String save(Model model,
                       @Valid
                       @ModelAttribute("hoaDons") HoaDon hoaDon,
                       BindingResult result,
                       RedirectAttributes attributes){

        if(result.hasErrors()){

            return "hoaDon/create";

        }


        hoaDonRepository.save(hoaDon);
        attributes.addFlashAttribute("message", "Create new hóa đơn thành công !");
        //lưu chuyển hướng hóa đơn
        attributes.addFlashAttribute("maHD",hoaDon.getMaHD());//lưu chuyển hướng về thanh toán controller

        return "redirect:/HoaDon/listHoaDon";


    }


}
