package com.example.assigment_shoes.repository;

import com.example.assigment_shoes.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,String> {
}
