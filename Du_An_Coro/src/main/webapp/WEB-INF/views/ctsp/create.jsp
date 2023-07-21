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
<sf:form action="${action}" method="post" modelAttribute="vm">
    <div class="container">
        <h1 style="text-align: center;color: black">Thêm mới Chi tiết Sản phẩm</h1>

        <div>
            <label class="form-label">Mã Chi tiết</label>
            <sf:input path="maCTSP" class="form-control"/>
            <sf:errors path="maCTSP" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Kích cỡ</label>
            <sf:select path="maSize" class="form-control">
                <sf:option value="">-- Chọn Kích cỡ --</sf:option>
                <c:forEach items="${listSize}" var="size">
                    <sf:option value="${size.maSize}">${size.tenSize}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="maSize" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Màu sắc</label>
            <sf:select path="maMS" class="form-control">
                <sf:option value="">-- Chọn Màu sắc --</sf:option>
                <c:forEach items="${listMauSac}" var="mauSac">
                    <sf:option value="${mauSac.maMS}">${mauSac.tenMS}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="maMS" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Chất liệu</label>
            <sf:select path="maCL" class="form-control">
                <sf:option value="">-- Chọn Chất liệu --</sf:option>
                <c:forEach items="${listChatLieu}" var="chatLieu">
                    <sf:option value="${chatLieu.maCL}">${chatLieu.tenCL}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="maCL" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Sản phẩm</label>
            <sf:select path="maSP" class="form-control">
                <sf:option value="">-- Chọn Sản phẩm --</sf:option>
                <c:forEach items="${listSanPham}" var="sanPham">
                    <sf:option value="${sanPham.maSP}">${sanPham.tenSP}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="maSP" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Loại sản phẩm</label>
            <sf:select path="maLSP" class="form-control">
                <sf:option value="">-- Chọn Loại sản phẩm --</sf:option>
                <c:forEach items="${listLoaiSP}" var="loaiSanPham">
                    <sf:option value="${loaiSanPham.maLSP}">${loaiSanPham.tenLSP}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="maLSP" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Môn thể thao</label>
            <sf:select path="maMTT" class="form-control">
                <sf:option value="">-- Chọn Môn thể thao --</sf:option>
                <c:forEach items="${listMTT}" var="monTheThao">
                    <sf:option value="${monTheThao.maMTT}">${monTheThao.tenMTT}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="maMTT" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Số lượng</label>
            <sf:input path="soLuong" class="form-control" type="number"/>
            <sf:errors path="soLuong" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Giá</label>
            <sf:input path="gia" class="form-control" type="number"/>
            <sf:errors path="gia" cssStyle="color:red;"/>
        </div>

        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-8">
                <div class="mb-3">
                    <button type="submit" class="btn btn-primary">Add</button>
                </div>
            </div>
        </div>
    </div>
</sf:form>






<%@ include file="../layout/footer.jsp" %>
</html>