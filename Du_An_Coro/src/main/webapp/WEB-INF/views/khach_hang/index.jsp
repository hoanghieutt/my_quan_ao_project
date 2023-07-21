<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="icon" href="img/background_title.jpg" type="image/x-icon">--%>
    <title>List dữ liệu bảng sản phẩm</title>
    <!-- Custom fonts for this template-->
    <link href="/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <!-- Custom styles for this template-->
    <link href="/css/css.css" rel="stylesheet">
    <link href="/css/css1.css" rel="stylesheet">
    <%-- Link css by index--%>
    <link href="/css/index.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/productList.css" rel="stylesheet">

</head>

<%@ include file="../layout/header.jsp" %>

            <h1 style="text-align: center;">Quản lý Khách hàng</h1>
            <br>
            <form action="${pageContext.request.contextPath}/khach-hang/search" method="post">
                <input type="text" placeholder="Nhập từ khóa cần tìm kiếm" name="keyword" value="${keyword}">
                <input type="date" name="min" value="${minDate}">
                <input type="date" name="max" value="${maxDate}">
                <button class="btn btn-primary">Tìm kiếm</button>
            </form>

            <br>
            <a class="btn btn-warning" href="/khach-hang/create">Thêm mới</a>
            <br>
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Ngày sinh</th>
                    <th scope="col">Giới tính</th>
                    <th scope="col">Số điện thoại</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">Ngày tạo</th>
                    <th scope="col">Ngày sửa</th>
                    <th scope="col">Trạng thái</th>
                    <th scope="col">Action</th>
                </tr>
                </thead>

                <tbody>
                <c:forEach items="${data}" var="khachHang">
                    <tr>
                        <td>${khachHang.maKH}</td>
                        <td>${khachHang.tenKH}</td>
                        <td>${khachHang.ngaySinh}</td>
                        <td>${khachHang.gioiTinh}</td>
                        <td>${khachHang.soDienThoai}</td>
                        <td>${khachHang.diaChi}</td>
                        <td>${khachHang.ngayTao}</td>
                        <td>${khachHang.ngaySua}</td>
                        <td>${khachHang.trangThai == 1 ? 'Còn hoạt động' : 'Không hoạt động'}</td>
                        <td>
                            <a class="btn btn-warning" href="/khach-hang/edit/${khachHang.maKH}">Sửa</a>
                            <a class="btn btn-danger" href="/khach-hang/delete/${khachHang.maKH}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>


<%@ include file="../layout/footer.jsp" %>
</html>