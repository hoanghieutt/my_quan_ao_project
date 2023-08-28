package com.example.duancore.service.Impl;

import com.example.duancore.entity.GioHang;
import com.example.duancore.entity.KhachHang;
import com.example.duancore.entity.User;
import com.example.duancore.repository.ChiTietGioHangRepository;
import com.example.duancore.repository.GioHangRepository;
import com.example.duancore.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangService {

    @Autowired
    public GioHangRepository gioHangRepository;

    @Autowired
    public ChiTietGioHangRepository gioHangChiTietRepository;

    @Autowired
    public KhachHangRepository khachHangRepository;

//    public GioHang findByMaKH(KhachHang khachHang){
//
//         return gioHangRepository.findByMaKH(khachHang);
//
//    }

    @Autowired
    public GioHangService(GioHangRepository gioHangRepository) {
        this.gioHangRepository = gioHangRepository;
    }

    public GioHang findByMaNV(String maNV) {
        User user = new User();
        user.setMaNV(maNV);
        return gioHangRepository.findByMaNV(user);
    }



    public void addGioHang(GioHang gioHang){

         gioHangRepository.save(gioHang);

    }



}
