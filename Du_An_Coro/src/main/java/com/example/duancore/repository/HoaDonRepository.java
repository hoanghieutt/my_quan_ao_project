package com.example.duancore.repository;

import com.example.duancore.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

    HoaDon findByMaHD(String maHD);

}
