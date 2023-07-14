package com.example.assigment_shoes.entity;

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
@Table(name = "HinhThucThanhToan")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class HinhThucThanhToan {
    @Id
    @Column(name = "maHTTT")
    private String maHTTT;

    @Column(name = "tenHTTT")
    private String tenHTTT;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private String trangThai;

}
