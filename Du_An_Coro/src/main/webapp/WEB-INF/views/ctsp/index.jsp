<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<h1 style="text-align: center;">Quản lý Chi Tiết Sản Phẩm</h1>
<br>
<%--<form action="${pageContext.request.contextPath}/khach-hang/search" method="post">--%>
<%--    <input type="text" placeholder="Nhập từ khóa cần tìm kiếm" name="keyword" value="${keyword}">--%>
<%--    <input type="date" name="min" value="${minDate}">--%>
<%--    <input type="date" name="max" value="${maxDate}">--%>
<%--    <button class="btn btn-primary">Tìm kiếm</button>--%>
<%--</form>--%>

<br>
<a class="btn btn-warning" href="/chi-tiet-san-pham/create">Thêm mới</a>
<br>

<table class="table">
    <thead>
    <tr>
        <th scope="col">Mã Chi tiết</th>
        <th scope="col">Kích cỡ</th>
        <th scope="col">Màu sắc</th>
        <th scope="col">Chất liệu</th>
        <th scope="col">Sản phẩm</th>
        <th scope="col">Loại sản phẩm</th>
        <th scope="col">Môn thể thao</th>
        <th scope="col">Số lượng</th>
        <th scope="col">Giá</th>
        <th scope="col">Ngày tạo</th>
        <th scope="col">Ngày sửa</th>
        <th scope="col">Trạng thái</th>
        <th scope="col">Action</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach items="${data}" var="chiTietSP">
        <tr>
            <td>${chiTietSP.maCTSP}</td>
            <td>${chiTietSP.size.maSize}</td>
            <td>${chiTietSP.mauSac.maMS}</td>
            <td>${chiTietSP.chatLieu.maCL}</td>
            <td>${chiTietSP.sanPham.masp}</td>
            <td>${chiTietSP.loaiSanPham.maLSP}</td>
            <td>${chiTietSP.monTheThao.mamtt}</td>
            <td>${chiTietSP.soLuong}</td>
            <td>${chiTietSP.gia}</td>
            <td>${chiTietSP.ngayTao}</td>
            <td>${chiTietSP.ngaySua}</td>
            <td>${chiTietSP.trangThai == 1 ? 'Còn hoạt động' : 'Không hoạt động'}</td>
            <td>
                <a class="btn btn-warning" href="/chi-tiet-san-pham/edit/${chiTietSP.maCTSP}">Sửa</a>
                <a class="btn btn-danger" href="/chi-tiet-san-pham/delete/${chiTietSP.maCTSP}">Xóa</a>
                <input type="submit" value="Add to Cart">
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<%@ include file="../layout/footer.jsp" %>
</html>