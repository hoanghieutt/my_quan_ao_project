<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<body>
    <form:form modelAttribute="fkm" method="post" action="/KM/${malenh}">
        <div>
            <p>Name: </p>
            <form:input path="tenkm"/>
        </div>

        <div>
            <p>Started date: </p>
            <form:input path="ngaybatdau" type="date"/>
        </div>

        <div>
            <p>Ended date: </p>
            <form:input path="ngayketthuc" type="date"/>
        </div>

        <div>
            <p>Discount value: </p>
            <form:input path="giamgia" type="number"/>
        </div>

        <div>
            <form:input path="ngaytao" type="hidden"/>
            <form:input path="makm" type="hidden"/>
        </div>

        <button type="submit">SAVE</button>
    </form:form>
</body>
</html>