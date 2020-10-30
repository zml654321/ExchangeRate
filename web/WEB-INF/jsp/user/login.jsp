<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" >
    <div class="row">
        <div class="col-lg-4 col-lg-offset-4">
            <form class="form-signin" style="align-content: center;" action="${pageContext.request.contextPath}/user/login">
                <h2 class="form-signin-heading">Please sign in</h2>
                <label for="inputEmail" >UserName:</label>
                <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Username" required="" autofocus="">
                <label for="inputPassword" >Password:</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
                <br>
                <div class="row">
                    <div class="col-lg-4 ">
                        <button class="btn btn-lg btn-primary" type="submit">Sign in</button>
                    </div>
                    <div class="col-lg-4 col-lg-offset-4">
                        <button class="btn btn-lg btn-primary" type="submit">Resign</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="col-lg-4 col-lg-offset-4">
        <a href="${pageContext.request.contextPath}/exchangeRate/allResults">
            <button class="btn btn-lg btn-primary" type="submit">Resign</button>
        </a>
    </div>
</div> <!-- /container -->

</body>
</html>