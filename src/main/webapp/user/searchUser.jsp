
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/11/2020
  Time: 4:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <style>
        .main{
            margin: 5px;
            background-color: black;
        }

        div.gallery {
            border: 3px solid cornflowerblue;
        }

        div.gallery:hover {
            background-color: royalblue;
            border: 1px solid #777;
        }

        div.gallery img {
            width: 100%;
            height: auto;
        }

        div.desc {
            padding: 15px;
            text-align: center;
        }

        * {
            box-sizing: border-box;
        }

        .responsive {
            padding: 0 6px;
            float: left;
            width: 24.99999%;
        }

        @media only screen and (max-width: 600px){
            .responsive {
                width: 49.99999%;
                margin: 6px 0;
            }
        }

        @media only screen and (max-width: 500px){
            .responsive {
                background-color: royalblue;
                width: 100%;
            }
        }

        .clearfix:after {
            content: "";
            display: table;
            clear: both;
        }
        .message{
            color: #bd081c;
            float: none;
        }
        body{
            font-family: Arial;
        }

        #menu{
            margin-right: 20px;
            height: 30px;
            padding:0;
            /*margin:0;*/
            background-color: #000000;
            border: 1px solid #CDCDCD;
        }

        #menu ul, #menu li{
            padding:0;
            margin:0;
        }

        #menu li{
            position: relative;
            float: left;
            list-style: none;
            margin: 0;
            padding:0;
        }

        #menu li a{
            width:100px;
            height: 30px;
            display: block;
            text-decoration:none;
            text-align: center;
            line-height: 30px;
            background-color: black;
            color: white;
        }

        #menu ul ul li a{
            width: 200px;
            text-align: left;
            padding-left: 10px;
        }

        #menu li a:hover{
            background-color: red;
        }

        #menu ul ul{
            position: absolute;
            top: 30px;
            left: 15px;
            visibility: hidden;
        }

        #menu ul li:hover ul{
            visibility: visible;
        }
        #xinchao{
            margin-left: 100px;
            color: white;
            font-size: 30px;
        }
        #xinchao1{
            margin-left: 100px;
            color: white;
            font-size: 30px;
        }
        #xinchao2{
            margin-left: 100px;
            color: white;
            font-size: 30px;
        }
        #top{
            /*position: fixed;*/
            /*    width: 100%;*/
        }
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="top">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <i class="fad fa-rocket-launch"></i>
        </li>

        <li class="nav-item active">
            <a class="nav-link" href="/video"><h1 style="font-family: monospace">వీడియో</h1></a>
        </li >

        <li class="nav-item active" id="xinchao2">
            <a href="user/dangnhap.jsp">ADD VIDEO</a>
        </li>
    </ul>



    <button type="button" class="btn btn-outline-secondary" style="margin-right: 30px" data-toggle="modal"
            data-target="#exampleModal">
        Login Admin
    </button>

    <!-- Modal -->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
         aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel" style="color: red;">Đăng nhập chỉ dành cho quản
                        trị viên trang web</h5>

                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form  action="/users" method="post">
                        <label>Tài khoản</label>
                        <input type="text" class="form-control" name="username" placeholder="account">
                        <label>Mật khẩu</label>
                        <input type="text" class="form-control" name="pass" placeholder="passwords">
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Đăng nhập</button>
                        </div>
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
                    </form>
                </div>

            </div>
        </div>
    </div>
    <div id="menu">
        <ul>

            <li><a href="#">login user</a>
                <ul>
                    <li><a href="/user/dangnhap.jsp">Login</a></li>
                    <li><a href="/user/dangky.jsp">New Account</a></li>
                    <li><a href="/logout">Log Out</a></li>
                </ul>
            </li>
        </ul>
    </div>
    <form class="form-inline my-2 my-lg-0" action="/users?action=searchByName">
        <input type="hidden" name="action" value="searchByName">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchByName">
        <button type="submit" class="btn btn-outline-secondary">TÌM KIẾM</button>
    </form>
</nav>
<h2>LIST USERS</h2>
<a href="/users">back to list user</a>
<%--<form action="/search">--%>
<%--    <input name="search" type="text" placeholder="search name">--%>
<%--    <input type="submit" value="search">--%>
<%--</form>--%>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Username</th>
        <th>Password</th>
        <%--        <th>Edit</th>--%>
        <th>Delete</th>
    </tr>

    <c:forEach items='${requestScope["user"]}' var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><a href="/viewPage?action=view&id=${user.getId()}">${user.getName()}</a></td>
            <td><c:out value="${user.userName}"/></td>
            <td><c:out value="${user.pass}"/></td>
            <td>
                    <%--            <a href="/users?action=edit&id=${user.id}">Edit</a>--%>
                <a href="/users?action=delete&id=${user.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
