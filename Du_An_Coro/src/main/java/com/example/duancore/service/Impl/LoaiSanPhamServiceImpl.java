package com.example.duancore.service.Impl;


import com.example.duancore.entity.ChatLieu;
import com.example.duancore.entity.LoaiSanPham;
import com.example.duancore.repository.LoaiSanPhamRepository;
import com.example.duancore.service.LoaiSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        for (LoaiSanPham loaiSanPham : loaiSanPhamRepository.findAll()) {
            if (loaiSanPham.getMaLSP().equals(id)) {
                return loaiSanPham;
            }
        }
        return null;
    }

    @Override
    public void addLoaiSanPham(LoaiSanPham loaiSanPham) {
        loaiSanPham.setNgayTao(String.valueOf(LocalDate.now()));
        loaiSanPham.setNgaySua(String.valueOf(LocalDate.now()));
        loaiSanPham.setTrangThai(1);
        loaiSanPhamRepository.save(loaiSanPham);
    }

    @Override
    public void deleteLoaiSanPham(String id) {
        LoaiSanPham loaiSanPham = detailLoaiSanPham(id);
        loaiSanPhamRepository.delete(loaiSanPham);
    }

    @Override
    public void updateLoaiSanPham(LoaiSanPham loaiSanPham) {
        loaiSanPham.setNgayTao(String.valueOf(LocalDate.now()));
        loaiSanPham.setNgaySua(String.valueOf(LocalDate.now()));
        loaiSanPham.setTrangThai(1);
        loaiSanPhamRepository.save(loaiSanPham);
    }
    @Override
    public Page<LoaiSanPham> findPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return loaiSanPhamRepository.findAll(pageable);
    }
    @Override
    public List<LoaiSanPham> sreach(String ten, String trangThai) {
        return loaiSanPhamRepository.findByTenAndTrangThai(ten,Integer.valueOf(trangThai));
    }
}
