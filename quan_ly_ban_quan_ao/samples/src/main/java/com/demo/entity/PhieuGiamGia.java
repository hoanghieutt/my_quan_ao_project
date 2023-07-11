package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="phieugiamgia")
public class PhieuGiamGia {
    @Id 
    String maphieu;

    @NotBlank(message = "Tên phiếu không được trống")
    String tenphieu;

    @NotNull(message = "Ngày bắt đầu không được trống")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngaybatdau;

    @NotNull(message = "Ngày kết thúc không được trống")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    Date ngayketthuc;

    @NotNull(message = "Giá trị giảm không được trống")
    Double giatrigiam;

    @NotNull(message = "Giá trị giảm tối đa không được trống")
    Double giatrigiamtoida;

    Boolean hinhthucgiam;

    Integer trangthai;

    @Valid
    @ManyToOne @JoinColumn(name="nguoisohuu")
    KhachHang nguoisohuu;
}
