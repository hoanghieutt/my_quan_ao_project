<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
    <p>Người lập: ${hoadon.nguoilap}</p>
    <p>Ngày lập: ${hoadon.ngaylap}</p>
    <p>Ghi chú: ${hoadon.ghichu} </p>
    <p>Người mua: ${hoadon.nguoimua.tenkhachhang}</p>

    <p>Trạng thái:
        <c:if test="${hoadon.trangthai == 1}">Hoạt động</c:if>
        <c:if test="${hoadon.trangthai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/hoadon/index">Back</a>
</div>