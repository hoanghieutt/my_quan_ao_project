package com.example.duancore.controller.BanHang;

import com.example.duancore.entity.*;
import com.example.duancore.repository.ChiTietSanPhamRepository;
import com.example.duancore.service.Impl.*;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/gioHang")
public class GioHangChiTietController {

    @Autowired
    ServletContext context;

    @Autowired
    private KhachHangService khachHangService;

    @Autowired
    private GioHangChiTietService gioHangChiTietService;

    @Autowired
    private GioHangService gioHangService;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private HoaDonService hoaDonService;


    @GetMapping("gioHangView")
    public String viewGioHang(Model model){

        List<ChiTietGioHang> list = gioHangChiTietService.findAll();
        BigDecimal tongTien = gioHangChiTietService.getTotal(list);
        model.addAttribute("tongTien", tongTien);
        model.addAttribute("ghct", list);

        return "BanHang/viewListGioHangChiTiet";

    }

    @PostMapping("/addToCart/{mactsp}")
    public String addToCart(Model model,
                             HttpSession session,
                             @PathVariable(value = "mactsp") String mactsp,
                             //@RequestParam  ("maKH") String maKH,//lấy mã khách hàng
                             @RequestParam ("soLuong") Integer soLuong,
                             RedirectAttributes redirectAttributes //lưu lại mã khách hàng

    ){


        String maNV = (String) session.getAttribute("maNV");

        if (maNV != null) {
            // Đã đăng nhập và lưu mã nhân viên vào session

            // Tìm đối tượng User tương ứng với mã nhân viên
            User user = userService.findByMaNV(maNV);

            if (user != null) {

                String maNhanVienTrongUser = user.getMaNV(); // Trích xuất mã nhân viên từ đối tượng User

                //how to code findByMaNV
                GioHang gioHang = gioHangService.findByMaNV(maNhanVienTrongUser);

                if (gioHang == null) {
                    gioHang = new GioHang();
                    gioHang.setMaGH(insertMaGH(maNhanVienTrongUser)); // Tạo mã giỏ hàng tự động

                    // Gán mã nhân viên từ đối tượng User vào giỏ hàng
                    gioHang.setMaNV(user);

                    gioHangService.addGioHang(gioHang); // Lưu giỏ hàng vào cơ sở dữ liệu
                }

                ChiTietSanPham chiTietSanPham = chiTietSanPhamRepository.findById(mactsp).orElse(null);

                if(chiTietSanPham != null){

                     ChiTietGioHang ctgh = gioHangChiTietService.findByMaGHAndMaCTSP(gioHang,chiTietSanPham);

                     if(ctgh != null){

                          ctgh.setSoLuong(ctgh.getSoLuong() + soLuong);
                          gioHangChiTietService.themSPVaoGioHang(ctgh);

                     }else{

                           ctgh = new ChiTietGioHang();
                           ctgh.setMaGH(gioHang);
                           ctgh.setMactsp(chiTietSanPham);
                           ctgh.setSoLuong(soLuong);
                           ctgh.setDonGia(chiTietSanPham.getGiaban().multiply(BigDecimal.valueOf(soLuong)));

                           gioHangChiTietService.themSPVaoGioHang(ctgh);

                     }
                }
            }
        }

        return "redirect:/gioHang/gioHangView";

    }


    //Todo code mã giỏ hàng tự động

       private String insertMaGH(String maNV){

          String random = UUID.randomUUID().toString().substring(0,8);

         return maNV + "_" + random;

    }


    //Todo code thanh toán đặt hàng
    @GetMapping("/checkout")
    public String thongTinKH(Model model,
                             HttpSession session){

        List<ChiTietGioHang> list = gioHangChiTietService.findAll();
        List<KhachHang> listKhachHang = khachHangService.findAll();
        List<HoaDon> listHoaDon = hoaDonService.findAll();
        BigDecimal tong = gioHangChiTietService.getTotal(list);

        model.addAttribute("tong",tong);
        model.addAttribute("listKhachHang", listKhachHang);
        model.addAttribute("listHoaDon",listHoaDon);
        model.addAttribute("listGHCT",list);

        return "BanHang/muaHang";

    }


    //Todo code delete giỏ hàng chi tiết
    @GetMapping("delete/{maGHCT}")
    public String delete(Model model,
                         @PathVariable("maGHCT") String maGHCT){

        gioHangChiTietService.delete(maGHCT);
        model.addAttribute("view", "Xóa giỏ hàng chi tiết thành công!");


        return "redirect:/gioHang/gioHangView";

    }

    //Todo code update số lượng tại giỏ hàng chi tiết
    @RequestMapping("/updateSoLuong/{maGHCT}")
    public String updateSoLuong(Model model,
                                @PathVariable("maGHCT") String maGHCT,
                                @RequestParam("actions") String actions,
                                @RequestParam("soLuong") Integer soLuong
                                ){

        ChiTietGioHang gioHangChiTiet = gioHangChiTietService.findById(maGHCT);

        if (gioHangChiTiet != null) {
            if ("tang".equals(actions)) {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
            } else if ("giam".equals(actions)) {
                gioHangChiTiet.setSoLuong(Math.max(gioHangChiTiet.getSoLuong() - 1, 1));
            }

            BigDecimal donGia = gioHangChiTiet.getMactsp().getGiaban().multiply(BigDecimal.valueOf(gioHangChiTiet.getSoLuong()));
            gioHangChiTiet.setDonGia(donGia);
            gioHangChiTietService.themSPVaoGioHang(gioHangChiTiet);

        }

        return "redirect:/gioHang/gioHangView";

    }


}
