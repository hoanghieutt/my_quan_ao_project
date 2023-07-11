<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/hoadon/index" method="post" modelAttribute="searchForm">
    <p>Từ ngày:<form:input placeholder="dd/MM/yyyy" path="fromDate"/></p>
    <p>Đến ngày:<form:input placeholder="dd/MM/yyyy" path="toDate"/></p>
    <p>
        Mã phiếu:
        <form:select path="maphieu">
            <option value="">----</option>
            <form:options
                items="${dsPhieu}"
                itemLabel="maphieugiao"
                itemValue="maphieugiao"
            />
        </form:select>
    </p>
    <button type="submit">Tìm</button>
</form:form>
