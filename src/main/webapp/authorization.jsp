<%--
  Created by IntelliJ IDEA.
  User: 37529
  Date: 22.03.2024
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>authorization</title>
</head>
<body>
<form  method="post">
    Login:<input name="login" type="text"><br/>
    Password:<input name="password" type="text"><br/>
    Name:<input name="name" type="text"><br/>
    Surname:<input name="surname" type="text"><br/>
    Address:<input name="address" type="text"><br/>
    Age:<input name="age" type="text"><br/>
    Mark:<input name="mark" type="text"><br/>
    <button type="submit">Save</button>
</form>
<form action="${pageContext.request.contextPath}/signUp" target="_blank">
    <label>Уже зарегистрирован?</label>
    <button>Войти</button>
</form>
</body>
</html>
