package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.sql.Date;
import java.util.List;

public interface ChucVuRepository extends JpaRepository<ChucVu,String> {
    @Query("SELECT cv FROM ChucVu cv WHERE cv.tenCV LIKE ?1 AND cv.ngayTao BETWEEN ?2 AND ?3")
    List<ChucVu> findByKeywordAndDate(String keyword, Date min, Date max);
}
