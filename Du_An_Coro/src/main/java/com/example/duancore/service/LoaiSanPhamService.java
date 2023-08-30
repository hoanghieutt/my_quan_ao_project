package com.example.duancore.service;


import com.example.duancore.entity.ChatLieu;
import com.example.duancore.entity.LoaiSanPham;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LoaiSanPhamService {
    List<LoaiSanPham> getAllLoaiSanPham();
    LoaiSanPham detailLoaiSanPham(String id);
    void  addLoaiSanPham(LoaiSanPham loaiSanPham);
    void deleteLoaiSanPham(String id);
    void  updateLoaiSanPham(LoaiSanPham loaiSanPham);
    Page<LoaiSanPham> findPage(Integer pageNo, Integer pageSize);
    List<LoaiSanPham>sreach(String ten, String trangThai);
}
