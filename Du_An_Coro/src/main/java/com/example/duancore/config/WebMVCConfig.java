package com.example.duancore.config;

import com.example.duancore.entity.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");

        registry
                .addResourceHandler("/upload/**")
                .addResourceLocations("/upload/");
    }

    @Bean("thanhToan")
    public HinhThucThanhToan getThanhToan(){
        HinhThucThanhToan vm = new HinhThucThanhToan();
        return vm;
    }

    @Bean("size")
    public Size getSize(){
        Size vm = new Size();
        return vm;
    }

    @Bean("mauSac")
    public MauSac getMauSac(){
        MauSac vm = new MauSac();
        return vm;
    }

    @Bean("khachHang")
    public KhachHang getKhachHang(){
        KhachHang vm = new KhachHang();
        return vm;
    }

    @Bean("user")
    public Users getnhanvien(){
        Users us = new Users();
        return us;
    }

    @Bean("ctsp")
    public ChiTietSanPham getCTSP(){
        ChiTietSanPham vm = new ChiTietSanPham();
        return vm;
    }

    @Bean("sanPham")
    public SanPham getSanPham(){
        SanPham sp = new SanPham();
        return sp;
    }

 @Autowired
    LogGinInterceptor loginInterceptor;

    @Autowired
    adminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){

        //Các file được xem
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/checkout", "/profile","","/category/list");


        //Phân quyền bắt đăng nhập
        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/admin/**","/sanPham/create", "/product/create", "/product/edit/{id}","/category/create","/category/edit/{id}","/product/delete/{id}","/category/delete/{id}");

      }


    //how to code all language



}




