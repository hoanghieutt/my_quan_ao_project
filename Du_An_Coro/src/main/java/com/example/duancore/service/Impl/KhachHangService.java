package com.example.duancore.service.Impl;

import com.example.duancore.entity.KhachHang;
import com.example.duancore.repository.KhachHangRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public List<KhachHang> findAll(){

        return khachHangRepository.findAll();

    }

    public KhachHang findByMaKHCheck(String maKH){

        return khachHangRepository.findById(maKH).get();

    }

    public KhachHang findByMaKH(String maKH) {
        if (maKH == null || maKH.isEmpty()) {
            // Xử lý trường hợp mã khách hàng null hoặc rỗng
            throw new IllegalArgumentException("Mã khách hàng không được trống");
        }

        Optional<KhachHang> khachHangOptional = khachHangRepository.findById(maKH);

        if (khachHangOptional.isPresent()) {
            return khachHangOptional.get();
        } else {
            // Xử lý trường hợp không tìm thấy khách hàng
            throw new EntityNotFoundException("Khách hàng không tồn tại với mã " + maKH);
        }
    }


}
