<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div>
    <p>Mã phiếu: ${phieugiaohang.maphieugiao}</p>
    <p>Người nhận: ${phieugiaohang.nguoinhan}</p>
    <p>SĐT người nhận: ${phieugiaohang.sdtnhan}</p>
    <p>Ngày giao: ${phieugiaohang.ngaygiao}</p>
    <p>Địa chỉ: ${phieugiaohang.diachi.tendiachi}</p>

    <p>Trạng thái:
        <c:if test="${phieugiaohang.trangthai == 1}">Hoạt động</c:if>
        <c:if test="${phieugiaohang.trangthai == 0}">Không hoạt động</c:if>
    </p>
    <a href="/phieugiaohang/index">Back</a>
</div>