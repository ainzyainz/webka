<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<div class="top-div">

    <div class = "left" style="width: 100px;">


        <button class="home-click" onclick="location.href='index';">Home</button>

    </div>
    <div class = "mid">
        <input type="text" style="flex: 1; margin-top: 5px; height: 27px; padding-left: 15px;" placeholder="Search">
    </div>
    <div class = "right" style="width: 100px; display: flex; align-items: center;">
        <button class="searchbar-button">Search</button>

    </div>


</div>

<div class="create-div">
    <form action="creating" method="post">
        <input class="first" name="name" type="text" placeholder="First Name">
        <input class="first" name="surname" placeholder="Second name" type="text">
        <br/>
        <input class="second" name="address" placeholder="Your address" type="text">
        <input class="second" name="email" placeholder="Your email" type="text">
        <br/>
        <input class="third" name="age" placeholder="Your age" type="text">
        <input class="third" name="mark" placeholder="Your mark" type="text">
        <input class="create" type="submit">
    </form>
</div>
<div class="list-div">
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

        <%
            List<StudentDTO> list = (List<StudentDTO>) request.getAttribute("list");
        %>

        <% for(StudentDTO temp : list) { %>

        <tr>
            <td><%= temp.getName() %> </td>
            <td><%= temp.getSurname() %> </td>
            <td><%= temp.getAddress() %> </td>
            <td><%= temp.getAge() %> </td>
            <td><%= temp.getMark() %> </td>
            <td class="delete-link"> <a href="deleteMe?id=<%=temp.getId()%>">remove</a></td>
            <% } %>
        </tr>

        </tbody>
    </table>
</div>



</body>
</html>
