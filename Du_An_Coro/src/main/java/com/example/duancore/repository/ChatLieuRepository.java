package com.example.duancore.repository;

import com.example.duancore.entity.ChatLieu;
import com.example.duancore.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu,String> {
    @Query("select cl from ChatLieu cl where cl.ten like ?1 and cl.trangThai = ?2")
    List<ChatLieu> findByTenAndTrangThai(String ten, Integer trangThai);
}
