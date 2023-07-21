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

@Entity
@Table(name = "ChiTietSanPham")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ChiTietSanPham {
    @Id
    @Column(name = "maCTSP")
    private String maCTSP;

    @ManyToOne
    @JoinColumn(name = "maSize", referencedColumnName = "maSize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "maMS", referencedColumnName = "maMS")
    private MauSac mauSac;

    @ManyToOne
    @JoinColumn(name = "maCL", referencedColumnName = "maCL")
    private ChatLieu chatLieu;

    @ManyToOne
    @JoinColumn(name = "maSP", referencedColumnName = "maSP")
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "maLSP", referencedColumnName = "maLSP")
    private LoaiSanPham loaiSanPham;

    @ManyToOne
    @JoinColumn(name = "maMTT", referencedColumnName = "maMTT")
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
