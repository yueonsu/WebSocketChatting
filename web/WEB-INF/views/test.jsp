<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <h1>List</h1>
    <div data-ddd="${sessionScope.loginUser}"></div>
    <form action="/test" method="post">
        <input type="text" name="loginid">
        <input type="submit" value="Login">
    </form>
</body>
</html>