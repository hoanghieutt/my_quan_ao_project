package com.example.duancore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "SanPham")
public class SanPham {

    @Id
    @NotBlank(message = "Vui lòng nhập mã sản phẩm")
    @Column(name = "maSP")
    private String masp;

    @Column(name = "image")
    private String image;

    @NotBlank(message = "Vui lòng nhập tên sản phẩm")
    @Column(name = "tenSP")
    private String tensp;

    @Column(name = "soLuong")
    private int soluong;

    @Column(name = "ngayTao")
    private String ngaytao;

    @Column(name = "ngaySua")
    private String ngaysua;

    @Column(name = "trangThai")
    private int trangthai;


    public SanPham() {
    }

    public SanPham(String masp, String image, String tensp, int soluong, String ngaytao, String ngaysua, int trangthai) {
        this.masp = masp;
        this.image = image;
        this.tensp = tensp;
        this.soluong = soluong;
        this.ngaytao = ngaytao;
        this.ngaysua = ngaysua;
        this.trangthai = trangthai;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public String getNgaysua() {
        return ngaysua;
    }

    public void setNgaysua(String ngaysua) {
        this.ngaysua = ngaysua;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
}
