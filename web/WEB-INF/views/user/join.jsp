<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>
    <form action="/user/join" method="post">
        <div>
            <input type="text" name="uid" placeholder="User ID">
        </div>
        <div>
            <input type="password" name="upw" placeholder="User Password">
        </div>
        <div>
            <input type="text" name="nm" placeholder="User Name">
        </div>
        <div>
            <input type="submit" value="JOIN">
        </div>
    </form>
</body>
</html>