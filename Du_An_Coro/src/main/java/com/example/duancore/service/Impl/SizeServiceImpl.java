package com.example.duancore.service.Impl;

import com.example.duancore.entity.Size;
import com.example.duancore.repository.SizeRepository;
import com.example.duancore.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeServiceImpl implements SizeService {
    @Autowired
    private SizeRepository sizeRepository;
    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public void add(Size sz) {
        sizeRepository.save(sz);
    }

    @Override
    public Size detail(String id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Size sz) {
        sizeRepository.save(sz);
    }

    @Override
    public void delete(String id) {
        sizeRepository.deleteById(id);
    }

    @Override
    public Page<Size> findPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return sizeRepository.findAll(pageable);
    }

//    @Override
//    public List<Size> sreach(Integer min, Integer max) {
//        return sizeRepository.findBySizeBetween(min,max);
//    }

    @Override
    public Page<Size> searchBetwwenSize(Integer tuoiMin, Integer tuoiMax, Pageable pageable) {
        return sizeRepository.findBySizeBetween(tuoiMin,tuoiMax,pageable);
    }
}
