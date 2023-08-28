package com.example.duancore.service.Impl;

import com.example.duancore.entity.ChiTietSanPham;

import java.util.List;

public interface IChiTietSanPhamService {

    List<ChiTietSanPham> finAll();

    void add(ChiTietSanPham chiTietSanPham);


}
