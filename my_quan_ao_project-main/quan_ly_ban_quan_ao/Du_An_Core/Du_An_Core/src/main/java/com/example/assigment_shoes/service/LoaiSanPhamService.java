package com.example.assigment_shoes.service;


import com.example.assigment_shoes.entity.LoaiSanPham;

import java.util.List;

public interface LoaiSanPhamService {
    List<LoaiSanPham> getAllLoaiSanPham();
    LoaiSanPham detailLoaiSanPham(String id);
    void  addLoaiSanPham(LoaiSanPham loaiSanPham);
    void deleteLoaiSanPham(String id);
    void  updateLoaiSanPham(LoaiSanPham loaiSanPham);
}
