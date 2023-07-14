package com.example.assigment_shoes.config;

import com.example.assigment_shoes.entity.ChucVu;
import com.example.assigment_shoes.entity.HinhThucThanhToan;
import com.example.assigment_shoes.entity.KhachHang;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("thanhToan")
    public HinhThucThanhToan getThanhToan(){
        HinhThucThanhToan vm = new HinhThucThanhToan();
        return vm;
    }

    @Bean("khachHang")
    public KhachHang getKhachHang(){
        KhachHang vm = new KhachHang();
        return vm;
    }
    @Bean("cVu")
    public ChucVu getChucVu(){
        ChucVu vm = new ChucVu();
        return vm;
    }


}
