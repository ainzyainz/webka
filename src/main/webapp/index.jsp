<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
</head>
<body>
<% int currentPage = (int) request.getAttribute("currentPage");
    String pageMethod = (String) request.getAttribute("pageMethod");
%>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<div class="top-div">

    <div class = "left" style="width: 100px;">
        <button class="home-click" onclick="location.href='index?page=1';">Home</button>
    </div>

    <form class="mid" action="read" method="post">
        <div class = "search">
            <span class="search-icon material-symbols-outlined">search</span>
            <input type="text" name="s" class="search-input" placeholder="Find student">
        </div>


        <div class = "right" style="width: 100px; display: flex; align-items: center;">
            <button class="searchbar-button">Search</button>
        </div>
    </form>
    <div class="right-right">
        <button class="home-click" onclick="location.href='index';">Sign Up</button>
    </div>



</div>




<div style="display: flex; flex-direction: row; justify-content: space-between;">
    <div style="width:290px;">
        <div class="create-div">
            <form action="creating?page=<%=currentPage%>" method="post">
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
    </div>

    <div class="list-box" style="flex:1; margin-left: 75px; margin-right: 75px; max-width: 1088px;">
        <div class="list-div" style="width: 100%;">
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
                    int noOfPages = (int) request.getAttribute("noOfPages");
                %>

                <% for(StudentDTO temp : list) { %>

                <tr>
                    <td data-cell="Name"><%= temp.getName() %> </td>
                    <td data-cell="Surname"><%= temp.getSurname() %> </td>
                    <td data-cell="Address"><%= temp.getAddress() %> </td>
                    <td data-cell="Age"><%= temp.getAge() %> </td>
                    <td data-cell="Mark"><%= temp.getMark() %> </td>
                    <td class="delete-link"> <a href="deleteMe?id=<%=temp.getId()%>&page=<%=currentPage%>">remove</a></td>
                    <% } %>
                </tr>

                </tbody>
            </table>
        </div>
        <div class="page-div">

            <%
            if (currentPage!=1){
            %>
            <td>
                <form method="post" action="index?page=<%=currentPage-1%>">
                    <button class="bottom-nav">Previous</button>
                </form>
            </td>
            <%} %>


            <table>
                <tr>
                    <%
                        for (int i = 1; i <= noOfPages; i++) {
                            if (i==currentPage){
                    %>
                            <td><%=i%></td>
                    <% }else {%>
                            <td>
                                <form method="post" action="index?page=<%=i%>">
                                    <button class="bottom-nav"><%=i%></button>
                                </form>
                            </td>
                                <%
                    }
                        }

                    %>
                </tr>
            </table>

            <%if (currentPage<noOfPages){
                %>
            <td>
                <form method="post" action="index?page=<%=currentPage+1%>">
                    <button class="bottom-nav">Next</button>
                </form>
            <% }%>

        </div>
    </div>

    <div style="width: 290px;"></div>
</div>


</body>
</html>
