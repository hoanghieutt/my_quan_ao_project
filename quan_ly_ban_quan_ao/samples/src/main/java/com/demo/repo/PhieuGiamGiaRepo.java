package com.demo.repo;

import com.demo.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface PhieuGiamGiaRepo extends JpaRepository<PhieuGiamGia, String> {
    @Query("SELECT p FROM PhieuGiamGia p WHERE (?1 IS NULL OR p.ngaybatdau >= ?1) AND (?2 IS NULL OR p.ngayketthuc <= ?2) AND (?3 IS NULL OR p.nguoisohuu.makhachhang=?3)")
    Page<PhieuGiamGia> search(Date startDate, Date endDate, Long maKh, Pageable pageable);
}
