package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,String> {
}
