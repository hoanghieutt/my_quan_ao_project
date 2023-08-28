package com.example.duancore.service.Impl;


import com.example.duancore.entity.LoaiSanPham;
import com.example.duancore.repository.LoaiSanPhamRepository;
import com.example.duancore.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;
    @Override
    public List<LoaiSanPham> getAllLoaiSanPham() {
        return loaiSanPhamRepository.findAll();
    }

    @Override
    public LoaiSanPham detailLoaiSanPham(String id) {
        return null;
    }

    @Override
    public void addLoaiSanPham(LoaiSanPham loaiSanPham) {

    }

    @Override
    public void deleteLoaiSanPham(String id) {

    }

    @Override
    public void updateLoaiSanPham(LoaiSanPham loaiSanPham) {

    }
}
