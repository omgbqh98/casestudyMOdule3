<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 9/25/2020
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        .nen{
            margin-top: 60px;
        }
    </style>
    <title>your Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" id="top">
    <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
            <i class="fad fa-rocket-launch"></i>
        </li>

        <li class="nav-item active">
            <a class="nav-link" href="/index.jsp"><h1 style="font-family: monospace">వీడియో</h1></a>
        </li >
        <li class="nav-item active" id="xinchao">
            Hello
            <a href="">
                <%
                    User user = (User) session.getAttribute("user");
                    if(user!=null){
                        out.println(user.getName());
                    }%>
            </a>
        </li>
        <li class="nav-item active" id="xinchao1">
            ID:
            <%
                if (user != null) {
                    out.print(user.getId());
                }
            %>
        </li>
        <li class="nav-item active" id="xinchao2">
            <a href="/video?action=create">ADD VIDEO</a>
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
    <form class="form-inline my-2 my-lg-0" action="/video?action=searchByName" method="post">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="search">
        <button type="submit" class="btn btn-outline-secondary">TÌM KIẾM</button>
    </form>
</nav>
<div class="nen">
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="../anhbia.jpg" alt="First slide" style="width: 50% ; height: 300px">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../anhbia2.jpg" alt="Second slide" style="width: 50% ; height: 300px">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="../hinhbia3.jpg" alt="Third slide" style="width: 50%; height: 300px">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<div>
    <div class="container">
        <%--        <p style="margin-top: 50px">SẢN PHẨM <i style="color: red">V&T SHOWROOM</i></p>--%>
        <c:if test='${requestScope["message"] != null}'>
            <span class="message">${requestScope["message"]}</span> <br>
        </c:if>
        <h1>your videos</h1>
        <hr>
        <div class="row">
            <%--            <center>--%>
            <%--                <table cellpadding="10px">--%>
            <c:forEach var="video" items="${videos}">
                <%--                <div class="main" >--%>
                <div class="responsive">
                    <div class="gallery">
                        <a  target="_blank" href="/video?action=view&id=${video.getIdVideo()}"><img src="${video.getImage()}" width="550" height="550"></a>
                        <div class="desc">${video.getTitle()}</div>
                            <%--                            <div class="desc">${video.getDes()}</div>--%>
<%--                        <div class="desc">${video.getIdUser()}</div>--%>
                        <div class="desc"><a href="/video?action=edit&id=${video.getIdVideo()}" class="btn btn-secondary">EDIT</a></div>
                        <div class="desc"><a href="/video?action=delete&id=${video.getIdVideo()}" class="btn btn-danger">DELETE</a></div>
                    </div>
                </div>
                <%--                </div>--%>
            </c:forEach>
            <%--                </table>--%>
            <%--            </center>--%>
        </div>
    </div>
</div>
<%--<footer>--%>
<%--    <hr>--%>
<%--    <div class="footer-copyright text-center py-3">© 2020 Copyright:--%>
<%--        <a href="#"> T&V Car</a>--%>
<%--        HOTLINE:<a href="$">0999.686.868</a>--%>
<%--    </div>--%>
<%--</footer>--%>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</html>