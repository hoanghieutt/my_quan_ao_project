package com.example.duancore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "MauSac")
public class MauSac implements Serializable {
    @Id
    @Column(name = "maMS")
    @NotEmpty(message = "Vui lòng nhập mã màu sắc")
    private String maMS;
    @Column(name = "ten")
    @NotEmpty(message = "Vui lòng nhập tên màu sắc")
    private String ten;
    @Column(name = "ngayTao")

    private Date ngayTao;
    @Column(name = "ngaySua")

    private Date ngaySua;
    @Column(name = "trangThai")

    private int trangThai;
    public MauSac(String maMS, String ten, Date ngayTao, Date ngaySua, int trangThai) {
        this.maMS = maMS;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public MauSac() {
    }

    public String getMaMS() {
        return maMS;
    }

    public void setMaMS(String maMS) {
        this.maMS = maMS;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
