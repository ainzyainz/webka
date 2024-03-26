<%@ page import="entities.User" %>
<%@ page import="DTO.UserDTO" %>
<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.List" %>
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
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
</head>

<link rel="stylesheet" type="text/css" href="stylesheet.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">

<div class="top-div">

      <div class="left" style="width: 100px;">
           <button class="home-click" onclick="location.href='display?page=1';">Home</button>
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
                <div class="input-field">
                    <i class="fa-solid fa-location-dot"></i>
                    <input type="text" name="country" value="<%=user.getStudent().getCountryDTO().getCountryName()%>" placeholder="Country">
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
                    <th>Country</th>
                </tr>
                </thead>
            <%
                List<StudentDTO> list = (List<StudentDTO>) request.getAttribute("list");


                for (StudentDTO temp : list) { %>
                <tbody>
                <td data-cell="Name"><%= temp.getName() %>
                </td>
                <td data-cell="Surname"><%= temp.getSurname() %>
                </td>
                <td data-cell="Address"><%= temp.getAddress() %>
                </td>
                <td data-cell="Age"><%= temp.getAge() %>
                </td>
                <td data-cell="Mark"><%= temp.getMark() %>
                </td>
                <td data-cell="Country"><%= temp.getCountryDTO().getCountryName() %>
                </td>
                <% }%>
                </tbody>

            </table>
        </div>

        <div class="page-div" style="width: 50%; margin-left: 35%; display: block">

            <%int currentPage = (int) request.getAttribute("currentPage");
                int noOfPages = (int) request.getAttribute("noOfPages");
                if (currentPage != 1) {
            %>
            <td style="display: inline-block">
                <form style="display: inline-block" method="post" action="display?page=<%=currentPage-1%>">
                    <button style="display: inline-block" class="bottom-nav"><span class="material-symbols-outlined">
                        arrow_back
                        </span></button>
                </form>
            </td>
            <%} %>


            <%
                if (noOfPages < 5) {
                    for (int i = 1; i <= noOfPages; i++) {
                        if (i == currentPage) {
            %>
            <%=i%>

            <% } else {%>

            <form style="display: inline-block" method="post" action="display?page=<%=i%>">
                <button style="display: inline-block" class="bottom-nav"><%=i%>
                </button>
            </form>

            <%
                    }
                }
            } else {
            %>

            <form style="display: inline-block" method="post" action="display?page=1">
                <button style="display: inline-block" class="bottom-nav">1
                </button>
            </form>


            <form style="display: inline-block" method="post" action="display?page=2">
                <button style="display: inline-block" class="bottom-nav">2
                </button>
            </form>

            <p style="display: inline-block"><%=currentPage%>
            </p>


            <form style="display: inline-block" method="post" action="display?page=<%=noOfPages-1%>">
                <button style="display: inline-block" class="bottom-nav"><%=noOfPages - 1%>
                </button>
            </form>
            <form style="display: inline-block" method="post" action="display?page=<%=noOfPages%>">
                <button style="display: inline-block" class="bottom-nav"><%=noOfPages%>
                </button>
            </form>
            <% }

                if (currentPage < noOfPages) {
            %>
            <td>
                <form style="display: inline-block" method="post" action="display?page=<%=currentPage + 1%>">
                    <button style="display: inline-block" class="bottom-nav"><span class="material-symbols-outlined">
                        arrow_forward
                        </span></button>
                </form>
            </td>
            <% }%>

        </div>


    </div>
</div>
</div>
</body>
</html>
