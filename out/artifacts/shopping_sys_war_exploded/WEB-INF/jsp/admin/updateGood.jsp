<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>商品详情</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script rel="stylesheet" src="${pageContext.request.contextPath}/js/jquery-3.5.1.js"></script>
</head>
<body>
<div>
    <h1 style="text-align: center;line-height: 50px;">商品详情</h1>
</div>
<form class="form-horizontal" action="${pageContext.request.contextPath}/good/updateGood" method="post">
    <div class="form-group">
        <label class="col-sm-4 control-label">商品名称</label>
        <div class="col-sm-5">
            <input type="text" name="gname" class="form-control" placeholder="商品名称" value="${oldGood.gname}" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">出厂价</label>
        <div class="col-sm-5">
            <input type="text" name="goprice" class="form-control" placeholder="出厂价" value="${oldGood.goprice}" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">售价</label>
        <div class="col-sm-5">
            <input type="text" name="grprice" class="form-control" placeholder="售价" value="${oldGood.grprice}" required/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-4 control-label">库存</label>
        <div class="col-sm-5">
            <input type="text" name="gstore" class="form-control" placeholder="库存" value="${oldGood.gstore}" required/>
        </div>
    </div>
    <div class="form-group ">
        <a href="#" class="col-sm-offset-6">图片上传</a>
    </div>

    <div class="form-group ">
        <!--下拉-->
        <div class="dropdown">
            <label class="col-sm-4 control-label">商品类型</label>
            <div class="col-sm-5">
                <input type="text" class="form-control dropdown-toggle" name="goodstype_id" id="dropdownMenu" data-toggle="dropdown" placeholder="商品类型" value="${oldGood.goodstype_id}" required/>
                <ul id="dd-menu" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu">
                    <c:forEach var="type" items="${type}">
                        <li role="presentation">
                            <a role="menuitem" tabindex="-1" onclick="type_click(${type.id})" >${type.typename}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <%--传入id--%>
            <input type="hidden" name="id" value="${oldGood.id}"/>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-4 col-sm-10">
            <input type="submit" class="btn btn-default" onclick="judge()" value="保存" />
        </div>
    </div>
</form>
</body>
<script language="JavaScript">

    function type_click(id) {
        $("#dropdownMenu").val(id);
    }

    function judge() {
        if ($("input[name='gname']").val() != ""
            && $("input[name='goprice']").val() != ""
            && $("input[name='grprice']").val() != ""
            && $("input[name='gstore']").val() != ""
            && $("input[name='goodstype_id']").val() != ""
        ){
            alert("保存成功");
            return true;
        }else {
            alert("保存失败");
            return false;
        }
    }


</script>
</html>
