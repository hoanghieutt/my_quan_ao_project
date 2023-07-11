<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/phieugiamgia/index" method="post" modelAttribute="searchForm">
    <p>Từ ngày:<form:input placeholder="dd/MM/yyyy" path="fromDate"/></p>
    <p>Đến ngày:<form:input placeholder="dd/MM/yyyy" path="toDate"/></p>
    <p>
        Khách hàng:
        <form:select path="maKhachHang">
            <option value="">----</option>
            <form:options
                items="${dsKhachHang}"
                itemLabel="tenkhachhang"
                itemValue="makhachhang"
            />
        </form:select>
    </p>
    <button type="submit">Tìm</button>
</form:form>
