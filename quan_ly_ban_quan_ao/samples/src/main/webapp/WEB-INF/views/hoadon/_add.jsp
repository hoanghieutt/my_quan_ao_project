<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="hoadon" method="post" action="/hoadon/add">
    <p>Người lập:
        <form:input path="nguoilap"/>
        <form:errors path="nguoilap" element="div"/>
    </p>
    <p>Ghi chú:
        <form:input path="ghichu"/>
        <form:errors path="ghichu" element="div"/>
    </p>

    <p>Phiếu giao hàng:
        <form:select path="phieugiaohang.maphieugiao">
            <option value="">----</option>
            <form:options items="${dsPhieu}"
                itemLabel="maphieugiao" itemValue="maphieugiao"
            />
        </form:select>
        <div>${maphieuError}</div>
    </p>

    <p>Người mua:
        <form:select path="nguoimua.makhachhang">
            <option value="">----</option>
            <form:options items="${dsKhachHang}"
                itemLabel="tenkhachhang" itemValue="makhachhang"
            />
        </form:select>
        <div>${nguoimuaError}</div>
    </p>

    <p>
        Trạng thái:
        <form:radiobuttons path="trangthai" items="${dsTrangThai}"/>
        <form:errors path="trangthai" element="div"/>
    </p>
    ${message}
    <button>Add</button>
</form:form>