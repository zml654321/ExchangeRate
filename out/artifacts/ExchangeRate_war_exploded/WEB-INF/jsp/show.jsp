<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${currency}</title>
    <script language="javascript" type="text/javascript">
        window.onload = function(){
            var oTable = document.getElementById("erTable");
            for(var i=1;i<oTable.rows.length;i++){
                oTable.rows[i].cells[0].innerHTML = (i);
            }
        }
    </script>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>
                <small>${currency}</small>
            </h1>
        </div>
        <form action="/showDetail" method="post" id="show">
        </form>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" id="erTable">
                <thead>
                <tr>
                    <th>编号</th>
                    <th>货币</th>
                    <th>名称</th>
                    <th>数据</th>
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
