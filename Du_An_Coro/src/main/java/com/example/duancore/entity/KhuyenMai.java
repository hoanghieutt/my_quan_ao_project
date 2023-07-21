package com.example.duancore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "khuyenmai")
public class KhuyenMai {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer makm;

    @NotBlank(message = "Yêu cầu nhập tên")
    String tenkm;

    @NotNull(message = "Yêu cầu nhập ngày bắt đầu")
    Date ngaybatdau = null;

    @NotNull(message = "Yêu cầu nhập ngày kết thúc")
    Date ngayketthuc = null;

    @NotNull(message = "Yêu cầu nhập giá")
    @Min(value = 0, message = "Giá trị giảm phải là một số dương")
    Double giamgia;

    String ngaytao;
    String ngaysua;
    Integer trangthai;
}
