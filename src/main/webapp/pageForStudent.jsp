<%@ page import="entities.Student" %>
<%@ page import="java.util.List" %><%--

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
           <button class="home-click" onclick="location.href='index?page=1&update=false';">Home</button>
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
<div style="display: flex; flex-direction: row; justify-content: space-between;">
    <div class style="width: 400px">

    </div>

    <div class="list-box" style="flex:1; margin-left: 75px; margin-right: 75px; max-width: 1088px;">
        <div class="list-div" style="display: inline-block; width: 100%">
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
               <%-- <%
                    List<Student> list = (List<Student>) request.getAttribute("students");
                <% for (Student temp : list) { %>

                <tr>
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
                    <% } %>
                </tr>--%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
