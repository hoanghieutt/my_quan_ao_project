<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="khachhang" method="post" action="/khachhang/update/${khachhang.makhachhang}">
    <form:input type="hidden" path="makhachhang" />
    <p>Tên khách hàng:
        <form:input path="tenkhachhang"/>
        <form:errors path="tenkhachhang" element="div"/>
    </p>
    <p>Số ĐT:
        <form:input path="sodienthoai"/>
        <div>${sdtError}</div>
    </p>

    <p>Hạng Khách Hàng:
        <form:select path="hangkhachhang.mahang">
            <option value="">----</option>
            <form:options items="${dsHangKH}"
                itemLabel="tenhang" itemValue="mahang"
            />
        </form:select>
        <div>${mahangError}</div>
    </p>

    <p>
        Sinh nhật: <form:input path="sinhnhat"/>
        <form:errors path="sinhnhat" element="div"/>
    </p>
    <p>
        Giới tính:
        <form:radiobuttons path="gioitinh" items="${dsGioiTinh}"/>
        <form:errors path="gioitinh" element="div"/>
    </p>
    ${message}
    <button>Update</button>
</form:form>