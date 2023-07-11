<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
    <p>Tên khách hàng: ${khachhang.tenkhachhang}</p>
    <p>Số ĐT: ${khachhang.sodienthoai}</p>
    <p>Hạng Khách Hàng: ${khachhang.hangkhachhang.tenhang}</p>
    <p>Thẻ thành viên: ${khachhang.thethanhvien.mathe}</p>
    <p>Sinh nhật: ${khachhang.sinhnhat}</p>
    <p>
        Giới tính:
        <c:if test="${khachhang.gioitinh}">Nam</c:if>
        <c:if test="${!khachhang.gioitinh}">Nữ</c:if>
    </p>
    <p>Trạng thái:
        <c:if test="${khachhang.trangthai == 1}">Hoạt động</c:if>
        <c:if test="${khachhang.trangthai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/khachhang/index">Back</a>
</div>