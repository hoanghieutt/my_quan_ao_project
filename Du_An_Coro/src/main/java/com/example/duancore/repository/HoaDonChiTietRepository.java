package com.example.duancore.repository;

import com.example.duancore.entity.HoaDonChiTiet;
import com.example.duancore.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, String> {


}
