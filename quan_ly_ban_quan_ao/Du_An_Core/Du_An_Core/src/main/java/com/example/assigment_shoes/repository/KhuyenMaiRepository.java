package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai, Integer> {
}
