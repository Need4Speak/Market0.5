<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <style type="text/css">
    .img-circle {
        width: 80px;
        height: 80px;
        margin: 20px 50%;
    }
    
    input {
        border-width: 0px;
        width: 100%;
        margin: 10px;
        height: auto;
        padding: 5px;
    }
    
    button {
    	background-color: #D9534F;
        margin-top: 20px;
    }
    </style>
</head>

<body>
    <div class="container">
        <div class="row clearfix">
            <div class="col-xs-12 column">
                <img alt="140x140" src="${webroot}/images/system/head.jpg" class="img-circle" />
            </div>
        </div>
        <form action="loginController?page=${requestScope.page}&goodId=${requestScope.goodId}" method="post">
	        <div class="row clearfix">
	            <div class="col-xs-2 column">
	                <p>账号</p>
	            </div>
	            <div class="col-xs-10 column">
	                <input type="text" name="userName" placeholder="请输入账号">
	            </div>
	        </div>
	        <div class="row clearfix">
	            <div class="col-xs-2 column">
	                <p>密码</p>
	            </div>
	            <div class="col-xs-10 column">
	                <input type="password" name="password" placeholder="请输入密码">
	            </div>
	        </div>
	        <div class="row clearfix">
	            <div class="col-xs-12 column">
	                <button type="submit" class="btn btn-block active"><span style="color:#FFFFFF">登录</span></button>
	            </div>
	        </div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>
