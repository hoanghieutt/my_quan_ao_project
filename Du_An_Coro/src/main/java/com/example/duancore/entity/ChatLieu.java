package com.example.duancore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ChatLieu")
public class ChatLieu implements Serializable {

    @Id
    private String maCL;

    private String ten;
    private String ngayTao;
    private String ngaySua;
    private int trangThai;


}