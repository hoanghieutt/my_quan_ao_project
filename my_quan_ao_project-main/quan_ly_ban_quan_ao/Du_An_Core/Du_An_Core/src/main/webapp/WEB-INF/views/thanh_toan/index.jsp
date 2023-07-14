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
            <h1 style="text-align: center;">Quản lý Hình thức thanh toán</h1>
            <br>
<%--            <form action="${pageContext.request.contextPath}/hinh-thuc-thanh-toan/searchByDate" method="get">--%>
<%--                <input type="date" name="min" value="${minDate}">--%>
<%--                <input type="date" name="max" value="${maxDate}">--%>
<%--                <button>search</button>--%>
<%--            </form>--%>

<%--            <form action="${pageContext.request.contextPath}/hinh-thuc-thanh-toan/searchByKeyword" method="get">--%>
<%--                <input type="text" placeholder="Nhập từ khóa cần tìm kiếm" name="keyword" value="${keyword}">--%>
<%--                <button>search</button>--%>
<%--            </form>--%>
            <form action="${pageContext.request.contextPath}/hinh-thuc-thanh-toan/search" method="post">
                <input type="text" placeholder="Nhập từ khóa cần tìm kiếm" name="keyword" value="${keyword}">
                <input type="date" name="min" value="${minDate}">
                <input type="date" name="max" value="${maxDate}">
                <button>search</button>
            </form>

            <br>
            <a class="btn btn-warning" href="/hinh-thuc-thanh-toan/create">ADD</a>
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
                <c:forEach items="${data}" var="httt">
                    <tr>
                        <td>${httt.maHTTT}</td>
                        <td>${httt.tenHTTT}</td>
                        <td>${httt.ngayTao}</td>
                        <td>${httt.ngaySua}</td>
                        <td>${httt.trangThai==1?"Còn hoạt động":"Không hoạt động"}</td>
                        <td>
                            <a class="btn btn-warning" href="/hinh-thuc-thanh-toan/edit/${httt.maHTTT}">Edit</a>
                            <a class="btn btn-danger" href="/hinh-thuc-thanh-toan/delete/${httt.maHTTT}">Xóa</a>
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