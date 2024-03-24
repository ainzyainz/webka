<%@ page import="entities.User" %>
<%@ page import="DTO.UserDTO" %>
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
<head>
    <title>Main Page (Student)</title>
</head>

<link rel="stylesheet" type="text/css" href="stylesheet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

<div class="top-div">

      <div class="left" style="width: 100px;">
           <button class="home-click" onclick="location.href='index?page=1&update=false';">Home</button>
       </div>

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
       <div class="right-right">
           <button class="home-click" onclick="location.href='/signUp';">Exit</button>
       </div>
</div>
<% UserDTO user = (UserDTO) request.getAttribute("current"); %>
<div style="display: flex; flex-direction: row; justify-content: space-between;">
    <div class="container">
        <div class="about-me">
            <div class="card-header">
                <img class="via" style="object-fit: cover;" src="pexels-photo-18468827.webp" alt="pfp"/>
            </div>


            <form action="updateMyself" method="post" class="update-form">
                <p class="title">Profile</p>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="hidden" name="studentId" value="<%=user.getStudent().getId()%>">
                    <input type="hidden" name="id" value="<%=user.getId()%>">
                    <input type="text" name="name" value="<%=user.getStudent().getName()%>" placeholder="Name">
                </div>
                <div class="input-field">
                    <i class="fas fa-user"></i>
                    <input type="text" name="surname" value="<%=user.getStudent().getSurname()%>" placeholder="Surname">
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
                <input type="submit" value="Edit" class="create" style="width: 5vw; margin-left: 40%; margin-top: 8%;">
                <a href="verifyPass">Want to change your password?</a>
            </form>
        </div>
    </div>


    <div class="list-box" style="flex:1; margin-left: 75px; margin-right: 75px; max-width: 1088px; width: 500vw;">
        <div class="list-div" style="display: inline-block; width: 100%; border-radius: 5px;">
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
</div>
</body>
</html>
