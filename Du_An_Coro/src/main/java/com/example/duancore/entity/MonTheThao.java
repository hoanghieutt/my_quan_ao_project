package com.example.duancore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
