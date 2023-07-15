package com.example.duancore.controller;


import com.example.duancore.entity.MonTheThao;
import com.example.duancore.repository.MonTheThaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MTTcontroller {
    @Autowired
    MonTheThaoRepository repository;

    String kwd = "";
    @RequestMapping("/mon_the_thao/index")
    public String hienMTT(@RequestParam(defaultValue = "0")Integer pageNum,
                          Model model){
        Integer cungvitri = 3;

        if (pageNum<0){
            pageNum=0;
        }

        List<MonTheThao> kiemchung = repository.listLoc("%"+kwd+"%");
        Integer soTrang = 0;
        for (MonTheThao mtt: kiemchung){
            if (mtt.getTrangthai()==1){
                soTrang++;
            }
        }

        if (pageNum>soTrang/cungvitri){
            pageNum = soTrang/cungvitri;
        }

        Pageable pageable = PageRequest.of(pageNum, cungvitri);
        Page<MonTheThao> mttl = repository.findByKwd("%"+kwd+"%", pageable);
        List<MonTheThao> mttX = repository.findDeleted();
        model.addAttribute("mttTable", mttl);
        model.addAttribute("mttTableD", mttX);
        return "vietNH/mtt/_index";
    }

    @RequestMapping("/mon_the_thao/form")
    public String formMTT(@ModelAttribute("mtt")MonTheThao monTheThao,
                          Model model){
        return "vietNH/mtt/_form";
    }

    @RequestMapping("/mon_the_thao/sua/{id}")
    public String suaMTT(@ModelAttribute("mtt")MonTheThao monTheThao,
                         Model model,
                         @PathVariable String id){
        MonTheThao mtt = repository.findById(id).get();
        model.addAttribute("mtt", mtt);
        return "vietNH/mtt/_form";
    }

    @PostMapping("/mon_the_thao/save")
    public String them(@ModelAttribute("mtt")MonTheThao monTheThao,
                          Model model){
        if(monTheThao.getNgaytao()==""){
            monTheThao.setNgaytao(String.valueOf(LocalDate.now()));
        }
        monTheThao.setNgaysua(String.valueOf(LocalDate.now()));
        monTheThao.setTrangthai(1);
        repository.save(monTheThao);
        kwd = "";
        return "redirect:/mon_the_thao/index";
    }

    @RequestMapping("/mon_the_thao/delete/{id}")
    public String xoa(@PathVariable String id){
        MonTheThao mtt = repository.findById(id).get();
        mtt.setTrangthai(0);
        mtt.setNgaysua(String.valueOf(LocalDate.now()));
        repository.save(mtt);
        return "redirect:/mon_the_thao/index";
    }

    @RequestMapping("/mon_the_thao/restore/{id}")
    public String layLai(@PathVariable String id){
        MonTheThao mtt = repository.findById(id).get();
        mtt.setTrangthai(1);
        mtt.setNgaysua(String.valueOf(LocalDate.now()));
        repository.save(mtt);
        return "redirect:/mon_the_thao/index";
    }

    @RequestMapping("/mon_the_thao/tim")
    public String findMTT(@RequestParam(defaultValue = "")String keyword){
        kwd = keyword;
        return "redirect:/mon_the_thao/index";
    }
}
