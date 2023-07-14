package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.HinhThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;


public interface HinhThucThanhToanRepository extends JpaRepository<HinhThucThanhToan, String> {
    @Query("SELECT httt FROM HinhThucThanhToan httt WHERE httt.tenHTTT LIKE ?1")
    List<HinhThucThanhToan> findByKeyWord(String keyword);

    @Query("SELECT httt FROM HinhThucThanhToan httt WHERE httt.ngayTao BETWEEN ?1 and ?2")
    List<HinhThucThanhToan> findByMinMax(Date min, Date max);
}
