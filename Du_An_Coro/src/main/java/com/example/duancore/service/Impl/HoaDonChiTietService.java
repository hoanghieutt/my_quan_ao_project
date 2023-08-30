package com.example.duancore.service.Impl;

import com.example.duancore.entity.GioHang;
import com.example.duancore.entity.HoaDonChiTiet;
import com.example.duancore.entity.KhachHang;
import com.example.duancore.repository.HoaDonChiTietRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonChiTietService {

    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    //Todo code list
    public List<HoaDonChiTiet> findAll(){

     return hoaDonChiTietRepository.findAll();

    }

    //Todo code save

    public void save(HoaDonChiTiet hoaDonChiTiet){

          hoaDonChiTietRepository.save(hoaDonChiTiet);

    }





}
