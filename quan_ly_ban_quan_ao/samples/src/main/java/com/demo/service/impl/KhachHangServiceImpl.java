package com.demo.service.impl;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import com.demo.repo.HangKhachHangRepo;
import com.demo.repo.KhachHangRepo;
import com.demo.repo.TheThanhVienRepo;
import com.demo.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    TheThanhVienRepo theThanhVienRepo;

    @Autowired
    HangKhachHangRepo hangKhachHangRepo;

    @Autowired
    KhachHangRepo repo;

    @Override
    public KhachHang getByMaKH(Long maKH) {
        return repo.findById(maKH).orElse(null);
    }

    @Override
    public void deleteByMaKH(Long maKH) {
        KhachHang kh = getByMaKH(maKH);
        if(kh != null && kh.getThethanhvien() != null){
            TheThanhVien ttv = kh.getThethanhvien();
            ttv.setNguoisohuu(null);
            theThanhVienRepo.save(ttv);
        }
        repo.deleteById(maKH);
    }

    @Override
    public void save(KhachHang kh) {
        repo.save(kh);
    }

    @Override
    public void saveThe(KhachHang kh, String mathe) {
        TheThanhVien the = theThanhVienRepo
                .findById(mathe)
                .orElse(null);
        if(the != null){
            the.setNguoisohuu(kh);
            theThanhVienRepo.save(the);
        }
    }

    @Override
    public List<HangKhachHang> getDsHangKH() {
        return hangKhachHangRepo.findAll();
    }

    @Override
    public List<TheThanhVien> getDsThe() {
        return theThanhVienRepo.findAll();
    }

    @Override
    public Page<KhachHang> search(String keyword, Long mahang, String mathe, Pageable pageable) {
        if(mathe.isEmpty()) {
            return repo.searchByKeywordAndHang("%" + keyword + "%", mahang, pageable);
        }else{
            return repo.searchByKeywordAndHangAndMaThe("%" + keyword + "%", mahang, mathe, pageable);
        }
    }
}
