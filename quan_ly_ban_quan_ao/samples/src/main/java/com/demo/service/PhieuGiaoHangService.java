package com.demo.service;

import com.demo.entity.DiaChi;
import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface PhieuGiaoHangService {
    public PhieuGiaoHang getByMaPhieu(UUID maphieu);
    public void deleteByMaPhieu(UUID maphieu);
    public void save(PhieuGiaoHang phieuGiaoHang);
    public List<DiaChi> getDsDiachi();
    public Page<PhieuGiaoHang> search(Date fromDate, Date toDate, UUID maDiachi, Pageable pageable);
}
