<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="webroot" value="${pageContext.request.contextPath}" />
<style type="text/css">
.categories {
    text-align: center;
    font-size: 18px;
}

.whiteFont {
    color: #FFFFFF;
}
</style>
<div class="row clearfix" style="margin-top: 60px;">
    <div class="col-xs-12 column">
        <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
            <div class="categories" style="height:auto; border:0px; padding:12px;background:#d9534f;">
                <table border="0" cellpadding="0" cellspacing="0" width="100%">
                    <tr>
                        <td style="width:20%;">
                            <div>
                                <a href="${webroot}/GoodController/goodsWithClassificationController?classificationId=2"><span class="whiteFont">电子</span></a>
                            </div>
                        </td>
                        <td style="width:20%;">
                            <div>
                                <a href="${webroot}/GoodController/goodsWithClassificationController?classificationId=3"><span class="whiteFont">服装</span></a>
                            </div>
                        </td>
                        <td style="width: 20%;">
                            <div>
                                <a href="${webroot}/GoodController/goodsWithClassificationController?classificationId=4"><span class="whiteFont">美妆</span></a>
                            </div>
                        </td>
                        <td style="width: 20%;">
                            <div>
                                <a href="${webroot}/GoodController/goodsWithClassificationController?classificationId=5"><span class="whiteFont">食品</span></a>
                            </div>
                        </td>
                        <td style="width: 20%;">
                            <div>
                                <a href="${webroot}/GoodController/goodsWithClassificationController?classificationId=6"><span class="whiteFont">图书</span></a>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
        </nav>
    </div>
</div>
