
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
                <small>新增利率</small>
            </h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/exchangeRate/addER" method="post">
        <input type="hidden" name="page" value="IR/edit">
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
            <input type="text" name="data" class="form-control" required>
        </div>
        <!--//hidden方式添加数据状态,1正常，2增，3改，4删-->
            <input type="hidden" name="status" class="form-control" value="2">
       <!--//hidden方式添加数据类型 1利,2汇-->
            <input type="hidden" name="type" class="form-control"  value="1">
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
</html>
