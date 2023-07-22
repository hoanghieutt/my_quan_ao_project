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

<br>
<sf:form action="${action}" method="post" modelAttribute="vm">
    <div class="container">
        <h1 style="text-align: center;color: black">Thêm mới Chi tiết Sản phẩm</h1>

        <div>
            <label class="form-label">Mã Chi tiết</label>
            <sf:input path="maCTSP" class="form-control"/>
            <c:if test="${not empty massageMaTrung}">
                <div style="color: red">
                        ${massageMaTrung}
                </div>
            </c:if>
            <sf:errors path="maCTSP" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Kích cỡ</label>
            <sf:select path="size" class="form-control">
                <sf:option value="">-- Chọn Kích cỡ --</sf:option>
                <c:forEach items="${listSize}" var="s">
                    <sf:option value="${s.maSize}">${s.size}</sf:option>
                </c:forEach>
            </sf:select>

            <sf:errors path="size" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Màu sắc</label>
            <sf:select path="mauSac" class="form-control">
                <sf:option value="">-- Chọn Màu sắc --</sf:option>
                <c:forEach items="${listMauSac}" var="ms">
                    <sf:option value="${ms.maMS}">${ms.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="mauSac" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Chất liệu</label>
            <sf:select path="chatLieu" class="form-control">
                <sf:option value="">-- Chọn Chất liệu --</sf:option>
                <c:forEach items="${listChatLieu}" var="cl">
                    <sf:option value="${cl.maCL}">${cl.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <c:if test="${not empty validateNull}">
                <div style="color: red">
                        ${validateNull}
                </div>
            </c:if>
            <sf:errors path="chatLieu" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Sản phẩm</label>
            <sf:select path="sanPham" class="form-control">
                <sf:option value="">-- Chọn Sản phẩm --</sf:option>
                <c:forEach items="${listSanPham}" var="sp">
                    <sf:option value="${sp.masp}">${sp.tensp}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="sanPham" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Loại sản phẩm</label>
            <sf:select path="loaiSanPham" class="form-control">
                <sf:option value="">-- Chọn Loại sản phẩm --</sf:option>
                <c:forEach items="${listLoaiSP}" var="lsp">
                    <sf:option value="${lsp.maLSP}">${lsp.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="loaiSanPham" cssStyle="color:red;"/>
        </div>

        <div>
            <label class="form-label">Môn thể thao</label>
            <sf:select path="monTheThao" class="form-control">
                <sf:option value="">-- Chọn Môn thể thao --</sf:option>
                <c:forEach items="${listMTT}" var="mtt">
                    <sf:option value="${mtt.mamtt}">${mtt.ten}</sf:option>
                </c:forEach>
            </sf:select>
            <sf:errors path="monTheThao" cssStyle="color:red;"/>
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