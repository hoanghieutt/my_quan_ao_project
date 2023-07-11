package com.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name="Thethanhvien")
public class TheThanhVien {
    @Id String mathe;
    String mauthe;
    String loaithe;

    @Temporal(TemporalType.DATE)
    Date ngayphathanh;

    @Temporal(TemporalType.DATE)
    Date ngayhuy;

    Integer trangthai;

    @JsonIgnore
    @OneToOne @JoinColumn(name="nguoisohuu")
    KhachHang nguoisohuu;

    public String toString(){
        return mathe;
    }
}
