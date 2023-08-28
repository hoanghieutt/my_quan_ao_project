package com.example.duancore.repository;


import com.example.duancore.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface KhachHangRepository extends JpaRepository<KhachHang, String> {


    @Query("SELECT kh FROM KhachHang kh WHERE kh.tenKH LIKE ?1 AND kh.ngayTao BETWEEN ?2 AND ?3")
    List<KhachHang> findByKeywordAndDate(String keyword, Date min, Date max);



}
