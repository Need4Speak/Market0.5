<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML>
<html>

<head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入 Bootstrap -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="main.css" rel="stylesheet" type="text/css"/>
</head>

<body>
    <div class="container">
    	<%@ include file="bar/categories_bar.jsp"%>
    	<div class="row clearfix" style="margin-top: 50px;">
            <div class="col-xs-12 column">
            	<div class="panel panel-default">
            		<div class="panel-heading text-center">
            			<h1 class="panel-title">修改商品信息</h1>
            		</div>
            		<div class="panel-body text-center">
			            <form action="${webroot}/GoodController/goodUpdateController?goodId=${good.goodId}" method="post">
			                <fieldset>
			                    <p>
			                        <label for="name">商品名: &nbsp&nbsp&nbsp</label>
			                        <input id="name" name="name" value="${good.name}" />
			                    </p>
			                    <p>
			                        <label for="price">价格： &nbsp&nbsp&nbsp&nbsp</label>
			                        <input id="price" name="price" value="${good.price}" />
			                    </p>
			                    <p>
			                        <label for="description">详细介绍: </label>
			                        <input id="description" name="description"  value="${good.description}" />
			                    </p>
			                    <p id="buttons">
			                        <input id="reset" type="reset" tabindex="4">
			                        <input id="submit" type="submit" tabindex="5" value="确认修改">
			                    </p>
			                </fieldset>
			            </form>
			        </div>
			    </div>
        	</div>
        </div>
        <%@ include file="bar/foot_bar.jsp"%>
    </div>
</body>

</html>

