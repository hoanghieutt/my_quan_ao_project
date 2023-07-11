package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="khachhang")
public class KhachHang {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long makhachhang;

    @NotBlank(message = "Tên khách hàng không được bỏ trống")
    String tenkhachhang;

    @NotNull(message = "Ngày sinh không được bỏ trống")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    Date sinhnhat;

    String diachi;
    String sodienthoai;
    String email;

    @NotNull(message = "Giới tính không được bỏ trống")
    Boolean gioitinh;

    String chungminhthu;
    String socancuoc;
    String anhdaidien;
    Integer trangthai;
    Integer diemtichluy;

    @ManyToOne @JoinColumn(name="hangkhachhang")
    HangKhachHang hangkhachhang;

    @OneToOne(mappedBy = "nguoisohuu")
    TheThanhVien thethanhvien;
}
