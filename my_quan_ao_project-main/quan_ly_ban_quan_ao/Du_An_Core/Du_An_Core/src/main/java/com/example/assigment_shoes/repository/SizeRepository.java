package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size,String> {
}
