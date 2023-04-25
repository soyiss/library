<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-04-25
  Time: 오전 9:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>list.jsp</h2>
    <table class="table table-dark table-hover">
        <tr>
            <th>id</th>
            <th>name</th>
<%--            <th>publisher</th>--%>
<%--            <th>Author</th>--%>
<%--            <th>price</th>--%>
            <th>조회</th>
        </tr>
        <%-- c:forEach는 jsp문법이다        --%>
        <%-- items: 반복할 대상, var: 반복변수  --%>
        <%-- 자바로 표현해 봤을땐.. for(StudentDTO s: studentList)로 표현한다   --%>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td> ${book.id}</td>
                <td> ${book.bookName}</td>
<%--                <td> ${book.bookPublisher}</td>--%>
<%--                <td> ${book.bookAuthor}</td>--%>
<%--                <td> ${book.bookPrice}</td>--%>
                <td>
                    <%-- 상세조회를 위한 요청주소: detail
                         같이 보내줘야 하는 값: id
                         detail 요청을 처리하는 컨트롤러 메서드를 만들고
                         조회결과를 detail.jsp에 출력하자.
                         BookRepository에서는 sql.selectOne() 을 사용하고
                         mapper 에서는 parameterType = "Long"으로 주고
                         resultType = "book"으로 하면 됩니다.
                         --%>


            <%-- id=${boook.id} foreach 반복문안에있어서 사용 가능하다--%>
            <%-- foreach안에는 하나의 책에 대한 id가 돌고있음--%>
                    <a href="/detail?id=${book.id}">조회</a>
                </td>
            </tr>
        </c:forEach>

    </table>
</body>
</html>
