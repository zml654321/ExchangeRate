<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>汇率录入</title>
    <script language="javascript" type="text/javascript">
        window.onload = function(){
            var oTable = document.getElementById("erTable");
            for(var i=1;i<oTable.rows.length;i++){
                oTable.rows[i].cells[0].innerHTML = (i);
            }
        }
    </script>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>汇率录入</small>
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="col-md-4 column">
            <!--新增书籍-->
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/exchangeRate/queryER?page=${"/ER/edit"}">查询全部汇率</a>
        </div>
        <div class="col-md-6 column">
            <!--根据书籍名称搜索-->
            <form class="form-inline" action="${pageContext.request.contextPath}/exchangeRate/queryByName" method="post" style="float: right">
                <span style="color: red;font-weight:bold">${error}</span>
                <input type="hidden" name="page" value="ER/edit">
                <input type="text" name="name" class="form-control" placeholder="请输入查询关键字">
                <input type="submit" value="查询" class="btn btn-primary">
            </form>
        </div>
        <div class="col-md-2 column">
            <p>
                <a href="${pageContext.request.contextPath}/user/goOut?name=EREdit">
                    <span class="glyphicon glyphicon-user" aria-hidden="true">${EREdit}</span>&nbsp;
                </a>
            </p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" id="erTable">
                <thead>
                <tr>
                    <th>汇率编号</th>
                    <th>货币</th>
                    <th>名称</th>
                    <th>数据</th>
                    <th>修改后数据</th>
                    <th>状态</th>
                    <th>类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <%--书籍从数据库中查询出来，从这个list中遍历出来：foreach--%>
                <tbody>
                <c:forEach var="ER" items="${list}">
                    <tr>
                        <td></td>
                        <td>${ER.currency}</td>
                        <td>${ER.name}</td>
                        <td>${ER.data}</td>
                        <td>${ER.data_memory}</td>
                        <td>
                            <c:if test="${ER.status==1}">
                                完成
                            </c:if>
                            <c:if test="${ER.status==2}">
                                新增未放行
                            </c:if>
                            <c:if test="${ER.status==3}">
                                修改未放行
                            </c:if>
                            <c:if test="${ER.status==4}">
                                删除未放行
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${ER.type==1}">
                                利率
                            </c:if>
                            <c:if test="${ER.type==2}">
                                汇率
                            </c:if>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/exchangeRate/toERUpdate?id=${ER.id}&page=${"ER/update"}">修改</a>
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
