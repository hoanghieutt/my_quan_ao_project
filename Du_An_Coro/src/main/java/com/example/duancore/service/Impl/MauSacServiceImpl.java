package com.example.duancore.service.Impl;

import com.example.duancore.entity.MauSac;
import com.example.duancore.repository.MauSacRepository;
import com.example.duancore.service.MauSacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacServiceImpl implements MauSacService {
    @Autowired
    private MauSacRepository mauSacRepository;

    @Override
    public List<MauSac> getAll() {
        return mauSacRepository.findAll();
    }

    @Override
    public void add(MauSac ms) {
    mauSacRepository.save(ms);
    }

    @Override
    public MauSac detail(String id) {
        return mauSacRepository.findById(id).orElse(null);
    }

    @Override
    public void update(MauSac ms) {
    mauSacRepository.save(ms);
    }

    @Override
    public void delete(String id) {
    mauSacRepository.deleteById(id);
    }

    @Override
    public Page<MauSac> findPage(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return mauSacRepository.findAll(pageable);
    }

    @Override
    public List<MauSac> sreach(String ten,String trangThai) {
        return mauSacRepository.findByTenAndTrangThai(ten,Integer.valueOf(trangThai));
    }
}
