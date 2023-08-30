package com.example.duancore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.Enabled;
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
@Table(name = "HoaDon")

public class HoaDon {

    @Id
//    @NotBlank(message = "Không được để trống mã hóa đơn")
    @Column(name = "maHD")
    private String maHD;

    @ManyToOne
    @JoinColumn(name = "maKH")
    private KhachHang maKH;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private User maNV;

    @ManyToOne
    @JoinColumn(name = "maHTTT")
    private HinhThucThanhToan maHTTT;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "tenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "diaChiNhanHang")
    private String diaChiNhanHang;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "thanhTien")
    private BigDecimal thanhTien;

    @Column(name = "tienKhachDua")
    private BigDecimal tienKhachDua;

    @Column(name = "tienTraLai")
    private BigDecimal tienTraLai;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;


    //Join bảng hóa đơn chi tiết
    @OneToMany(mappedBy = "maHD", fetch = FetchType.LAZY)
    List<HoaDonChiTiet> hoaDonChiTietList;


}
