package com.example.assigment_shoes.controller.vietnh;

import com.example.assigment_shoes.entity.KhuyenMai;
import com.example.assigment_shoes.repository.KhuyenMaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiRepository repository;

    String kwd="";
    @RequestMapping("/khuyenmai/view")
    public String KMview(){
        //Pageable pageable = PageRequest.of(pageNum, 3);
        List<KhuyenMai> list = repository.findAll();
        System.out.println(list);
        //model.addAttribute("kmpage", list);
        return "/vietNH/khuyen-mai/indexKM";
    }
}
