<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .qty .count {
            color: #000;
            display: inline-block;
            vertical-align: top;
            font-size: 25px;
            font-weight: 700;
            line-height: 30px;
            padding: 0 2px
        ;min-width: 35px;
            text-align: center;
        }
        .qty .plus {
            cursor: pointer;
            display: inline-block;
            vertical-align: top;
            color: white;
            width: 30px;
            height: 30px;
            font: 30px/1 Arial,sans-serif;
            text-align: center;
            border-radius: 50%;
        }
        .qty .minus {
            cursor: pointer;
            display: inline-block;
            vertical-align: top;
            color: white;
            width: 30px;
            height: 30px;
            font: 30px/1 Arial,sans-serif;
            text-align: center;
            border-radius: 50%;
            background-clip: padding-box;
        }
        div {
            text-align: center;
        }
        .minus:hover{
            background-color: #717fe0 !important;
        }
        .plus:hover{
            background-color: #717fe0 !important;
        }
        /*Prevent text selection*/
        span{
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
        }
        input{
            border: 0;
            width: 2%;
        }
        nput::-webkit-outer-spin-button,
        input::-webkit-inner-spin-button {
            -webkit-appearance: none;
            margin: 0;
        }
        input:disabled{
            background-color:white;
        }



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
        #comment {
            border: 1px #243024;
            width: 700px;
            height: 200px;
            overflow-x: hidden;
            overflow-y: auto;
            text-align: left;
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
    <title>View customer</title>
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

<table>

    <tr>

<%--    <iframe width="560" height="315" src="https://www.youtube.com/embed/emqQcsu1nqo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>--%>
        <iframe width="100%" height="600px" src="https://www.youtube.com/embed/${requestScope["video"].getLink()}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        <h1>${requestScope["video"].getTitle()}</h1>

    <div class="qty mt-5">
        <input type="number" class="count" name="qty" value="8">
        <span class="plus bg-dark">✌ </span>
    </div>

        <td>des: </td>
        <td>${requestScope["video"].getDes()}</td>
    </tr>
    <tr>
        <td>id User: </td>
        <td>${requestScope["video"].getIdUser()}</td>
    </tr>
</table>


<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<script>
    $(document).ready(function(){
        $('.count').prop('disabled', true);
        $(document).on('click','.plus',function(){
            $('.count').val(parseInt($('.count').val()) + 1 );
        });
        $(document).on('click','.minus',function(){
            $('.count').val(parseInt($('.count').val()) - 1 );
            if ($('.count').val() == 0) {
                $('.count').val(1);
            }
        });
    });
</script>
<form action="/comment" method="post">
    <input type="text" class="form-control" name="comment" placeholder="input your comment..." >
    <br>

    <button type="submit" class="btn btn-outline-secondary" style="text-align: center">comment</button >
</form>

<div id="comment">
<c:forEach items='${requestScope["comments"]}' var="commentt">
    <h5>stranger :</h5>
        <p><c:out value="${commentt.comment}"/></p>

</c:forEach>
</div>

<h4>video đề xuất: </h4>
<hr style="border-color: red" >
<iframe width="560" height="315" src="https://www.youtube.com/embed/4xLklVAlcUM" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/q3Ng-eJV8ow" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/QMbFyGGm-nY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/emqQcsu1nqo" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/uiuHHq0NaoQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/tZQJsZU19q8" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/E8xlUAcsXYQ" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
<iframe width="560" height="315" src="https://www.youtube.com/embed/-BC3A5xlfMs" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</body>
</html>