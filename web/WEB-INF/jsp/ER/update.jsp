
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汇率更新</title>
    <script>
        function Submit(currency,name,data){
            var y=document.getElementById("data_memory");
            var data_memory=y.value;
            var res=confirm('确定修改数据?'+
                            '\r货币为：'+currency+
                            '\r名称为：'+name+
                            '\r修改前数据为：'+data+
                            '\r修改后数据为：'+data_memory);
            if(res){
                /*
                var form = document.getElementById('test_form');
                    //再次修改input内容
                    form.submit();
                 */
                var  form=document.getElementById('form1');
                form.submit();
            }
        }
    </script>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>修改汇率</small>
            </h1>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/exchangeRate/updateER" id="form1" method="post">
        <input type="hidden" name="page" value="ER/edit">
        <input type="hidden" name="id" value="${Qer.id}">
        <div class="form-group">
            <label>货币：</label>
            <input type="text" name="currency" value="${Qer.currency}" class="form-control" required readonly="readonly">
        </div>
        <div class="form-group">
            <label>名称：</label>
            <input type="text" name="name" value="${Qer.name}" class="form-control" required readonly="readonly">
        </div>
        <!--提交修改前数据-->
        <input type="hidden" name="data" value="${Qer.data}">
        <!--数据修改界面-->
        <div class="form-group">
            <label>数据：</label>
            <input type="text" name="data_memory" value="${Qer.data}" id="data_memory" class="form-control" required>
        </div>
        <!--//hidden方式添加数据状态,1正常，2增，3改，4删-->
            <input type="hidden" name="status" value="3" class="form-control" required>
        <!--//hidden方式添加数据类型 1利,2汇-->
            <input type="hidden" name="type" value="${Qer.type}" class="form-control" required>
        <div class="form-group">
            <input type="button" class="form-control" value="修改" onclick="Submit('${Qer.currency}','${Qer.name}','${Qer.data}')">
        </div>
    </form>
</div>
</body>
</html>
