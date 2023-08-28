package com.example.duancore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.duancore.entity.testcsv;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCSVRepository extends JpaRepository<testcsv,String> {
}
