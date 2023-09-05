package com.example.duancore.controller;

import com.example.duancore.entity.ChiTietSanPham;
import com.example.duancore.entity.HoaDonChiTiet;
import com.example.duancore.repository.ChiTietSanPhamRepository;
import com.example.duancore.repository.HoaDonChiTietRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ThongKeController {
    @Autowired
    private HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @GetMapping("/thongkechuan")
    public String thongKeChuan(Model model) {
        //Tổng doanh thu
        BigDecimal tongDoanhThu = hoaDonChiTietRepository.tinhTongDoanhThu();
        model.addAttribute("tongDoanhThu", tongDoanhThu);

        //Tổng đơn hàng
        Integer tongDonHang = hoaDonChiTietRepository.tongDonHang();
        model.addAttribute("tongDonHang", tongDonHang);

        //Sản phẩm bán chạy
        String maSanPhamBanChayNhat = hoaDonChiTietRepository.timSanPhamBanChayNhat();
        model.addAttribute("maSanPhamBanChayNhat", maSanPhamBanChayNhat);

        //Số lượng sp đã bán
        Long soLuongDaBan = hoaDonChiTietRepository.tinhSoLuongDaBanCuaSanPham(maSanPhamBanChayNhat);
        model.addAttribute("soLuongDaBan", soLuongDaBan);

        //Tổng số lượng sp
        Integer totalQuantity = chiTietSanPhamRepository.sumSoLuong();
        model.addAttribute("totalQuantity", totalQuantity);


        // Thêm dữ liệu vào model
        model.addAttribute("tongDoanhThu", tongDoanhThu);


        return "thongke/thongkechuan"; // Trả về trang JSP để hiển thị kết quả
    }

    @GetMapping("/thongke-data")
    @ResponseBody
    public String thongKeData() {
        List<ChiTietSanPham> sanPhams = chiTietSanPhamRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonData = objectMapper.writeValueAsString(sanPhams);
            return jsonData;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @GetMapping("/thongke-data-hoadon")
    @ResponseBody
    public String thongKeDataHD() {
        List<HoaDonChiTiet> hdct = hoaDonChiTietRepository.findAll();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonData = objectMapper.writeValueAsString(hdct);
            return jsonData;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    @GetMapping("/thongke")
    public String thongKeSoLuongSanPham(Model model) {

        return "thongke/thongkeHD";
    }

}
