package com.example.duancore.service.Impl;

import com.example.duancore.entity.HoaDon;
import com.example.duancore.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

    //Tìm kiếm tất cả
    public List<HoaDon> findAll() {

        return hoaDonRepository.findAll();

    }

    public void saveHoaDon(HoaDon hoaDon) {

        hoaDonRepository.save(hoaDon);

    }

    public HoaDon findBymaHD(String maHD){

          return hoaDonRepository.findByMaHD(maHD);

    }

    public HoaDon getHoaDonByMaHD(String maHD) {

        return hoaDonRepository.findByMaHD(maHD);

    }




}
