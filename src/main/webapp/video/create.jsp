<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>






        div.gallery img {
            width: 100%;
            height: auto;
        }



        * {
            box-sizing: border-box;
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
    <title>Create new customer</title>
    <style>
        .message{
            color:green;
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
    <form class="form-inline my-2 my-lg-0" action="/video?action=searchByName">
        <input type="hidden" name="action" value="searchByName">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchByName">
        <button type="submit" class="btn btn-outline-secondary">TÌM KIẾM</button>
    </form>
</nav>
<h1>Create new Video</h1>
<p>
    <c:if test='${requestScope["message"] != null}'>
        <span class="message">${requestScope["message"]}</span>
    </c:if>
</p>

<meta name="viewport" content="width=device-width,initial-scale=1">
<div class="container">

    <form role="form" method="post">
            <input type="hidden" name="action" value="create">
        <div class="form-group">
            <label for="name">Title Video</label>
            <input type="text" class="form-control" id="name" placeholder="Enter Title" name="title">
        </div>
        <div class = "form-group">
            <label form = "name">describe video</label>
            <textarea class = "form-control" rows = "3" name="des"></textarea>
<%--            <input type="text" name="des">--%>
        </div>
        <div class="form-group">
            <label for="inputfile">File image input</label>
            <input type="file" id="inputfile" name="image">
<%--            <p class="form-text">Example block-level help text here.</p>--%>
<%--            <input type="text" name="image">--%>
        </div>
        <div class="form-group">
            <label for="inputfile">File video input</label>
            <input type="file" id="inputfile1" name="link">
<%--            <p class="form-text">Example block-level help text here.</p>--%>
<%--            <input type="text" name="link">--%>
        </div>
        <div class="form-group">
            <label for="name"> your ID </label>
            <input type="text" class="form-control" id="name1" placeholder="Enter Title" name="idUser">
        </div>

        <button type="submit" class="btn btn-secondary">create</button>


    </form>
</div>

</body>
</html>