package com.example.duancore.entity;

import com.example.duancore.entity.Enum.RoleEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Users")
public class User {

    @Id
    @Column(name = "maNV")
    private String maNV;

    @Column(name = "tenNV")
    private String tenUser;

    @Column(name = "diaChi")
    private String diaChi;

    @Column(name = "gioiTinh")
    private String gioiTinh;

    @NotBlank(message = "Không được để trống email")
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "soDienThoai")
    private String soDienThoai;

    @Column(name = "ngaySinh")
    private String ngaySinh;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    //Join bảng hóa đơn vơi bảng giỏ hàng

    @OneToMany(mappedBy = "maNV", fetch = FetchType.LAZY)
    List<GioHang> gioHangList;

    @OneToMany(mappedBy = "maNV", fetch = FetchType.LAZY)
    List<HoaDon> hoaDonList;


}
