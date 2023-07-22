package com.example.duancore.service;

import com.example.duancore.entity.Size;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SizeService {
    List<Size> getAll();
    void add(Size sz);
    Size detail(String id);
    void update(Size sz);
    void delete(String id);
    Page<Size> findPage(Integer pageNo, Integer pageSize);
}
