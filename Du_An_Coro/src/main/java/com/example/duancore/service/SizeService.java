package com.example.duancore.service;

import com.example.duancore.entity.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SizeService {
    List<Size> getAll();
    void add(Size sz);
    Size detail(String id);
    void update(Size sz);
    void delete(String id);
    Page<Size> findPage(Integer pageNo, Integer pageSize);
//    List<Size>sreach(Integer min, Integer max);
    Page<Size> searchBetwwenSize(Integer tuoiMin, Integer tuoiMax, Pageable pageable);

}
