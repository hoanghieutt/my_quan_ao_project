<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form modelAttribute="phieugiamgia" method="post" action="/phieugiamgia/update/${phieugiamgia.maphieu}">
    <form:input type="hidden" path="maphieu" />
    <p>Tên phiếu:
        <form:input path="tenphieu"/>
        <form:errors path="tenphieu" element="div"/>
    </p>
    <p>
        Giá trị giảm: <form:input path="giatrigiam"/>
        <form:errors path="giatrigiam" element="div"/>
    </p>
    <p>
        Giá trị giảm tối đa: <form:input path="giatrigiamtoida"/>
        <form:errors path="giatrigiamtoida" element="div"/>
    </p>
    <p>
        Ngày bắt đầu: <form:input path="ngaybatdau" placeholder="dd/MM/yyyy"/>
        <form:errors path="ngaybatdau" element="div"/>
        <div>${dateError}</div>
    </p>
    <p>
        Ngày kết thúc: <form:input path="ngayketthuc" placeholder="dd/MM/yyyy"/>
        <form:errors path="ngayketthuc" element="div"/>
    </p>
    <p>Khách hàng:
        <form:select path="nguoisohuu.makhachhang">
            <option value="">----</option>
            <form:options items="${dsKhachHang}"
                itemLabel="tenkhachhang" itemValue="makhachhang"
            />
        </form:select>
        <div>${maKHError}</div>
    </p>
    ${message}
    <button>Update</button>
</form:form>