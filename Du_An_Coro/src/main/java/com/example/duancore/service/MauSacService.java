package com.example.duancore.service;

import com.example.duancore.entity.MauSac;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MauSacService {
    List<MauSac> getAll();
    void add(MauSac ms);
    MauSac detail(String id);
    void update(MauSac ms);
    void delete(String id);
    Page<MauSac> findPage(Integer pageNo, Integer pageSize);
}
