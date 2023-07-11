package com.demo.service.impl;

import com.demo.entity.DiaChi;
import com.demo.entity.PhieuGiaoHang;
import com.demo.repo.DiaChiRepo;
import com.demo.repo.PhieuGiaoHangRepo;
import com.demo.service.PhieuGiaoHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PhieuGiaoHangServiceImpl implements PhieuGiaoHangService {
    @Autowired
    PhieuGiaoHangRepo repo;

    @Autowired
    DiaChiRepo diaChiRepo;

    @Override
    public PhieuGiaoHang getByMaPhieu(UUID maphieu) {
        return repo.findById(maphieu).orElse(null);
    }

    @Override
    public void deleteByMaPhieu(UUID maphieu) {
        repo.deleteById(maphieu);
    }

    @Override
    public void save(PhieuGiaoHang phieuGiaoHang) {
        repo.save(phieuGiaoHang);
    }

    @Override
    public List<DiaChi> getDsDiachi() {
        return diaChiRepo.findAll();
    }

    @Override
    public Page<PhieuGiaoHang> search(Date fromDate, Date toDate, UUID maDiachi, Pageable pageable) {
        return repo.search(fromDate, toDate, maDiachi, pageable);
    }
}
