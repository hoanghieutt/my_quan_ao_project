<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<a href="/khachhang/sort">Sort</a>
<table border="1" style="width:100%">
    <tr>
        <th>Tên</th>
        <th>Sđt</th>
        <th>Hạng</th>
        <th>Mã thẻ</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Trạng thái</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${page.content}" var="item">
        <tr>
            <td>${item.tenkhachhang}</td>
            <td>${item.sodienthoai}</td>
            <td>${item.hangkhachhang.tenhang}</td>
            <td>${item.thethanhvien.mathe}</td>
            <td>
                <c:if test="${item.gioitinh}">Nam</c:if>
                <c:if test="${!item.gioitinh}">Nữ</c:if>
            </td>
            <td>${item.sinhnhat}</td>
            <td>
                <c:if test="${item.trangthai == 0}">Không hoạt động</c:if>
                <c:if test="${item.trangthai == 1}">Hoạt động</c:if>
            </td>
            <td>
                <a href="javascript:remove('${item.makhachhang}')">Remove</a>
                <a href="/khachhang/view-update/${item.makhachhang}">Update</a>
                <a href="/khachhang/detail/${item.makhachhang}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${page.totalElements == 0}">
        <td colspan="8">Không có bản ghi nào</td>
    </c:if>
</table>

<a href="/khachhang/index?p=0&keyword=${param.keyword}&mahang=${param.mahang}&mathe=${param.mathe}">First</a>
<a href="/khachhang/index?p=${page.number-1}&keyword=${param.keyword}&mahang=${param.mahang}&mathe=${param.mathe}">Prev</a>
<a href="/khachhang/index?p=${page.number+1}&keyword=${param.keyword}&mahang=${param.mahang}&mathe=${param.mathe}">Next</a>
<a href="/khachhang/index?p=${page.totalPages-1}&keyword=${param.keyword}&mahang=${param.mahang}&mathe=${param.mathe}">Last</a>
<div>Trang hiện tại: ${page.number}</div>
<div>Tổng số trang: ${page.totalPages}</div>
<div>Tổng số bản ghi:${page.totalElements}</div>
<script>
function remove(makhachhang){
    if(confirm('Bạn có muốn xóa?')){
        location.href = "/khachhang/remove/" + makhachhang;
    }
}
</script>