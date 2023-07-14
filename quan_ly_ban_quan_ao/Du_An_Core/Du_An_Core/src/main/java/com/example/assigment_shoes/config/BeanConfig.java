package com.example.assigment_shoes.config;

import com.example.assigment_shoes.entity.HinhThucThanhToan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("thanhToan")
    public HinhThucThanhToan getThanhToan(){
        HinhThucThanhToan vm = new HinhThucThanhToan();
        return vm;
    }

}
