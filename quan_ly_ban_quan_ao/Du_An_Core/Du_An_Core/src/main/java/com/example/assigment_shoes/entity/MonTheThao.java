package com.example.assigment_shoes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;


@Entity
public class MonTheThao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String maMTT;

    private String ten;

    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public MonTheThao() {
    }

    public MonTheThao(String maMTT, String ten, Date ngayTao, Date ngaySua, int trangThai) {
        this.maMTT = maMTT;
        this.ten = ten;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public String getMaMTT() {
        return maMTT;
    }

    public void setMaMTT(String maMTT) {
        this.maMTT = maMTT;
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
