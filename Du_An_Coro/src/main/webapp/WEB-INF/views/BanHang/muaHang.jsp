<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="frm"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%-- <link rel="icon" href="img/background_title.jpg" type="image/x-icon">--%>
    <title>Teams Store</title>
    <!-- Custom fonts for this template-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM"
          crossorigin="anonymous">
    <!-- Custom styles for this template-->
    <link href="/css/css.css" rel="stylesheet">
    <link href="/css/css1.css" rel="stylesheet">
    <%-- Link css by index--%>
    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/productList.css" rel="stylesheet">
    <style>
        .scrollable-list {
            width: 300px;
            max-height: 200px;
            /* Đặt chiều cao tối đa cho danh sách */
            overflow-y: scroll;
            /* Cho phép trượt dọc */
            border: 1px solid #ccc;
            padding: 10px;
        }

        /* Định dạng cho các mục danh sách */
        .list-item {
            padding: 5px;
            border-bottom: 1px solid #eee;
        }
    </style>

</head>

<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="/home">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">Teams Store <sup>2</sup></div>
        </a>
        <!-- Divider -->
        <hr class="sidebar-divider">
        <!-- How to code  Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePages"
               aria-expanded="true" aria-controls="collapsePages">
                <i class="fas fa-fw fa-folder"></i>
                <span>Pages</span>

            </a>
            <div id="collapsePages" class="collapse" aria-labelledby="headingPages"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header" style="color: black; font-size: 13px;">Pages</h6>
                    <a class="collapse-item" href="/sanPham/list">Sản phẩm</a>
                    <a class="collapse-item" href="/hoaDonCT/list">Hóa đơn chi tiết</a>
                    <a class="collapse-item" href="/hoaDon/list">Hóa đơn</a>
                    <a class="collapse-item" href="/hinh-thuc-thanh-toan/hien-thi">Hình thức thanh
                        toán</a>
                    <a class="collapse-item" href="/khach-hang/hien-thi">Khách hàng</a>
                    <a class="collapse-item" href="/KM/index">Khuyến mại</a>
                    <a class="collapse-item" href="">Chi tiết sản phẩm</a>

                    <div class="collapse-divider"></div>
                    <h6 class="collapse-header">Other pages:</h6>
                    <a class="collapse-item" href="">Màu sắc</a>
                    <a class="collapse-item" href="/Size/list">Size</a>
                    <a class="collapse-item" href="/mon_the_thao/index">Môn thể thao</a>
                    <a class="collapse-item" href="/chat-lieu/hien-thi">Chất liệu</a>
                    <a class="collapse-item" href="/loai-san-pham/add">Loại sản phẩm</a>


                </div>
            </div>

        </li>
        <!-- Nav Item - User Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link collapsed" href="#" data-toggle="collapse"
               data-target="#collapseUtilities" aria-expanded="true" aria-controls="collapseUtilities">
                <i class="fas fa-fw fa-wrench"></i>
                <span>User</span>
            </a>
            <div id="collapseUtilities" class="collapse" aria-labelledby="headingUtilities"
                 data-parent="#accordionSidebar">
                <div class="bg-white py-2 collapse-inner rounded">
                    <h6 class="collapse-header">User:</h6>
                    <a class="collapse-item" href="/#">Nhân viên</a>
                    <a class="collapse-item" href="/chuc-vu/hien-thi">Chức vụ</a>



                    <%-- <a class="collapse-item" href="/authentication/enregistrer">Register</a>--%>
                    <div class="collapse-divider"></div>
                    <h6 class="collapse-header">Other User:</h6>
                    <a class="collapse-item" href="/404">Login</a>
                </div>
            </div>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/403">
                <i class="fas fa-fw fa-chart-area"></i>
                <span>Charts</span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="/403">
                <i class="fas fa-fw fa-table"></i>
                <span>Tables</span></a>
        </li>
    </ul>
    <!-- The end code nav -->
    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small"
                               placeholder="Search for..." aria-label="Search"
                               aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>

                    </div>

                </form>

                <div class="hello">
                    <a style="color: red">Hello: ${userLog.tenUser} ( ${userLog.role} )</a>
                </div>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">
                    <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <!-- Nav Item - Alerts -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-bell fa-fw"></i>
                            <!-- Counter - Alerts -->
                            <span class="badge badge-danger badge-counter">3+</span>
                        </a>
                        <!-- Dropdown - Alerts -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="alertsDropdown">
                            <h6 class="dropdown-header">
                                Alerts Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-primary">
                                        <i class="fas fa-file-alt text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 12, 2019</div>
                                    <span class="font-weight-bold">A new monthly report is ready to
                                                        download!</span>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-success">
                                        <i class="fas fa-donate text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 7, 2019</div>
                                    $290.29 has been deposited into your account!
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="mr-3">
                                    <div class="icon-circle bg-warning">
                                        <i class="fas fa-exclamation-triangle text-white"></i>
                                    </div>
                                </div>
                                <div>
                                    <div class="small text-gray-500">December 2, 2019</div>
                                    Spending Alert: We've noticed unusually high spending for your
                                    account.
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Show All
                                Alerts</a>
                        </div>
                    </li>

                    <!-- Nav Item - Messages -->
                    <li class="nav-item dropdown no-arrow mx-1">
                        <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-envelope fa-fw"></i>
                            <!-- Counter - Messages -->
                            <span class="badge badge-danger badge-counter">7</span>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="messagesDropdown">
                            <h6 class="dropdown-header">
                                Message Center
                            </h6>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="img/undraw_profile_1.svg"
                                         alt="...">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div class="font-weight-bold">
                                    <div class="text-truncate">Hi there! I am wondering if you can help
                                        me with a
                                        problem I've been having.
                                    </div>
                                    <div class="small text-gray-500">Emily Fowler · 58m</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="img/undraw_profile_2.svg"
                                         alt="...">
                                    <div class="status-indicator"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">I have the photos that you ordered last
                                        month, how
                                        would you like them sent to you?
                                    </div>
                                    <div class="small text-gray-500">Jae Chun · 1d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle" src="img/undraw_profile_3.svg"
                                         alt="...">
                                    <div class="status-indicator bg-warning"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Last month's report looks great, I am
                                        very happy with
                                        the progress so far, keep up the good work!
                                    </div>
                                    <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                                </div>
                            </a>
                            <a class="dropdown-item d-flex align-items-center" href="#">
                                <div class="dropdown-list-image mr-3">
                                    <img class="rounded-circle"
                                         src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="...">
                                    <div class="status-indicator bg-success"></div>
                                </div>
                                <div>
                                    <div class="text-truncate">Am I a good boy? The reason I ask is
                                        because someone
                                        told me that people say this to all dogs, even if they aren't
                                        good...
                                    </div>
                                    <div class="small text-gray-500">Chicken the Dog · 2w</div>
                                </div>
                            </a>
                            <a class="dropdown-item text-center small text-gray-500" href="#">Read More
                                Messages</a>
                        </div>
                    </li>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">Douglas
                                                McGee</span>
                            <img class="img-profile rounded-circle" src="/img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/logout">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>

                        </div>
                    </li>

                </ul>
            </nav>
            <!-- How to code article   -->

            <div class="view">
                <div class="row">
                    <div class="col-6" style="left: 60px">
                        <div class="form_khachHang">
                            <!-- <div class="col-12"> -->
                            <frm:form action="/thanhToan/thanhCong" method="post">
                                <h3 style="color: black; text-align: center ">Thông tin khách hàng
                                    mua hàng</h3>

                                <div class="col-md-12" style="margin-top: 10px">
                                    <label style="margin-top: 10px">Mã hóa đơn</label>
                                    <input class="form-control" type="text" id="maHD" name="maHD" value="${maHD}">

                                </div>

                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Mã khách hàng</label>
                                    <input type="text" type="hidden" class="form-control" name="maKH" value="${selectedKhachHang.maKH}"
                                           disabled>
                                </div>

                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Họ tên</label>
                                    <input type="text" class="form-control" name="tenKhachHang" value="${selectedKhachHang.tenKH}"
                                           disabled>
                                </div>

                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Địa chỉ</label>
                                    <input type="text" class="form-control" name="diaChiNhanHang"
                                           value="${selectedKhachHang.diaChi}">
                                </div>

                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Số điện thoại</label>
                                    <input type="text" class="form-control" name="soDienThoai"
                                           value="${selectedKhachHang.soDienThoai}">
                                </div>

                                <!-- Thêm mới -->

                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Tên người nhận</label>
                                    <input type="text" class="form-control" name="tenNguoiNhan"
                                           value="${selectedKhachHang.tenKH}">
                                </div>
                                <h3 style="text-align: center; margin-top: 20px; color: black">Thông tin thanh toán</h3>
                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Số tiền cần thanh toán</label>
                                    <input type="text" class="form-control" name=""
                                           value="${tong}  VND" disabled>
                                </div>
                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Số tiền khách hàng đưa</label>
                                    <input type="text" class="form-control" name="tenNguoiNhan"
                                           value="${tienKhachDua}" min="0">
                                </div>
                                <div class="col-md-12">
                                    <label style="margin-top: 10px">Số tiền cần phải trả</label>
                                    <input type="text" class="form-control" name="tenNguoiNhan"
                                           value="${tienTraLai}" min="${tienKhachDua}">
                                </div>

                                <button style="width: 25%; margin-top: 50px; margin-left: 40px"
                                        class="btn btn-primary btn-lg btn-block" type="submit"
                                        name="btnDatHang">Dat hang</button>
                            </frm:form>
                            <!-- </div> -->
                        </div>
                    </div>
                    <div class="col-6" style="left: 60px">
                        <div class="list_duLieu">
                            <div class="sanPhamChiTiet">
                                <div class="col-12">
                                    <h3 style="text-align: center; color: black">Thông tin sản phẩm
                                        khách hàng mua</h3>
                                    <div class="scrollable-list" style="width: 500px">
                                        <table class="data-table" style="width: 100%;">
                                            <thead>
                                            <tr>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">STT
                                                </th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">Tên sản
                                                    phẩm</th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">Số lượng
                                                </th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">Đơn giá
                                                    </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="sp" items="${listGHCT}" varStatus="i">
                                                <tr>
                                                    <td style="text-align: center">${i.index+1}</td>
                                                    <td style="text-align: center">
                                                            ${sp.mactsp.sanpham.tensp}</td>
                                                    <td style="text-align: center">${sp.soLuong}
                                                    </td>
                                                    <td style="text-align: center">
                                                            ${sp.mactsp.giaban * sp.soLuong}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div>
                                        <h5 style="color: black; margin-left: 290px; margin-top: 30px">
                                            Tổng tiền: ${tong} VND</h5>
                                    </div>
                                </div>
                            </div>
                            <div class="hoaDon">
                                <div class="col-12">
                                    <h3 style="color: black; text-align: center; margin-top: 40px">
                                        Thông tin hóa đơn chưa thanh toán</h3>
                                    <div class="scrollable-list" style="width: 500px">
                                        <table class="data-table" style="width: 100%;">
                                            <thead>
                                            <tr>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">STT
                                                </th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">Mã
                                                    hóa đơn</th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">
                                                    Trạng thái</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="hd" items="${listHoaDon}" varStatus="i">
                                                <tr>
                                                    <td style="text-align: center">${i.index+1}
                                                    </td>
                                                    <td style="text-align: center">${hd.maHD}
                                                    </td>
                                                    <td style="text-align: center">
                                                            ${hd.trangThai==1 ? "Đã thanh toán"
                                                                    : "Chưa thanh toán"}</td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                            <div class="khacHang">
                                <div class="col-12">
                                    <h3 style="color: black; text-align: center; margin-top: 40px">
                                        Thông tin các khách hàng</h3>
                                    <div class="scrollable-list" style="width: 500px">
                                        <table class="data-table" style="width: 100%;">
                                            <thead>
                                            <tr>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">STT
                                                </th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">Mã
                                                    khách hàng</th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">Tên
                                                    khách hàng</th>
                                                <th class="table-header"
                                                    style="text-align: center; color: black">
                                                    Funtions
                                                </th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach var="kh" items="${listKhachHang}"
                                                       varStatus="i">
                                                <tr>
                                                    <td style="text-align: center">${i.index+1}
                                                    </td>
                                                    <td style="text-align: center">${kh.maKH}
                                                    </td>
                                                    <td style="text-align: center">${kh.tenKH}
                                                    </td>
                                                        <td style="text-align: center">
                                                            <form action="/thanhToan/chonKhachHang" method="post">
                                                                <input type="hidden" name="selectedMaKH" value="${kh.maKH}">
                                                                <button type="submit">Chọn</button>
                                                            </form>
                                                        </td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>























            <!-- Footer -->
            <footer style="margin-top: 50px" class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
        </div>
    </div>
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>


    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-titl se" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current
                    session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="/logout">Logout</a>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script src="/vendor/jquery/jquery.min.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/vendor/jquery-easing/jquery.easing.min.js"></script>
<script src="/js/sb-admin-2.min.js"></script>
<script src="/vendor/chart.js/Chart.min.js"></script>
<script src="/js/demo/chart-area-demo.js"></script>
<script src="/js/demo/chart-pie-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js"
        integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS"
        crossorigin="anonymous"></script>
</body>

</html>