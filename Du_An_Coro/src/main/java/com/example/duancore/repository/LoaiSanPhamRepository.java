package com.example.duancore.repository;


import com.example.duancore.entity.ChatLieu;
import com.example.duancore.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, String> {
    @Query("select lsp from LoaiSanPham lsp where lsp.ten like ?1 and lsp.trangThai = ?2")
    List<LoaiSanPham> findByTenAndTrangThai(String ten, Integer trangThai);
}
