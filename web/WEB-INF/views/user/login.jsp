<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
<h1>LOGIN</h1>
<div>
    <span>${requestScope.err}</span>
</div>
<a href="/user/join"><h1>회원가입</h1></a>
<form action="/user/login" method="post">
    <div>
        <input type="text" name="uid" placeholder="User Id">
    </div>
    <div>
        <input type="password" name="upw" placeholder="User Password">
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</body>
</html>