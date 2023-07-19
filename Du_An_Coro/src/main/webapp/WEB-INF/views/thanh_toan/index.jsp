<%@ page language="java" pageEncoding="UTF-8" %>
    <title>Document</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="icon" href="img/background_title.jpg" type="image/x-icon">--%>
    <title>Quản lý hình thức thanh toán</title>
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
            <div class="row">
                <div class="col-md-1"></div>
                <div class="col-md-10">
                    <h1 style="text-align: center; color: black">Quản lý Hình thức thanh toán</h1>
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
<%@ include file="../layout/footer.jsp" %>
</html>