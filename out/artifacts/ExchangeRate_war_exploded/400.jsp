
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
400
</body>
