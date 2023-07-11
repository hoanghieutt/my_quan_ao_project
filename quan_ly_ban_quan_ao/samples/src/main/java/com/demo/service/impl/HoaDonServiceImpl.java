package com.demo.service.impl;

import com.demo.entity.*;
import com.demo.repo.HoaDonRepo;
import com.demo.repo.KhachHangRepo;
import com.demo.repo.PhieuGiaoHangRepo;
import com.demo.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepo repo;

    @Autowired
    PhieuGiaoHangRepo phieuGiaoHangRepo;

    @Autowired
    KhachHangRepo khachHangRepo;

    @Override
    public HoaDon getByMahoadon(Long mahoadon) {
        return repo.findById(mahoadon).orElse(null);
    }

    @Override
    public void deleteByMahoadon(Long mahoadon) {
        HoaDon hoadon = getByMahoadon(mahoadon);
        if(hoadon != null && hoadon.getPhieugiaohang() != null){
            PhieuGiaoHang phieugiaohang = hoadon.getPhieugiaohang();
            phieugiaohang.setHoadongiao(null);
            phieuGiaoHangRepo.save(phieugiaohang);
        }
        repo.deleteById(mahoadon);
    }

    @Override
    public void save(HoaDon hoadon) {
        repo.save(hoadon);
    }

    @Override
    public void savePhieu(HoaDon hoadon, UUID maphieu) {
        PhieuGiaoHang phieu = phieuGiaoHangRepo
                                .findById(maphieu)
                                .orElse(null);
        if(phieu != null){
            phieu.setHoadongiao(hoadon);
            phieuGiaoHangRepo.save(phieu);
        }
    }

    @Override
    public List<PhieuGiaoHang> getDsPhieu() {
        return phieuGiaoHangRepo.findAll();
    }

    @Override
    public List<KhachHang> getDsKhachHang() {
        return khachHangRepo.findAll();
    }

    @Override
    public Page<HoaDon> search(UUID maphieu, Date fromDate, Date toDate, Pageable pageable) {
        if(maphieu == null){
            return repo.searchByDate(fromDate, toDate, pageable);
        }else{
            return repo.searchByMaPhieuAndDate(maphieu, fromDate, toDate, pageable);
        }
    }
}
