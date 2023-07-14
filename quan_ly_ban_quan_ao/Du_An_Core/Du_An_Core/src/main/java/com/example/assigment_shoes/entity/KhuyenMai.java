package com.example.assigment_shoes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "khuyenmai")
public class KhuyenMai {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer makm;
    String tenkm;

    String ngaybatdau;
    String ngayketthuc;

    Double giamgia;

    String ngaytao;
    String ngaysua;
    Integer trangthai;
}
