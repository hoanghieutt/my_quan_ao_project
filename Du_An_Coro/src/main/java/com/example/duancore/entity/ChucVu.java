package com.example.duancore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "ChucVu")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class ChucVu {
    @Id
    @Column(name = "maCV")
    private String maCV;

    @Column(name = "tenCV")
    private String tenCV;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private String trangThai;
}
