package com.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="Diachi")
public class DiaChi {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    UUID madiachi;
    String tendiachi;
    String motachitiet;
    String tinhthanhpho;
    String quanhuyen;
    String phuongxa;
    String duongpho;
}
