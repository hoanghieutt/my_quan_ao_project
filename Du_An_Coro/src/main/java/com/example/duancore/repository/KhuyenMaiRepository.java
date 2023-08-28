package com.example.duancore.repository;


import com.example.duancore.entity.KhuyenMai;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KhuyenMaiRepository extends JpaRepository<KhuyenMai,Integer> {
    @Query("select p from KhuyenMai p where p.tenkm like ?1 and p.trangthai = 1")
    Page<KhuyenMai> findByKwd(String s, Pageable pageable);

    @Query("select p from KhuyenMai p where p.trangthai=0")
    List<KhuyenMai> findDeleted();

    @Query("select p from KhuyenMai p where p.trangthai=1 and p.tenkm like ?1")
    List<KhuyenMai> findActive(String s);
}
