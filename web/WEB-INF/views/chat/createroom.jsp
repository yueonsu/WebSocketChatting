<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/chat/createroom" method="post">
    <div>
        <input type="hidden" name="room_master" value="${sessionScope.loginUser.iuser}">
        <input type="text" name="rnm" placeholder="방 제목 입력">
    </div>
    <div>
        <input type="submit" value="생성">
    </div>
</form>