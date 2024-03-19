<%@ page import="DTO.StudentDTO" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0"/>
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />


    <style>
        /* table {
             margin: auto; !* Выравниваем таблицу по центру *!
         }
         td {
             text-align: center; !* Выравниваем текст по центру ячейки *!
         }*/

        #darkside {
            background: rgba(102, 102, 102, 0.7);
            width: 100%;
            height: 100%;
            align-items: center;
            position: absolute;
            top: 0;
            left: 0;
            display: none;
        }

        #window {
            width: 400px;
            height: 310px;
            text-align: center;
            padding: 15px;
            border: none;
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
        <button class="home-click" onclick="location.href='index?page=1&update=false';">Home</button>
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
                    <th class="empty">
                        <button style="border: none; background-color: white; cursor: pointer;" onclick="location.href='#darkside';"><span class="material-symbols-outlined">
                            add_box
                            </span></button>
                    </th>
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
                    <td style="padding-left: 25px" class="delete-link"><a href="deleteMe?id=<%=temp.getId()%>&page=<%=currentPage%>"><span class="material-symbols-outlined">
                        close
                        </span></a></td>
                    <td style="" class="delete-link">
                        <%--cyka--%>
                        <a href="update?id=<%=temp.getId()%>&page=<%=currentPage%>"><span class="material-symbols-outlined">
                            edit
                            </span></a>
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
                            <input class="second" style="width: 255px" name="address" placeholder="Your address" type="text">
                        </label>
                        <br/>
                        <label>
                            <input class="second" style="width: 255px" name="email" placeholder="Your email" type="text">
                        </label>
                        <br/>
                        <label>
                            <input class="second" style="width: 255px" name="age" placeholder="Your age" type="text">
                        </label>
                        <br/>
                        <label>
                            <input class="second" style="width: 255px" name="mark" placeholder="Your mark" type="text">
                        </label>

                        <input class="create" style="margin-left: 50px;" type="submit">
                        <button class="create" style="margin-left: 50px;" onclick="location.href='/index?page=<%=currentPage%>';">Back</button>

                    </form>
                </div>
            </div>



        </div>
        <div class="page-div" style="width: 50%; margin-left: 35%;">

            <%
                if (currentPage != 1) {
            %>
            <td style="display: inline-block">
                <form style="display: inline-block" method="post" action="index?page=<%=currentPage-1%>">
                    <button style="display: inline-block" class="bottom-nav"><span class="material-symbols-outlined">
                        arrow_back
                        </span></button>
                </form>
            </td>
            <%} %>



                    <%
                        if(noOfPages<5){

                        for (int i = 1; i <= noOfPages; i++) {
                            if (i == currentPage) {
                    %>
                    <%=i%>

                    <% } else {%>

                        <form style="display: inline-block" method="post" action="index?page=<%=i%>">
                            <button style="display: inline-block" class="bottom-nav"><%=i%>
                            </button>
                        </form>

                    <%

                                }
                            }
                        }else{
                    %>

                        <form style="display: inline-block" method="post" action="index?page=1">
                            <button style="display: inline-block" class="bottom-nav">1
                            </button>
                        </form>



                        <form style="display: inline-block" method="post" action="index?page=2">
                            <button style="display: inline-block" class="bottom-nav">2
                            </button>
                        </form>

                    <p style="display: inline-block"><%=currentPage%></p>


                        <form style="display: inline-block" method="post" action="index?page=<%=noOfPages-1%>">
                            <button style="display: inline-block" class="bottom-nav"><%=noOfPages-1%>
                            </button>
                        </form>
                        <form style="display: inline-block" method="post" action="index?page=<%=noOfPages%>">
                            <button style="display: inline-block" class="bottom-nav"><%=noOfPages%>
                            </button>
                        </form>
                    <% }%>


            <%
                if (currentPage < noOfPages) {
            %>
            <td>
                <form style="display: inline-block" method="post" action="index?page=<%=currentPage+1%>">
                    <button style="display: inline-block" class="bottom-nav"><span class="material-symbols-outlined">
                        arrow_forward
                        </span></button>
                </form>
            </td>
                    <% }%>

        </div>
    </div>

    <div style="width: 290px;"></div>
</div>

</body>
</html>