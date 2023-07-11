package com.demo.repo;

import com.demo.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.UUID;

public interface HoaDonRepo extends JpaRepository<HoaDon, Long> {

    @Query("SELECT h FROM HoaDon h WHERE (?1 IS NULL OR h.ngaylap >= ?1) AND(?2 IS NULL OR h.ngaylap <= ?2)")
    Page<HoaDon> searchByDate(Date fromDate, Date toDate, Pageable pageable);

    @Query("SELECT h FROM HoaDon h WHERE h.phieugiaohang.maphieugiao=?1 AND (?2 IS NULL OR h.ngaylap >= ?2) AND(?3 IS NULL OR h.ngaylap <= ?3)")
    Page<HoaDon> searchByMaPhieuAndDate(UUID maphieu, Date fromDate, Date toDate, Pageable pageable);
}
