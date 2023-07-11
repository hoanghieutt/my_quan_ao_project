package com.demo.repo;

import com.demo.entity.HangKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangKhachHangRepo extends JpaRepository<HangKhachHang, Integer> {
}
