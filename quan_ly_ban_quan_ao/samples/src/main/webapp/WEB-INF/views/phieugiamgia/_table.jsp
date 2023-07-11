<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<a href="/phieugiamgia/sort">Sort</a>
<table border="1" style="width:100%">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Ngày bắt đầu</th>
        <th>Ngày kết thúc</th>
        <th>Giá trị giảm</th>
        <th>Trạng thái</th>
        <th>Tên KH</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${page.content}" var="item">
        <tr>
            <td>${item.maphieu}</td>
            <td>${item.tenphieu}</td>
            <td>${item.ngaybatdau}</td>
            <td>${item.ngayketthuc}</td>
            <td>${item.giatrigiam}</td>
            <td>
                <c:if test="${item.trangthai == 0}">Không hoạt động</c:if>
                <c:if test="${item.trangthai == 1}">Hoạt động</c:if>
            </td>
            <td>${item.nguoisohuu.tenkhachhang}</td>
            <td>
                <a href="javascript:remove('${item.maphieu}')">Remove</a>
                <a href="/phieugiamgia/view-update/${item.maphieu}">Update</a>
                <a href="/phieugiamgia/detail/${item.maphieu}">Detail</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${page.totalElements == 0}">
        <td colspan="8">Không có bản ghi nào</td>
    </c:if>
</table>

<a href="/phieugiamgia/index?p=0&fromDate=${param.fromDate}&toDate=${param.toDate}&maKhachHang=${param.maKhachHang}">First</a>
<a href="/phieugiamgia/index?p=${page.number-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maKhachHang=${param.maKhachHang}">Prev</a>
<a href="/phieugiamgia/index?p=${page.number+1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maKhachHang=${param.maKhachHang}">Next</a>
<a href="/phieugiamgia/index?p=${page.totalPages-1}&fromDate=${param.fromDate}&toDate=${param.toDate}&maKhachHang=${param.maKhachHang}">Last</a>
<div>Trang hiện tại: ${page.number}</div>
<div>Tổng số trang: ${page.totalPages}</div>
<div>Tổng số bản ghi:${page.totalElements}</div>
<script>
function remove(maphieu){
    if(confirm('Bạn có muốn xóa?')){
        location.href = "/phieugiamgia/remove/" + maphieu;
    }
}
</script>