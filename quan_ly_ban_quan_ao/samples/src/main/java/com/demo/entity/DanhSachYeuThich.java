package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="danhsachyeuthich")
public class DanhSachYeuThich {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID madanhsach;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    Date ngaytao;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    Date ngaycapnhat;

    @ManyToOne @JoinColumn(name="nguoisohuu")
    KhachHang nguoisohuu;

    String ghichu;

    Integer trangthai;
}
