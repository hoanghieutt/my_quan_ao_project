package com.example.duancore.repository;

import com.example.duancore.entity.ChiTietGioHang;
import com.example.duancore.entity.ChiTietSanPham;
import com.example.duancore.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ChiTietGioHangRepository extends JpaRepository<ChiTietGioHang,String> {

    ChiTietGioHang findByMaGHAndMactsp(GioHang gioHang, ChiTietSanPham chiTietSanPham);

    @Query("SELECT SUM(donGia) FROM ChiTietGioHang ")
    BigDecimal getTotal(List<ChiTietGioHang> list);

}
