package com.example.duancore.repository;


import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SizeRepository extends JpaRepository<Size,String> {
    @Query("SELECT sz FROM Size sz WHERE sz.size BETWEEN ?1 AND ?2")
//    List<Size> findBySizeBetween(Integer min, Integer max);
    Page<Size> findBySizeBetween(Integer tuoiMin, Integer tuoiMax, Pageable pageable);

}
