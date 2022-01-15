<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <div><span>${err}</span></div>
    <table>
        <thead>
        <tr>
            <th>방번호</th>
            <th>방제목</th>
            <th>방장</th>
        </tr>
        </thead>
        <tbody>

            <c:forEach var="list" items="${requestScope.roomList}">
            <tr id="clickTr" data-iroom="${list.iroom}">
                <td><span>${list.iroom}</span></td>
                <td><span>${list.rnm}</span></td>
                <td><span>${list.rmaster}</span></td>
            </tr>
            </c:forEach>

        </tbody>
    </table>
</div>
<div id="divElem">
    <a href="/chat/createroom"><button>방만들기</button></a>
</div>