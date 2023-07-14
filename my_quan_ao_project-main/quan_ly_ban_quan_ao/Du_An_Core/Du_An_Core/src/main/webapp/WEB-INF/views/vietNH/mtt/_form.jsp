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
    <form:form modelAttribute="mtt" action="/mon_the_thao/${kieuchay}" method="post">
        <p>
            <div>ID:</div>
            <form:input path="mamtt"/>
        </p>
        <p>
        <div>Name:</div>
        <form:input path="ten"/>
        </p>

        <form:input path="ngaytao" type="hidden"/>

        <button type="submit"><strong>${kieuchay}</strong></button>
    </form:form>
</body>
</html>