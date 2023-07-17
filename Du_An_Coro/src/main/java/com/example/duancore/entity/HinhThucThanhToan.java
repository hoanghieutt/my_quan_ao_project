package com.example.duancore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "Không được để trống")
    @Column(name = "maHTTT")
    private String maHTTT;

    @NotEmpty(message = "Không được để trống")
    @Column(name = "tenHTTT")
    private String tenHTTT;

    @Column(name = "ngayTao")
    private Date ngayTao;

    @Column(name = "ngaySua")
    private Date ngaySua;

    @Column(name = "trangThai")
    private String trangThai;

}
