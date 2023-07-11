<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<form:form action="/phieugiaohang/index" method="post" modelAttribute="searchForm">
    <p>Từ ngày:<form:input placeholder="dd/MM/yyyy" path="fromDate"/></p>
    <p>Đến ngày:<form:input placeholder="dd/MM/yyyy" path="toDate"/></p>
    <p>
        Địa chỉ:
        <form:select path="maDiachi">
            <option value="">----</option>
            <form:options
                items="${dsDiachi}"
                itemLabel="tendiachi"
                itemValue="madiachi"
            />
        </form:select>
    </p>
    <button type="submit">Tìm</button>
</form:form>
