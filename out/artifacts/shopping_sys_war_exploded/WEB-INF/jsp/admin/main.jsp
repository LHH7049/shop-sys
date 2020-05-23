<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>后台管理系统</title>

    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.5.1.js" ></script>

</head>
<body>
<!--欢迎区域-->
<div class="top">
    <p>欢迎进入后台管理系统</p>
</div>

<!--管理区域-->
<div class="manage container">
    <div class="manage-type clearfix">
        <ul class="nav nav-tabs" id="m-list">
            <li id="sp-m"><a href="#">商品管理</a></li>
            <li id="type-m"><a href="#">类型管理</a></li>
            <li id="user-m"><a href="#">用户管理</a></li>
            <li id="order-m"><a href="#">订单管理</a></li>
            <li id="advice-m"><a href="#">公告管理</a></li>
            <li id="quite-m"><a href="#">安全退出</a></li>
            <div >
                <div style="display: inline-block; z-index: 1;">
                    <input id="search-text" type="text" class="form-control"  placeholder="请选择一个管理内容" />
                </div>
                <input id="search-btn" type="button" class="btn btn-primary" style="z-index:2;"  value="搜索"/>
                <a class="btn btn-primary" id="add-btn" style="float: right;" href="#" ></a>
            </div>

        </ul>
    </div>
    <div class="detail-m" id="sp-all">
        <table class="table table-striped">
            <thead id="thead"></thead>
            <tbody id="tbody"></tbody>
        </table>
    </div>
    <div >
        <ul class="pagination" id="pages">
        </ul>
    </div>
</div>

<!--页尾区域-->
<footer id="footer">
    <div class="container tail">
        <p>Copyright @hhlz</p>
    </div>
</footer>

</body>

<script language="JavaScript" src="${pageContext.request.contextPath}/js/goodTableJS.js"></script>

</html>
