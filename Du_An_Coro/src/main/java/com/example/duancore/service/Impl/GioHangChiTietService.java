package com.example.duancore.service.Impl;

import com.example.duancore.entity.ChiTietGioHang;
import com.example.duancore.entity.ChiTietSanPham;
import com.example.duancore.entity.GioHang;
import com.example.duancore.repository.ChiTietGioHangRepository;
import com.example.duancore.repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class GioHangChiTietService {

    @Autowired
    public ChiTietGioHangRepository gioHangChiTietRepository;

    @Autowired
    public ChiTietSanPhamRepository chiTietSanPhamRepository;


    //Todo code list
    public List<ChiTietGioHang> findAll(){

        return gioHangChiTietRepository.findAll();

    }

    public ChiTietGioHang findByAll(GioHang gioHang, ChiTietSanPham chiTietSanPham){

        return gioHangChiTietRepository.findByMaGHAndMactsp(gioHang, chiTietSanPham);

    }


    public ChiTietGioHang findByMaGHAndMaCTSP(GioHang gioHang, ChiTietSanPham chiTietSanPham){

        return gioHangChiTietRepository.findByMaGHAndMactsp(gioHang, chiTietSanPham);

    }

    //Todo code thêm sản phẩm vào giỏ hàng chi tiết
    public void themSPVaoGioHang(ChiTietGioHang chiTietGioHang){

        gioHangChiTietRepository.save(chiTietGioHang);

    }

    //Todo code tổng tiền
    public BigDecimal getTotal(List<ChiTietGioHang> list){

        return gioHangChiTietRepository.getTotal(list);

    }

    //Todo code delete sản phẩm trong giỏ hàng chi tiết
    public void delete(String maGHCT){

        if(gioHangChiTietRepository.existsById(maGHCT)) {

            gioHangChiTietRepository.deleteById(maGHCT);

        }
    }


    public void deleteGHCT(){

                gioHangChiTietRepository.deleteAll();

    }

    //Todo code tìm kiếm theo maGHCT
    public ChiTietGioHang findById(String maGHCT){

         return gioHangChiTietRepository.findById(maGHCT).get();

    }

}
