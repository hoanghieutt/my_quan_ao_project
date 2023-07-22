package com.example.duancore.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Size")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Size {

     @Id
     @Column(name = "maSize")
     private String maSize;

     private String size;
     private String soLuong;
     private Date ngayTao;
     private Date ngaySua;
     private int trangThai;


}
