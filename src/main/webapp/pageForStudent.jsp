<%@ page import="entities.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>mainStudent</title>
</head>
<body>
<%--<% int currentPage = (int) request.getAttribute("currentPage");
%>--%>
<link rel="stylesheet" type="text/css" href="stylesheet.css">


<div class="top-div">

    <%--   <div class="left" style="width: 100px;">
           <button class="via" onclick="location.href='index?page=1&update=false';">VIA</button>
       </div>--%>

    <form class="mid" action="read" method="post">
        <div class="search">
            <span class="search-icon material-symbols-outlined"></span>
            <label >
                <input type="text" name="s" class="search-input" placeholder="Find student">
            </label>
        </div>


        <div class="right" style="width: 100px; display: flex; align-items: center;">
            <button class="searchbar-button">Search</button>
        </div>
    </form>
    <%--   <div class="right-right">
           <button class="home-click" onclick="location.href='index';">Sign Up</button>
       </div>--%>
</div>
<% User user = (User) request.getAttribute("current"); %>
<div style="display: flex; flex-direction: row; justify-content: space-between;">
    <div style="display: flex; border-radius: 25px; background-color: white; width: 25vw">
        <div class="container">
            <div class="signin-signup">
                <form action="updateMyself" method="post" class="sign-in-form">
                    <h2 class="title">About me</h2>
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="hidden" name="user" value="<%=user%>">
                        <input type="hidden" name="id" value="<%=user.getId()%>">
                        <input type="text" name="name" value="<%=user.getStudent().getName()%>" placeholder="Name">
                    </div>
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="text" name="surname" value="<%=user.getStudent().getSurname()%>" placeholder="Surname">
                    </div>
                    <div class="input-field">
                        <i class="fas fa-envelope"></i>
                        <input type="text" name="email" value="<%=user.getEmail()%>" placeholder="Email">
                    </div>
                    <div class="input-field">
                        <i class="fa-solid fa-child-reaching"></i>
                        <input type="text" name="age" value="<%=user.getStudent().getAge()%>" placeholder="Age">
                    </div>
                    <div class="input-field">
                        <i class="fa-solid fa-location-dot"></i>
                        <input type="text" name="address" value="<%=user.getStudent().getAddress()%>" placeholder="Address">
                    </div>
                    <div class="input-field">
                        <i class="fa-solid fa-marker"></i>
                        <input type="text" name="mark" value="<%=user.getStudent().getMark()%>" placeholder="Mark">
                    </div>

                    <input type="submit" value="Edit" class="btn">
                </form>
                <a href="forgotPass">Want to change your password?</a>
            </div>
        </div>
    </div>

    <div class="list-box" style="flex:1; margin-left: 75px; margin-right: 75px; max-width: 1088px; width: 500vw;">
        <div class="list-div" style="display: inline-block; width: 100%; background-color: white; border-radius: 5px;">
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Surname</th>
                    <th>Address</th>
                    <th>Age</th>
                    <th>Mark</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="student" items="${students}">
                    <tr>
                        <td data-cell="Name"><c:out value="${student.name}"/></td>
                        <td data-cell="Surname"><c:out value="${student.surname}"/></td>
                        <td data-cell="Address"><c:out value="${student.address}"/></td>
                        <td data-cell="Age"><c:out value="${student.age}"/></td>
                        <td data-cell="Mark"><c:out value="${student.mark}"/></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
