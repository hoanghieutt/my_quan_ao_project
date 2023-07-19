package com.example.duancore.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Entity
@Table(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Users {
    @Id
    @NotBlank(message = "Vui lòng nhập mã user")
    @Column(name = "maNV")
    private String maNV;

    @ManyToOne
    @JoinColumn(name = "maCV")
    private ChucVu maCV;

    @NotBlank(message = "Vui lòng nhập tên user")
    @Column(name = "tenNV")
    private String tenNV;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "soDienThoai")
    private Integer soDienThoai;

    @Column(name = "ngaySinh")
    private Date ngaySinh;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private Integer trangThai;

    @Column(name = "role")
    private String role;



}
