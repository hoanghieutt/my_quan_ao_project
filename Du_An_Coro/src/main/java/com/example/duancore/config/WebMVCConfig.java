package com.example.duancore.config;

import com.example.duancore.entity.ChucVu;
import com.example.duancore.entity.HinhThucThanhToan;
import com.example.duancore.entity.KhachHang;
import com.example.duancore.entity.SanPham;
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


    @Bean("sanPham")
    public SanPham getSanPham(){
        SanPham sp = new SanPham();
        return sp;
    }

    //   Authorize the size web

//    @Autowired
//    loGinInterceptor loginInterceptor;
//
//    @Autowired
//    adminInterceptor adminInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//
//        //chỉ xem
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/checkout", "/profile","/product/list","/category/list");
//
//
//        //Phân quyền bắt đăng nhập
//        registry.addInterceptor(adminInterceptor)
//                .addPathPatterns("/admin/**", "/product/create", "/product/edit/{id}","/category/create","/category/edit/{id}","/product/delete/{id}","/category/delete/{id}");
//
//      }
//

    //how to code all language




}




