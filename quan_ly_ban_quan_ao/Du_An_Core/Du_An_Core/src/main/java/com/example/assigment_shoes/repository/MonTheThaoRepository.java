package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.MonTheThao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonTheThaoRepository extends JpaRepository<MonTheThao,String> {
}
