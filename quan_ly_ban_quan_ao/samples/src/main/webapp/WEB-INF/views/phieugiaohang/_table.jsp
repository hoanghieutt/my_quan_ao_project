<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<a href="/phieugiaohang/sort">Sort</a>
<table border="1" style="width:100%">
    <tr>
        <th>Mã phiếu</th>
        <th>Người nhận</th>
        <th>SĐT người nhận</th>
        <th>Địa chỉ</th>
        <th>Ngày giao</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${page.content}" var="item">
        <tr>
            <td>${item.maphieugiao}</td>
            <td>${item.nguoinhan}</td>
            <td>${item.sdtnhan}</td>
            <td>${item.diachigiao.tendiachi}</td>
            <td>${item.ngaygiao}</td>
            <td>
                <c:if test="${item.trangthai == 0}">Không hoạt động</c:if>
                <c:if test="${item.trangthai == 1}">Hoạt động</c:if>
            </td>
            <td>
                <a href="javascript:remove('${item.maphieugiao}')">Remove</a>
                <a href="/phieugiaohang/view-update/${item.maphieugiao}">Update</a>
                <a href="/phieugiaohang/detail/${item.maphieugiao}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${page.totalElements == 0}">
        <td colspan="7">Không có bản ghi nào</td>
    </c:if>
</table>

<a href="/phieugiaohang/index?p=0&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">First</a>
<a href="/phieugiaohang/index?p=${page.number-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">Prev</a>
<a href="/phieugiaohang/index?p=${page.number+1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">Next</a>
<a href="/phieugiaohang/index?p=${page.totalPages-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maDiachi=${param.maDiachi}">Last</a>
<div>Trang hiện tại: ${page.number}</div>
<div>Tổng số trang: ${page.totalPages}</div>
<div>Tổng số bản ghi:${page.totalElements}</div>
<script>
function remove(maphieu){
    if(confirm('Bạn có muốn xóa?')){
        location.href = "/phieugiaohang/remove/" + maphieu;
    }
}
</script>