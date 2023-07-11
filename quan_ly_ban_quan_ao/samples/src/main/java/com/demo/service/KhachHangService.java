package com.demo.service;

import com.demo.entity.HangKhachHang;
import com.demo.entity.KhachHang;
import com.demo.entity.TheThanhVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhachHangService {
    public KhachHang getByMaKH(Long maKH);
    public void deleteByMaKH(Long maKH);
    public void save(KhachHang kh);
    public void saveThe(KhachHang kh, String mathe);
    public List<HangKhachHang> getDsHangKH();
    public List<TheThanhVien> getDsThe();
    public Page<KhachHang> search(String keyword, Long mahang, String mathe, Pageable pageable);
}
