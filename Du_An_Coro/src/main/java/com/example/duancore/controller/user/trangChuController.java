package com.example.duancore.controller.user;

import com.example.duancore.entity.SanPham;
import com.example.duancore.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class trangChuController {

    @RequestMapping(value = "home")
    public String home(){

         return "index";

    }

    @Autowired
    private SanPhamRepository productRepository;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(

            Model model,
            @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize

    ) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<SanPham> page = productRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

        return "index";

    }


}
