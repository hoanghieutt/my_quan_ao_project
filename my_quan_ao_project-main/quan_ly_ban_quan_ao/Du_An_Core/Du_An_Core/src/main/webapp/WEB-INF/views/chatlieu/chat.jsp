<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<h2>Chất Liệu</h2>
<form:form action="/chat-lieu/add" method="post" modelAttribute="cl">

    Ma: <form:input path="maCL"></form:input>
    <form:errors path="maCL"></form:errors>
    <br>
    Ten: <form:input path="ten"></form:input>
    <form:errors path="ten"></form:errors>
    <br>
    Ngày Tạo: <form:input type="Date" path="ngayTao"></form:input>
    <br>
    Ngày Sửa: <form:input type="Date" path="ngaySua"></form:input>
    <br>
    Trạng Thái: <form:radiobutton path="trangThai" checked="true" value="true"/>Còn
    <form:radiobutton path="trangThai" value="false"/>Hết
    <br/>

    <form:button type="submit">add</form:button>
</form:form>
<table class="table">
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Tên</th>
        <th>Ngày Tạo</th>
        <th>Ngày Sửa</th>
        <th>Trạng Thái</th>
        <th colspan="2">Action</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${chatLieu}" var="cl"  varStatus="stt">
        <tr>

            <td>${stt.index}</td>
            <td>${cl.maCL}</td>
            <td>${cl.ten} </td>
            <td>${cl.ngayTao}</td>
            <td>${cl.ngaySua} </td>
            <td>${cl.trangThai ?"còn": "hết"}</td>
            <td>
                <a href="/chat-lieu/delete/${cl.maCL}">Delete</a>
                <a href="/chat-lieu/view-update/${cl.maCL}">Update</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
