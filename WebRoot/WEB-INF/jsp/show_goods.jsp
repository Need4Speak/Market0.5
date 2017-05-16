<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <link href="${webroot}/css/main.css" rel="stylesheet" type="text/css" />
    <style type="text/css">

    .price {
        font-size: 16px;
        color: red;
        font-style: bold;
        text-align: right;
    }
    </style>
</head>

<body>
    <div class="container">
        <%@ include file="bar/categories_bar.jsp"%>
            <c:forEach items="${page.list}" var="good">
                <a href="goodInfoController?goodId=${good.goodId}">
                    <div class="row clearfix divcss5">
                        <div class="col-xs-4 column aligncenter">
                            <div class="aligncenter">
                                <img alt="140x140" src="${webroot}/images/${good.userByOwnerId.userName}/goodPics/${fn:split(good.pictures, ', ')[0]}" class="img-rounded imgcss5" />
                            </div>
                        </div>
                        <div class="col-xs-4 column ">
                            <div class="div-heighthalf">
                                <p class="text-left center-vertical">
                                    <strong>${good.name}</strong>
                                </p>
                            </div>
                            <div class="div-heighthalf">
                                <p class="text-left center-vertical">
                                    <strong>卖家:${good.userByOwnerId.userName}</strong>
                                </p>
                            </div>
                        </div>
                        <div class="col-xs-4 column div-heightfull">
                            <div class="div-heighthalf">
                                <p class="text-right center-vertical price">
                                    <strong>￥${good.price}</strong>
                                </p>
                            </div>
                            <div class="div-heighthalf">
                                <p class="text-right center-vertical">
                                    <strong>望江校区</strong>
                                </p>
                            </div>
                        </div>
                    </div>
                </a>
            </c:forEach>
            <div class="row clearfix" style="margin-bottom: 60px;margin-top: 20px;text-align: center;">
                <div class="col-xs-12 column" style="height: 50px">
                    <p>共${page.totalRecords}条记录 共${page.totalPages}页 当前第${page.pageNo}页</p>
                </div>
                <div class="col-xs-12 column">
                    <div class="btn-group btn-group-md">
                        <button class="btn btn-default" type="button" onclick="{location.href='IndexController?pageNo=${page.topPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 首页
                        </button>
                        <c:choose>
                            <c:when test="${page.pageNo!=1}">
                                <button class="btn btn-default" type="button" onclick="{location.href='IndexController?pageNo=${page.previousPageNo}'}">
                                    <em class="glyphicon glyphicon-align-left"></em> 上一页
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default" type="button" disabled="disabled">
                                    <em class="glyphicon glyphicon-align-left"></em> 上一页
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <c:choose>
                            <c:when test="${page.pageNo != page.totalPages}">
                                <button class="btn btn-default" type="button" onclick="{location.href='IndexController?pageNo=${page.nextPageNo}'}">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-default" type="button" disabled="disabled">
                                    <em class="glyphicon glyphicon-align-right"></em> 下一页
                                </button>
                            </c:otherwise>
                        </c:choose>
                        <button class="btn btn-default" type="button" onclick="{location.href='IndexController?pageNo=${page.bottomPageNo}'}">
                            <em class="glyphicon glyphicon-align-justify"></em> 尾页
                        </button>
                    </div>
                </div>
            </div>
            <%@ include file="bar/foot_bar.jsp"%>
    </div>
</body>

</html>

