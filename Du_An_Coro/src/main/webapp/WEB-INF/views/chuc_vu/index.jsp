<%@ page language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Document</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>


</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">
            <h1 style="text-align: center;">Quản lý chức vụ</h1>

            <br>

            <form action="${pageContext.request.contextPath}/chuc-vu/search" method="post">
                <input type="text" placeholder="Nhập từ khóa cần tìm kiếm" name="keyword" value="${keyword}">
                <input type="date" name="min" value="${minDate}">
                <input type="date" name="max" value="${maxDate}">
                <button>search</button>
            </form>
            <h1 style="text-align: center; color: black; margin-top: 50px; margin-bottom: 50px">List danh sách sản phẩm</h1>

            <a class="col-sm-4" href="${pageContext.request.contextPath}/chuc-vu/exportFilePDF"><button class="btn btn-primary" style="margin-bottom: 30px">Xuất file pdf</button></a>
            <a class="col-sm-4" href="${pageContext.request.contextPath}/chuc-vu/exportFileExcel"><button class="btn btn-primary" style="margin-bottom: 30px">Xuất file excal</button></a>


            <br>
            <a class="btn btn-warning" href="/chuc-vu/create">ADD</a>
            <br>
            <table class="table">
                <thead>
                <th scope="col">Mã</th>
                <th scope="col">Tên</th>
                <th scope="col">Ngày tạo</th>
                <th scope="col">Ngày sửa</th>
                <th scope="col">Trạng thái</th>
                <th scope="col">Action</th>
                </thead>

                <tbody>
                <c:forEach items="${data}" var="cv">
                    <tr>
                        <td>${cv.maCV}</td>
                        <td>${cv.tenCV}</td>
                        <td>${cv.ngayTao}</td>
                        <td>${cv.ngaySua}</td>
                        <td>${cv.trangThai==1?"Còn hoạt động":"Không hoạt động"}</td>
                        <td>
                            <a class="btn btn-warning" href="/chuc-vu/edit/${cv.maCV}">Edit</a>
                            <a class="btn btn-danger" href="/chuc-vu/delete/${cv.maCV}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>

</html>