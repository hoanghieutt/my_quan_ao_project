package com.demo.repo;

import com.demo.entity.PhieuGiaoHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.UUID;

public interface PhieuGiaoHangRepo extends JpaRepository<PhieuGiaoHang, UUID> {

    @Query("SELECT p FROM PhieuGiaoHang p WHERE (?1 IS NULL OR p.ngaygiao >= ?1) AND (?2 IS NULL OR p.ngaygiao <= ?2) AND (?3 IS NULL OR p.diachigiao.madiachi=?3)")
    Page<PhieuGiaoHang> search(Date fromDate, Date toDate, UUID maDiachi, Pageable pageable);
}
