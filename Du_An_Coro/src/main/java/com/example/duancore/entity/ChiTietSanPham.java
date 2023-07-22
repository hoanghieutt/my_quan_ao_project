package com.example.duancore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ChiTietSanPham")

public class ChiTietSanPham {
    @Id
    @Column(name = "maCTSP")
    private String maCTSP;

    @ManyToOne
    @JoinColumn(name = "maSize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "maMS")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "maCL")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maLSP")
    private LoaiSanPham loaiSanPham;

    @ManyToOne
    @JoinColumn(name = "maMTT")
    private MonTheThao monTheThao;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "gia")
    private Double gia;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private Integer trangThai;
}
