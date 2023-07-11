package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="hangkhachhang")
public class HangKhachHang {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer mahang;

    String tenhang;
    String mota;
    Integer diemtoithieu;
    Integer trangthai;
}
