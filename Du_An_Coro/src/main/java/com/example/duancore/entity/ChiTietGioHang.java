package com.example.duancore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "GioHangChiTiet")
public class ChiTietGioHang {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "maGHCT")
    private String maGHCT;

    @ManyToOne
    @JoinColumn(name = "maGH")
    public GioHang maGH;

    @ManyToOne
    @JoinColumn(name = "maCTSP")
    public ChiTietSanPham mactsp;

    @Column(name = "soLuong")
    private Integer soLuong;

    @Column(name = "donGia")
    private BigDecimal donGia;

    @Column(name = "donGiaKhiGiam")
    private BigDecimal donGiaKhiGiam;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

}
