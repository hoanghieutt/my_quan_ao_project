<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
    <p>Tên phiếu: ${phieugiamgia.tenphieu}</p>
    <p> Giá trị giảm: ${phieugiamgia.giatrigiam}</p>
    <p>Giá trị giảm tối đa: ${phieugiamgia.giatrigiamtoida}</p>
    <p>Ngày bắt đầu: ${phieugiamgia.ngaybatdau}</p>
    <p>Ngày kết thúc: ${phieugiamgia.ngaybatdau}</p>
    <p>Khách hàng: ${phieugiamgia.nguoisohuu.tenkhachhang}</p>
    <p>Trạng thái:
        <c:if test="${phieugiamgia.trangthai == 1}">Hoạt động</c:if>
        <c:if test="${phieugiamgia.trangthai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/phieugiamgia/index">Back</a>
</div>