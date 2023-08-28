package com.example.duancore.service.Impl;

import com.example.duancore.entity.ChiTietSanPham;
import com.example.duancore.repository.ChiTietSanPhamRepository;
import com.example.duancore.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChiTietSanPhamService   {

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    public List<ChiTietSanPham> findAll(){

        return chiTietSanPhamRepository.findAll();

    }

    public void add(ChiTietSanPham chiTietSanPham){

         chiTietSanPhamRepository.save(chiTietSanPham);

    }

    public ChiTietSanPham finByIdSP(String maCTSP) {

        return chiTietSanPhamRepository.findById(maCTSP).get();

    }




}
