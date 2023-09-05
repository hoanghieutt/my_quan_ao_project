package com.example.duancore.repository;

import com.example.duancore.entity.HoaDonChiTiet;
import com.example.duancore.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, String> {
    @Query("SELECT SUM(h.soLuong * h.gia) FROM HoaDonChiTiet h ")
    BigDecimal tinhTongDoanhThu();

    @Query("SELECT COUNT(h.mactsp) FROM HoaDonChiTiet h ")
    Integer tongDonHang();

    @Query("SELECT SUM(h.soLuong * h.gia) FROM HoaDonChiTiet h WHERE h.ngayTao = :ngayTao")
    BigDecimal tinhTongDoanhThuTheoNgay(Date ngayTao);

    @Query("SELECT h.mactsp.sanpham.tensp FROM HoaDonChiTiet h ORDER BY h.soLuong DESC limit 1")
    String timSanPhamBanChayNhat();

    @Query(value = "SELECT h.soLuong FROM HoaDonChiTiet h WHERE h.mactsp.sanpham.tensp = :maSanPham")
    Long tinhSoLuongDaBanCuaSanPham(@Param("maSanPham") String maSanPham);

}
