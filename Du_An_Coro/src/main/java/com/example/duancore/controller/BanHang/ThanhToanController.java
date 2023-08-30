package com.example.duancore.controller.BanHang;

import com.example.duancore.entity.*;
import com.example.duancore.service.Impl.*;
import com.oracle.wls.shaded.org.apache.xpath.operations.Mod;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/thanhToan")
public class ThanhToanController {

     @Autowired
     ServletContext context;

     @Autowired
     private KhachHang selectedKhachHang;

     @Autowired
     private KhachHangService khachHangService;

     @Autowired
     private GioHangService gioHangService;

     @Autowired
     private GioHangChiTietService gioHangChiTietService;

     @Autowired
     private HoaDonService hoaDonService;

    @Autowired
    private HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    private ChiTietSanPhamService chiTietSanPhamService;


    @ModelAttribute("selectedKhachHang")
    public KhachHang getSelectedKhachHang() {
        return selectedKhachHang;
    }

    @PostMapping("chonKhachHang")
    public String chonKhachHang(Model model,
                                HttpSession session,
                                @RequestParam("selectedMaKH") String selectedMaKH){

        selectedKhachHang = khachHangService.findByMaKH(selectedMaKH);
        List<ChiTietGioHang> chiTietGioHangList = gioHangChiTietService.findAll();
        BigDecimal tong = gioHangChiTietService.getTotal(chiTietGioHangList);


        session.setAttribute("maKH",selectedMaKH);
        session.setAttribute("tong",tong);

        return "redirect:/thanhToan/datHang?maKH="+ selectedMaKH;

    }



    @GetMapping("listHoaDonThanhToan")
    public String listHoaDon(){

        return "BanHang/datHangThanhCong";

    }



        @GetMapping("/datHang")
        public String datHang(
                Model model
        ) {
            model.addAttribute("selectedMaKH", selectedKhachHang.getMaKH());
            model.addAttribute("selectedTenKH", selectedKhachHang.getTenKH());
            model.addAttribute("selectedDiaChi", selectedKhachHang.getDiaChi());
            model.addAttribute("selectedSoDienThoai", selectedKhachHang.getSoDienThoai());

            List<ChiTietGioHang> list = gioHangChiTietService.findAll();
            List<KhachHang> listKhachHang = khachHangService.findAll();
            List<HoaDon> listHoaDon = hoaDonService.findAll();

            model.addAttribute("listKhachHang", listKhachHang);
            model.addAttribute("listHoaDon",listHoaDon);
            model.addAttribute("listGHCT",list);



            // Thêm bất kỳ dữ liệu khác bạn muốn đổ vào model

            return "BanHang/muaHang"; //
        }




    //Todo code đặt hàng thành công là hóa đơn chi tiết
    @PostMapping("thanhCong")
    public String taoHoaDon(Model model,
                            HttpSession session,//Lưu giá trị
                            RedirectAttributes attributes,//Chuyển hướng giá trị đã có sẵn
                            @Valid
                            @ModelAttribute("maHD") String maHD,
                            @RequestParam("tenNguoiNhan") String tenNguoiNhan,
                            @RequestParam("diaChiNhanHang") String diaChiNhanHang,
                            @RequestParam("soDienThoai") String soDienThoai,
                            BindingResult result
//                            SessionAttribute sessionAttribute

    ){
        /*
             Nhâp mã hóa đơn đã có sẵn ở hóa đơn
             Sau đó lưu và Hóa đơn chi tiết

         */


        HoaDon hoaDon = hoaDonService.getHoaDonByMaHD(maHD);

        Boolean check = true;

        if(hoaDon == null){

            System.out.println("Mã hóa đơn đang là null");
            model.addAttribute("mess", "Null");


        }else {


            System.out.println("Mã hóa đơn không là null");
            model.addAttribute("mess1", "No null");
            //Đã có mã hóa đơn
            //Giờ đến lượt tim mã khách hàng
            String maKH = (String) session.getAttribute("maKH");
            KhachHang khachHang = khachHangService.findByMaKH(maKH);
            hoaDon.setMaKH(khachHang);
            hoaDon.setTenNguoiNhan(tenNguoiNhan);
            hoaDon.setDiaChiNhanHang(diaChiNhanHang);
            hoaDon.setSoDienThoai(soDienThoai);

            //check nhập sô tiền

            //hoaDon.setTienKhachDua();



            //Lưu lại thông tin khách hàng vào hóa đơn
            hoaDonService.saveHoaDon(hoaDon);

            List<ChiTietGioHang> chiTietGioHangList = gioHangChiTietService.findAll();

            BigDecimal tong = gioHangChiTietService.getTotal(chiTietGioHangList);

                        for(ChiTietGioHang chiTietGioHang : chiTietGioHangList){

                            ChiTietSanPham chiTietSanPham = chiTietGioHang.getMactsp();

                            int soLuongMua      = chiTietGioHang.getSoLuong();
                            int soLuongHienCo   = chiTietSanPham.getSoLuong();

                            chiTietSanPham.setSoLuong(soLuongHienCo-soLuongMua);
                            chiTietSanPhamService.add(chiTietSanPham);

                            HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                            //Tạo mã hóa đơn chi tiết tự động
                            String maHDCT = insertMaHDCT(maKH);
                            hoaDonChiTiet.setMaHDCT(maHDCT);

                            hoaDonChiTiet.setMaHD(hoaDon);
                            hoaDonChiTiet.setMactsp(chiTietSanPham);
                            hoaDonChiTiet.setSoLuong(soLuongMua);
                            hoaDonChiTiet.setDonGia(chiTietSanPham.getGiaban().multiply(BigDecimal.valueOf(soLuongMua)));
                            hoaDon.setTrangThai(1);
                            hoaDonChiTietService.save(hoaDonChiTiet);

                            model.addAttribute("hoaDon", hoaDon);
                            model.addAttribute("khachHang", khachHang);
                            model.addAttribute("hoaDonCT",hoaDonChiTiet);
                            model.addAttribute("mess","Đặt hàng thành công !");
                            model.addAttribute("tong",tong);
//                            session.a("tong",tong);

                        }


                        gioHangChiTietService.deleteGHCT();


        }

        return "BanHang/datHangThanhCong";

    }


    //Todo code maHoaDonChiTiet tự sinh
    private String insertMaHDCT(String maKH){

        String random = UUID.randomUUID().toString().substring(0,8);

        return maKH + "_" + random;

    }


}
