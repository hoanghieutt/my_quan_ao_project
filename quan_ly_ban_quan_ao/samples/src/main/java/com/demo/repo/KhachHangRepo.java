package com.demo.repo;

import com.demo.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhachHangRepo extends JpaRepository<KhachHang, Long> {

    @Query("SELECT kh FROM KhachHang kh WHERE (kh.tenkhachhang LIKE ?1 OR kh.sodienthoai LIKE ?1) AND (?2 IS NULL OR kh.hangkhachhang.mahang=?2)")
    Page<KhachHang> searchByKeywordAndHang(String keyword, Long mahang, Pageable pageable);

    @Query("SELECT kh FROM KhachHang kh WHERE (kh.tenkhachhang LIKE ?1 OR kh.sodienthoai LIKE ?1) AND (?2 IS NULL OR kh.hangkhachhang.mahang=?2) AND kh.thethanhvien.mathe=?3")
    Page<KhachHang> searchByKeywordAndHangAndMaThe(String keyword, Long mahang, String mathe, Pageable pageable);
}
