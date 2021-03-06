<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>汇利率编辑界面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script language="javascript" type="text/javascript">
        window.onload = function(){
            var oTable = document.getElementById("erTable");
            for(var i=1;i<oTable.rows.length;i++){
                oTable.rows[i].cells[0].innerHTML = (i);
            }
        }
    </script>
    <script type="text/javascript">
        function deleteOne(id,currency,name,data) {
            var res=confirm('确定删除数据?'+
                '\r货币为：'+currency+
                '\r名称为：'+name+
                '\r数据为：'+data
            );
            var page='IT/edit';
            if(res){
                    window.location.href='${pageContext.request.contextPath}/exchangeRate/deleteById?id='+id+'&page='+page;
            }
        }
    </script>
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>汇利率编辑界面</small>
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <!--新增书籍-->
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/exchangeRate/toAddERPage?page=${"IT/add"}">新增利率</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/exchangeRate/queryER?page=${"/IT/edit"}">查询全部利率</a>
        </div>
        <div class="col-md-6 column">
            <!--根据书籍名称搜索-->
            <form class="form-inline" action="${pageContext.request.contextPath}/exchangeRate/queryByName" method="post" style="float: right">
                <span style="color: red;font-weight:bold">${error}</span>
                <input type="hidden" name="page" value="IT/edit">
                <input type="text" name="name" class="form-control" placeholder="请输入查询关键字">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
        <div class="col-md-2 column">
            <p>
                <a href="${pageContext.request.contextPath}/user/goOut?name=IT">
                    <span class="glyphicon glyphicon-user" aria-hidden="true">${IT}</span>&nbsp;
                </a>
            </p>
        </div>
    </div>


    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" id="erTable">
                <thead>
                <tr>
                    <th>汇利率编号</th>
                    <th>货币</th>
                    <th>名称</th>
                    <th>数据</th>
                    <th>状态</th>
                    <th>类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <%--书籍从数据库中查询出来，从这个list中遍历出来：foreach--%>
                <tbody>
                <c:forEach var="IR" items="${list}">
                    <tr>
                        <td></td>
                        <td>${IR.currency}</td>
                        <td>${IR.name}</td>
                        <td>${IR.data}</td>
                        <td>
                            <c:if test="${IR.status==1}">
                                显示
                            </c:if>
                            <c:if test="${IR.status==2}">
                                新增
                            </c:if>
                            <c:if test="${IR.status==3}">
                                修改
                            </c:if>
                            <c:if test="${IR.status==4}">
                                删除
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${IR.type==1}">
                                利率
                            </c:if>
                            <c:if test="${IR.type==2}">
                                汇率
                            </c:if>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/exchangeRate/toERUpdate?id=${IR.id}&page=${"IT/update"}">修改</a>
                            &nbsp;|&nbsp;
                            <a href="javascript:void(0);" onclick="deleteOne('${IR.id}','${IR.currency}','${IR.name}','${IR.data}')">删除</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

</div>

</body>
</html>
