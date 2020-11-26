
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>新增汇利率</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/jquery-3.5.1.js"></script>
    <script type="text/javascript">
        function Submit(){
            var currency=document.getElementById("currency");
            var name=document.getElementById("name");
            var status=document.getElementById("status");
            var type=document.getElementById("type");
                var res=confirm('确定新增数据?'+
                    '\r类型为：'+$("#type option:checked").text()+
                    '\r状态为：'+$("#status option:checked").text()+
                    '\r货币为：'+currency.value+
                    '\r名称为：'+name.value
                    );
                if(res){
                 return true;
                }else{
                    return false;
                }
        }
    </script>
    <script type="text/javascript">
        function back() {
            window.location.href='${pageContext.request.contextPath}/exchangeRate/queryER?page=${"/IT/edit"}';
        }
    </script>
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
    <form action="${pageContext.request.contextPath}/exchangeRate/addER" method="post" onsubmit="return Submit()">
        <input type="hidden" name="page" value="IT/edit">
        <!--//hidden方式添加数据类型 1利,2汇-->
        <div class="form-group">
            <label>类型：</label>
            <select name="type" id="type" class="form-control">
                <option value="1">利率</option>
                <option value="2">汇率</option>
            </select>
        </div>
        <!--//hidden方式添加数据状态,1正常，2增，3改，4删-->
        <div class="form-group">
            <label>状态：</label>
            <select name="status" id="status" class="form-control">
                <option value="1">显示</option>
                <option value="2" selected>新增</option>
                <option value="3">修改</option>
                <option value="4">删除</option>
            </select>
        </div>
        <div class="form-group">
            <label>货币：</label>
            <input type="text" name="currency" id="currency" class="form-control" required>
        </div>
        <div class="form-group">
            <label>名称：</label>
            <input type="text" name="name" id="name" class="form-control" required>
        </div>
        <div class="form-group">
            <label>数据：</label>
            <input type="text" name="data" id="data" class="form-control" readonly="readonly">
        </div>

        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
        <div class="form-group">
            <input type="button" class="form-control" value="返回" onclick="back()">
        </div>
    </form>
</div>
</body>
</html>
