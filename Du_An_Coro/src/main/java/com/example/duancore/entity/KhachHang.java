package com.example.duancore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Date;

@Entity
@Table(name = "KhachHang")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KhachHang {
    @Id
    @NotEmpty(message = "Không được để trống")
    @Column(name = "maKH")
    private String maKH;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "tenKH")
    private String tenKH;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "gioiTinh")
    private String gioiTinh;

    @NotNull(message = "Không được để trống")
    @Column(name = "soDienThoai")
    private Integer soDienThoai;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private Integer trangThai;
}

