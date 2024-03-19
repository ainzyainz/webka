<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <style>
        /* table {
             margin: auto; !* Выравниваем таблицу по центру *!
         }
         td {
             text-align: center; !* Выравниваем текст по центру ячейки *!
         }*/

        #darkside {
            background: rgba(102, 102, 102, 0.5);
            width: 100%;
            height: 100%;
            position: absolute;
            top: 0;
            left: 0;
            display: none;
        }

        #window {
            width: 300px;
            height: 150px;
            text-align: center;
            padding: 15px;
            border: 3px solid #8B4513;
            border-radius: 10px;
            color: black;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
            background: #fff;
        }

        #darkside:target {
            display: block;
        }

    </style>
    <title></title>
</head>
<body>
<% int currentPage = (int) request.getAttribute("currentPage");
%>
<link rel="stylesheet" type="text/css" href="stylesheet.css">
<div class="top-div">

    <div class="left" style="width: 100px;">
        <button class="home-click" onclick="location.href='index?page=1';">Home</button>
    </div>

    <form class="mid" action="read" method="post">
        <div class="search">
            <span class="search-icon material-symbols-outlined">search</span>
            <label>
                <input type="text" name="s" class="search-input" placeholder="Find student">
            </label>
        </div>


        <div class="right" style="width: 100px; display: flex; align-items: center;">
            <button class="searchbar-button">Search</button>
        </div>
    </form>
    <div class="right-right">
        <button class="home-click" onclick="location.href='index';">Sign Up</button>
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
                int noOfPages = (int) request.getAttribute("noOfPages");%>
            <% for (StudentDTO temp : list) { %>

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
                <td class="delete-link"><a href="deleteMe?id=<%=temp.getId()%>&page=<%=currentPage%>">remove</a></td>
                <td class="delete-link">
                    <a href="update?id=<%=temp.getId()%>&page=<%=currentPage%>">update</a>
                </td>
                <% } %>
            </tr>
            </tbody>
        </table>
        <% StudentDTO studentDTO = (StudentDTO) request.getAttribute("student");
            if (studentDTO != null) {%>
        <form action="update?page=<%=currentPage%>&id=<%=studentDTO.getId()%>" method="post">
            <label>
                <input class="first" name="name" value="<%=studentDTO.getName()%>" type="text" placeholder="<%=studentDTO.getName()%>">
            </label>
            <label>
                <input class="first" name="surname" value="<%=studentDTO.getSurname()%>" placeholder="<%=studentDTO.getSurname()%>" type="text">
            </label>
            <br/>
            <label>
                <input class="second" name="address" value="<%=studentDTO.getAddress()%>" placeholder="<%=studentDTO.getAddress()%>" type="text">
            </label>
            <br/>
            <label>
                <input class="third" name="age" value="<%=studentDTO.getAge()%>" placeholder="<%=studentDTO.getAge()%>" type="text">
            </label>
            <label>
                <input class="third" name="mark" value="<%=studentDTO.getMark()%>" placeholder="<%=studentDTO.getMark()%>" type="text">
            </label>
            <input class="create" type="submit">
            <button class="back"><a href="/index?page=<%=currentPage%>">Back</a></button>
        </form>
        <%
            }
        %>

        <div id="darkside">
            <div id="window">
                Adding a new student!<br>
                <form action="creating?page=<%=currentPage%>" method="post">
                    <label>
                        <input class="first" name="name" type="text" placeholder="Your name">
                    </label>
                    <label>
                        <input class="first" name="surname" placeholder="Your surname" type="text">
                    </label>
                    <br/>
                    <label>
                        <input class="second" name="address" placeholder="Your address" type="text">
                    </label>
                    <label>
                        <input class="second" name="email" placeholder="Your email" type="text">
                    </label>
                    <br/>
                    <label>
                        <input class="third" name="age" placeholder="Your age" type="text">
                    </label>
                    <label>
                        <input class="third" name="mark" placeholder="Your mark" type="text">
                    </label>

                    <input class="create" type="submit">
                    <button class="back"><a href="/index?page=<%=currentPage%>">Back</a></button>

                </form>
            </div>
        </div>

        <div align="center">
            <button><a href="#darkside">Add student</a></button>
        </div>


    </div>
    <div class="page-div">

        <%
            if (currentPage != 1) {
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
                        if (i == currentPage) {
                %>
                <td><%=i%>
                </td>
                <% } else {%>
                <td>
                    <form method="post" action="index?page=<%=i%>">
                        <button class="bottom-nav"><%=i%>
                        </button>
                    </form>
                </td>
                <%
                        }
                    }
                %>
            </tr>
        </table>

        <%
            if (currentPage < noOfPages) {
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