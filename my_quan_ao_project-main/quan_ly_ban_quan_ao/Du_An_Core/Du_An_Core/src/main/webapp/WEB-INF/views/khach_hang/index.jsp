<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Quản lý Khách hàng</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<body>
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
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
        </div>
    </div>
</body>
</html>
