
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增汇率</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>汇利率</small>
            </h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/exchangeRate/addER" method="post">
        <input type="hidden" name="page" value="IT/edit">
        <div class="form-group">
            <label>货币：</label>
            <input type="text" name="currency" class="form-control" required>
        </div>
        <div class="form-group">
            <label>名称：</label>
            <input type="text" name="name" class="form-control" required>
        </div>
        <div class="form-group">
            <label>数据：</label>
            <input type="text" name="data" class="form-control" readonly="readonly">
        </div>
        <!--//hidden方式添加数据状态,1正常，2增，3改，4删-->
        <div class="form-group">
            <label>状态：</label>
            <select name="status" class="form-control">
                <option value="1">显示</option>
                <option value="2" selected>新增</option>
                <option value="3">修改</option>
                <option value="4">删除</option>
            </select>
        </div>
       <!--//hidden方式添加数据类型 1利,2汇-->
        <div class="form-group">
            <label>类型：</label>
            <select name="type" class="form-control" class="form-control">
                <option value="1">利率</option>
                <option value="2">汇率</option>
            </select>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
</html>
