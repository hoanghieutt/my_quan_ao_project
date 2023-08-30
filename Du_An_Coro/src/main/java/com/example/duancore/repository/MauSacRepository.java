package com.example.duancore.repository;

import com.example.duancore.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, String> {
    @Query("select ms from MauSac ms where ms.ten like ?1 and ms.trangThai = ?2")
        List<MauSac> findByTenAndTrangThai(String ten,Integer trangThai);
//    List<MauSac>findMauSacByTenAndMaMS(String ten, String maMS);

}
