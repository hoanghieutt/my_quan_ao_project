package com.example.duancore.repository;

import com.example.duancore.entity.GioHang;
import com.example.duancore.entity.KhachHang;
import com.example.duancore.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang,String> {

    @Autowired(required = false)
    GioHang findByMaKH(KhachHang khachHang);

    GioHang findByMaNV(User maNV);

}
