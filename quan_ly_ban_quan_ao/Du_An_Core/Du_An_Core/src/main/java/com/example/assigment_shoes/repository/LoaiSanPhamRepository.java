package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.LoaiSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiSanPhamRepository extends JpaRepository<LoaiSanPham, String> {

}
