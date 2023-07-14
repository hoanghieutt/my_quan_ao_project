package com.example.assigment_shoes.entity;

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
@Table(name = "monthethao")
public class MonTheThao implements Serializable {

    @Id
    private String mamtt;

    private String ten;

    private String ngaytao;
    private String ngaysua;
    private int trangthai;
}
