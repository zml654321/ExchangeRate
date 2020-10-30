
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>新增汇利率</small>
            </h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/exchangeRate/updateER" method="post">
        <input type="hidden" name="id" value="${Qer.id}">
        <div class="form-group">
            <label>货币：</label>
            <input type="text" name="currency" value="${Qer.currency}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>名称：</label>
            <input type="text" name="name" value="${Qer.name}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>数据：</label>
            <input type="text" name="data" value="${Qer.data}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>状态：</label>
            <input type="text" name="status" value="${Qer.status}" class="form-control" required>
        </div>
        <div class="form-group">
            <label>类型：</label>
            <input type="text" name="type" value="${Qer.type}" class="form-control" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>
</body>
</html>
