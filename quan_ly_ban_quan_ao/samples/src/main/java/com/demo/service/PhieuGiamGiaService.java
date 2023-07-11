package com.demo.service;


import com.demo.entity.KhachHang;
import com.demo.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface PhieuGiamGiaService {
    public PhieuGiamGia getByMaPhieu(String maphieu);
    public void deleteByMaPhieu(String maPhieu);
    public void save(PhieuGiamGia phieuGiamGia);
    public List<KhachHang> getDsKhachHang();
    public Page<PhieuGiamGia> search(Date fromDate, Date toDate, Long maKH, Pageable pageable);
}
