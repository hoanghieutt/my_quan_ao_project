package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name="hoadon")
public class HoaDon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long mahoadon;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngaylap = new Date();

    @NotBlank(message = "Người lập không thể để trống")
    String nguoilap;

    @NotBlank(message = "Ghi chú không thể để trống")
    String ghichu;

    Integer trangthai;

    @ManyToOne @JoinColumn(name="nguoimua")
    KhachHang nguoimua;

    @OneToOne(mappedBy = "hoadongiao")
    PhieuGiaoHang phieugiaohang;
}
