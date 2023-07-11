<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/khachhang/index" method="post" modelAttribute="searchForm">
    <p>Tên/Sđt:<form:input path="keyword"/></p>
    <p>
        Hạng khách hàng:
        <form:select path="mahang">
            <option value="">----</option>
            <form:options
                items="${dsHangKH}"
                itemLabel="tenhang"
                itemValue="mahang"
            />
        </form:select>
    </p>
    <p>
        Thẻ thành viên:
        <form:select path="mathe">
            <option value="">----</option>
            <form:options
                items="${dsThe}"
                itemLabel="mathe"
                itemValue="mathe"
            />
        </form:select>
    </p>
    <button type="submit">Tìm</button>
</form:form>
