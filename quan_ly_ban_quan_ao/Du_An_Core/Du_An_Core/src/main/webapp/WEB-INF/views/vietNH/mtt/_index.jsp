<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Mon the thao</title>
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
</STYLE>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
    <h2>ACTIVATED SPORTS</h2>
    <form action="/mon_the_thao/tim" method="post">
        <p>
            <div>Key word: </div>
        <input type="text" name="keyword">
        <button type="submit">Find</button>
        </p>
    </form>
    <br>
    <br>
    <a href="/mon_the_thao/form">Add a new sport</a>
    <table>
        <tr>
            <td><strong>ID</strong></td>
            <td><strong>Name</strong></td>
            <td><strong>Created</strong></td>
            <td><strong>Updated</strong></td>
        </tr>
        <c:forEach items="${mttTable.content}" var="spr">
            <tr>
                <td>${spr.mamtt}</td>
                <td>${spr.ten}</td>
                <td>${spr.ngaytao}</td>
                <td>${spr.ngaysua}</td>
                <td><a href="/mon_the_thao/sua/${spr.mamtt}">UPDATE</a></td>
                <td><a href="/mon_the_thao/delete/${spr.mamtt}">DELETE</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="?pageNum=0">First</a>
    <a href="?pageNum=${mttTable.number-1}">Previous</a>
    <a href="?pageNum=${mttTable.number+1}">Next</a>
    <a href="?pageNum=${mttTable.totalPages-1}">Last</a>


    <h2>DELETED SPORTS</h2>
    <table>
        <tr>
            <td><strong>ID</strong></td>
            <td><strong>Name</strong></td>
            <td><strong>Created</strong></td>
            <td><strong>Deleted</strong></td>
        </tr>
        <c:forEach items="${mttTableD}" var="spr">
            <tr>
                <td>${spr.mamtt}</td>
                <td>${spr.ten}</td>
                <td>${spr.ngaytao}</td>
                <td>${spr.ngaysua}</td>
                <td><a href="/mon_the_thao/restore/${spr.mamtt}">RESTORE</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>