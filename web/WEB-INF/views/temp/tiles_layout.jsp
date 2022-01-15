<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/res/css/<tiles:getAsString name="addr2"/>.css">
    <title></title>
</head>
<body>
    <tiles:insertAttribute name="header"/>
    <section>
        <tiles:insertAttribute name="content"/>
    </section>
    <tiles:insertAttribute name="footer"/>
    <script src="/res/js/<tiles:getAsString name="addr2"/>.js"></script>
</body>
</html>