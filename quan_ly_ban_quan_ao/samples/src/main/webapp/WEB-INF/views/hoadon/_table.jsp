<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<a href="/hoadon/sort">Sort</a>
<table border="1" style="width:100%">
    <tr>
        <th>Người lập</th>
        <th>Ngày lập</th>
        <th>Mã phiếu</th>
        <th>Người mua</th>
        <th>Ghi chú</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${page.content}" var="item">
        <tr>
            <td>${item.nguoilap}</td>
            <td>${item.ngaylap}</td>
            <td>${item.phieugiaohang.maphieugiao}</td>
            <td>${item.nguoimua.tenkhachhang}</td>
            <td>${item.ghichu}</td>
            <td>
                <c:if test="${item.trangthai == 0}">Không hoạt động</c:if>
                <c:if test="${item.trangthai == 1}">Hoạt động</c:if>
            </td>
            <td>
                <a href="javascript:remove('${item.mahoadon}')">Remove</a>
                <a href="/hoadon/view-update/${item.mahoadon}">Update</a>
                <a href="/hoadon/detail/${item.mahoadon}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${page.totalElements == 0}">
        <td colspan="7">Không có bản ghi nào</td>
    </c:if>
</table>

<a href="/hoadon/index?p=0&fromDate=${param.fromDate}&toDate=${param.toDate}&maphieu=${param.maphieu}">First</a>
<a href="/hoadon/index?p=${page.number-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maphieu=${param.maphieu}">Prev</a>
<a href="/hoadon/index?p=${page.number+1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maphieu=${param.maphieu}">Next</a>
<a href="/hoadon/index?p=${page.totalPages-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maphieu=${param.maphieu}">Last</a>

<div>Trang hiện tại: ${page.number}</div>
<div>Tổng số trang: ${page.totalPages}</div>
<div>Tổng số bản ghi:${page.totalElements}</div>
<script>
function remove(mahoadon){
    if(confirm('Bạn có muốn xóa?')){
        location.href = "/hoadon/remove/" + mahoadon;
    }
}
</script>