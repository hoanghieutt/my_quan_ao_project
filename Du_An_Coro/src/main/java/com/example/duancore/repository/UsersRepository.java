package com.example.duancore.repository;

import com.example.duancore.entity.KhachHang;
import com.example.duancore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, String> {
    @Query("SELECT us FROM Users us WHERE us.tenNV LIKE ?1 AND us.ngayTao BETWEEN ?2 AND ?3")
    List<Users> findByKeywordAndDate(String keyword, Date min, Date max);
}
