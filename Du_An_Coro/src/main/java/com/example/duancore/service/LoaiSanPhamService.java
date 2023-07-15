package com.example.duancore.service;


import com.example.duancore.entity.LoaiSanPham;

import java.util.List;

public interface LoaiSanPhamService {
    List<LoaiSanPham> getAllLoaiSanPham();
    LoaiSanPham detailLoaiSanPham(String id);
    void  addLoaiSanPham(LoaiSanPham loaiSanPham);
    void deleteLoaiSanPham(String id);
    void  updateLoaiSanPham(LoaiSanPham loaiSanPham);
}
