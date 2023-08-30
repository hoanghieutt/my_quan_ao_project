package com.example.duancore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {

    @Id
    @NotBlank(message = "Vui lòng nhập mã chi tiết sản phẩm")
    @Column(name = "maCTSP")
    private String mactsp;

    @ManyToOne
    @JoinColumn(name = "maMS")
    private MauSac mausac;

    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPham sanpham;

    @ManyToOne
    @JoinColumn(name = "maSize")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "maCL")
    private ChatLieu chatlieu;

    @ManyToOne
    @JoinColumn(name = "maMTT")
    private MonTheThao monthethao;

    @ManyToOne
    @JoinColumn(name = "maLSP")
    private LoaiSanPham loaisanpham;

    @NotNull(message = "Không được để trống dữ liệu !")
    @Column(name = "soLuong")
    private int soLuong;

    @Column(name = "giaNhap")
    private BigDecimal gianhap;

    @Column(name = "giaBan")
    private BigDecimal giaban;

    @Column(name = "ngayTao")
    private String ngaytao;

    @Column(name = "ngaySua")
    private String ngaysua;

    @Column(name = "Image")
    private String image;

    @Column(name = "trangThai")
    private int trangthai;

   //how to join table


    @OneToMany(mappedBy = "mactsp",fetch = FetchType.LAZY)
    List<ChiTietGioHang> chiTietGioHangList;

    @OneToMany(mappedBy = "mactsp", fetch = FetchType.LAZY)
    List<HoaDonChiTiet> hoaDonChiTietList;





}
