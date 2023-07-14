<!doctype html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<style>
    h2{
        width: 100%;
        align-items: center;
    }
</style>
<body>
    <h2>ACRIVATED DISCOUNT</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Begin</th>
            <th>End</th>
            <th>Value</th>
            <th>Created</th>
            <th>Updated</th>
        </tr>
        <c:forEach items="${kmpage.content}" var="k">
            <tr>
                <th>${k.makh}</th>
                <th>${k.tenkm}</th>
                <th>${k.ngaybatdau}</th>
                <th>${k.ngayketthuc}</th>
                <th>${k.giamgia}</th>
                <th>${k.ngaytao}</th>
                <th>${k.ngaysua}</th>
            </tr>
        </c:forEach>
    </table>
</body>
</html>