package com.example.assigment_shoes.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "khuyenmai")
public class KhuyenMai implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer makm;// INT IDENTITY(1, 1) NOT NULL,
    String tenkm;// NVARCHAR(50) NOT NULL,
    String ngaybatdau;// DATE,
    String ngayketthuc;// DATE,
    Double giamgia;// money NOT NULL,
    String ngaytao;// date not null,
    String ngaysua;// date not null,
    Integer trangthai;// BIT DEFAULT 1 NOT NULL
}
