package com.demo.service;

import com.demo.entity.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    public HoaDon getByMahoadon(Long mahoadon);
    public void deleteByMahoadon(Long mahoadon);
    public void save(HoaDon hoadon);
    public void savePhieu(HoaDon hoadon, UUID maphieu);
    public List<PhieuGiaoHang> getDsPhieu();
    public List<KhachHang> getDsKhachHang();
    public Page<HoaDon> search(UUID maphieu, Date fromDate, Date toDate, Pageable pageable);
}
