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
<STYLE>
    h2{
        width: 100%;
        text-align: center;
    }
    table{
        border: 1px solid black;
        width: 100%;
    }
    td{
        border: 1px solid black;
    }
    th{
        border: 1px solid black;
    }
</STYLE>
<body>
    <h2>ACRIVATED DISCOUNT</h2>
    <form method="post" action="/KM/timKW">
        <p>Key word: </p>
        <input type="text" name="tukhoa">
        <button type="submit">Find</button>
    </form>

    <br>
    <br>

    <a href="/KM/themKM">Create new discount</a>
    <br>
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
                <td>${k.makm}</td>
                <td>${k.tenkm}</td>
                <td>${k.ngaybatdau}</td>
                <td>${k.ngayketthuc}</td>
                <td>${k.giamgia}</td>
                <td>${k.ngaytao}</td>
                <td>${k.ngaysua}</td>
                <td><a href="/KM/suaKM/${k.makm}">UPDATE</a></td>
                <td><a href="/KM/xoaKM/${k.makm}">DELETE</a></td>
            </tr>
        </c:forEach>
    </table>

    <a href="?pageNum=0">First</a>
    <a href="?pageNum=${kmpage.number-1}">Pevious</a>
    <a href="?pageNum=${kmpage.number+1}">Next</a>
    <a href="?pageNum=${kmpage.totalPages-1}">Last</a>

    <h2>DELETED DISCOUNT</h2>
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
        <c:forEach items="${kmX}" var="k">
            <tr>
                <td>${k.makm}</td>
                <td>${k.tenkm}</td>
                <td>${k.ngaybatdau}</td>
                <td>${k.ngayketthuc}</td>
                <td>${k.giamgia}</td>
                <td>${k.ngaytao}</td>
                <td>${k.ngaysua}</td>
                <td><a href="/KM/suaKM/${k.makm}">RESTORE</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>