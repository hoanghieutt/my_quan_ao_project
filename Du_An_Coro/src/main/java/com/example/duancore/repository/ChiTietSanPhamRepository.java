package com.example.duancore.repository;

import com.example.duancore.entity.ChiTietSanPham;
import com.example.duancore.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, String> {
    ChiTietSanPham findByMaCTSP(String maCTSP);
}
