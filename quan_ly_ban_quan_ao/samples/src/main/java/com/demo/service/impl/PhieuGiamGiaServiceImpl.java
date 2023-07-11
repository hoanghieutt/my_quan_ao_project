package com.demo.service.impl;

import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import com.demo.repo.KhachHangRepo;
import com.demo.repo.PhieuGiamGiaRepo;
import com.demo.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {
    @Autowired
    PhieuGiamGiaRepo repo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public PhieuGiamGia getByMaPhieu(String maphieu) {
        return repo.findById(maphieu).orElse(null);
    }

    @Override
    public void deleteByMaPhieu(String maPhieu) {
        repo.deleteById(maPhieu);
    }

    @Override
    public void save(PhieuGiamGia phieuGiamGia) {
        repo.save(phieuGiamGia);
    }

    @Override
    public List<KhachHang> getDsKhachHang() {
        return khachHangRepo.findAll();
    }

    @Override
    public Page<PhieuGiamGia> search(Date fromDate, Date toDate, Long maKH, Pageable pageable) {
        return repo.search(fromDate, toDate, maKH, pageable);
    }

}
