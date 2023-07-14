package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham,String> {
}
