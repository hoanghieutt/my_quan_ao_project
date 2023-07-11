package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Table(name="phieugiaohang")
public class PhieuGiaoHang {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID maphieugiao;

    @NotBlank(message = "Người nhận không được trống")
    String nguoinhan;

    String sdtnhan;

    String nguoigiao;
    String sdtgiao;

    @NotNull(message ="Ngày giao không được trống")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngaygiao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngaynhan;

    String nguoitao;
    Double phigiaohang;
    String ghichu;
    Integer trangthai;

    @ManyToOne @JoinColumn(name="diachigiao")
    DiaChi diachigiao;

    @OneToOne @JoinColumn(name="hoadongiao")
    HoaDon hoadongiao;

    public String toString(){
        return maphieugiao != null? maphieugiao.toString() : "";
    }
}
