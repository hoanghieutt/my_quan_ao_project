package com.example.duancore.repository;


import com.example.duancore.entity.MonTheThao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonTheThaoRepository extends JpaRepository<MonTheThao,String> {
    @Query("select p from MonTheThao p where p.trangthai = 1 and p.ten like ?1 " +
            "or p.mamtt like ?1 and p.trangthai = 1")
    Page<MonTheThao> findByKwd(String s, Pageable pageable);

    @Query("select p from MonTheThao p where p.trangthai = 0")
    List<MonTheThao> findDeleted();

    @Query("select p from MonTheThao p where p.trangthai = 1 and p.ten like ?1 " +
            "or p.mamtt like ?1 and p.trangthai = 1")
    List<MonTheThao> listLoc(String s);
}
