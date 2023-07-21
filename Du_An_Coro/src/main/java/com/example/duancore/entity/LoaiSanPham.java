package com.example.duancore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "LoaiSanPham")
public class LoaiSanPham {

    @Id
    private String maLSP;

    private String ten;
    private String ngayTao;
    private String ngaySua;
    private int trangThai;


}
