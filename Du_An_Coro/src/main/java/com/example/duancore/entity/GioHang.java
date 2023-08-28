package com.example.duancore.entity;


import jakarta.persistence.*;
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
@Table(name ="GioHang")
public class GioHang {

       @Id
       @Column(name = "maGH")
       private String maGH;

       @ManyToOne
       @JoinColumn(name = "maKH")
       private KhachHang maKH;

       @ManyToOne
       @JoinColumn(name = "maNV")
       private User maNV;

       @Column(name = "ghiChu")
       private String ghiChu;

       @Column(name = "thanhTien")
       private BigDecimal thanhTien;

       @Column(name = "ngayTao")
       private String ngayTao;

       @Column(name = "ngayThanhToan")
       private String ngayThanhToan;

       @Column(name = "tenNguoiNhan")
       private String tenNguoiNhan;

       @Column(name = "diaChi")
       private String diaChi;

       @Column(name = "soDienThoai")
       private String soDienThoai;

       @Column(name = "trangThai")
       private int trangThai;

       //Join vào bảng giỏ hàng chi tiết

       @OneToMany(mappedBy = "maGH" , fetch = FetchType.LAZY)
       List<ChiTietGioHang> chiTietGioHangList;





}
